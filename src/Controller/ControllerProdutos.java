package Controller;

import Model.*;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import static Controller.ControllerAutores.autores;
import static Controller.ControllerCategoria.categorias;


public class ControllerProdutos {

    public ControllerAutores controllerAutores;

    public ControllerProdutos(ControllerAutores controllerAutores) {
        this.controllerAutores = controllerAutores;
    }

    public static ArrayList<Produto> produtos = new ArrayList<>();

    public void lerProdutosDeFicheiro() {
        ArrayList<String> linhasProduto = GestorFicheiros.LerFicheiro("produtos.txt");
        ArrayList<String> linhasLivro = GestorFicheiros.LerFicheiro("livros.txt");
        ArrayList<String> linhasCD = GestorFicheiros.LerFicheiro("cd.txt");

        for (String linha : linhasProduto) {
            if (!linha.isEmpty()) {
                String[] value_split_produto = linha.split("\\|");
                if (value_split_produto.length != 0) {
                    Produto aux = null;
                    if (Objects.equals(value_split_produto[1], "livro")) {
                        // se é do tipo livro, vamos ter que procurar no ficheiro de livros a linha correspondente
                        String[] value_split_livro = null;
                        Autor autor = null;
                        for (String linhaLivro : linhasLivro) {
                            if (linhaLivro.startsWith(value_split_produto[0])) {
                                value_split_livro = linha.split("\\|");
                                String autorLido = value_split_produto[4];
                                autor = controllerAutores.pesquisarAutorPorNomeTESTE(autorLido);
                            }
                        }

                        assert value_split_livro != null;
                        aux = new Livro(
                                Integer.parseInt(value_split_produto[0]),
                                value_split_produto[2],
                                Integer.parseInt(value_split_produto[3]),
                                autor,
                                new Categoria(value_split_produto[5]),
                                LocalDate.parse(value_split_produto[6]),
                                value_split_produto[7],
                                value_split_produto[8],
                                value_split_livro[1],
                                value_split_livro[2],
                                Integer.parseInt(value_split_livro[3])
                        );
                    }else if (Objects.equals(value_split_produto[1], "CD")){
                        String[] value_split_cd = null;
                        Autor autor = null;
                        for (String linhaCD : linhasCD){
                            if (linhaCD.startsWith(value_split_produto[0])){
                                value_split_cd = linhaCD.split("\\|");
                                String autorLido = value_split_produto[4];
                                autor = controllerAutores.pesquisarAutorPorNomeTESTE(autorLido);
                            }
                        }

                        assert value_split_cd != null;

                        aux = new CD(
                                Integer.parseInt(value_split_produto[0]),
                                value_split_produto[2],
                                Integer.parseInt(value_split_produto[3]),
                                autor,
                                new Categoria(value_split_produto[5]),
                                LocalDate.parse(value_split_produto[6]),
                                value_split_produto[7],
                                value_split_produto[8],
                                Integer.parseInt(value_split_cd[1])
                        );
                    }
                    produtos.add(aux);
                }
            }
        }

    }


    public void gravarProdutosParaFicheiro() {
        String conteudoProduto = "";
        String conteudoLivro = "";
        String conteudoCD = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Produto aux : produtos) {
            String formated_date = aux.getDataDePublicacao().format(formatter);

            conteudoProduto += aux.getId() + "|"; //0
            conteudoProduto += aux.getTipo() + "|"; //1
            conteudoProduto += aux.getTitulo() + "|"; //2
            conteudoProduto += aux.getQuantidade() + "|"; // 3
            conteudoProduto += aux.getAutor().getNome() + "|"; // 4
            conteudoProduto += aux.getCategoria().getNome() + "|";// 5
            conteudoProduto += formated_date + "|";// 6
            conteudoProduto += aux.getFaixaEtaria() + "|"; // 7
            conteudoProduto += aux.getEditora() + "|" + "\n";  // 8

            if (aux.getTipo().equalsIgnoreCase("livro")) {
                Livro livro = (Livro) aux;
                conteudoLivro += aux.getId() + "|";
                conteudoLivro += livro.getSubtitulo() + "|";
                conteudoLivro += livro.getNumDePaginas() + "|";
                conteudoLivro += livro.getISBN() + "\n";
            } else if (aux.getTipo().equalsIgnoreCase("cd")) {
                //...fazer igual para CD
                CD cd = (CD) aux;
                conteudoCD += aux.getId() + "|";
                conteudoCD += cd.getNumCapitulos() + "\n";
            }
        }
        GestorFicheiros.gravarFicheiro("produtos.txt", conteudoProduto);
        GestorFicheiros.gravarFicheiro("livros.txt", conteudoLivro);
        GestorFicheiros.gravarFicheiro("cd.txt", conteudoCD);
    }

    public ArrayList<Livro> listarProdutosLivros() {
        ArrayList<Livro> livros = new ArrayList<>();
        for(Produto produto : produtos){
            if (produto.getTipo().equalsIgnoreCase("livro")){
                livros.add((Livro) produto);
            }
        }
        return livros;
    }

    public ArrayList<CD> listarProdutosCd() {
        ArrayList<CD> cds = new ArrayList<>();
        for(Produto produtoCd : produtos){
            if (produtoCd.getTipo().equalsIgnoreCase("cd")){
                cds.add((CD) produtoCd);
            }
        }
        return cds;
    }

    public ArrayList<Livro> pesquisarLivroPorTitulo(String tituloInserido) {
        ArrayList<Livro> livrosTitulo = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto instanceof Livro livro && tituloInserido.equalsIgnoreCase(produto.getTitulo())) {
                livrosTitulo.add(livro);
            }
        }
        return livrosTitulo;
    }


    public ArrayList<Produto> pesquisarProdutoPorAutor(String autorInserido) {
        ArrayList<Produto> produtoDoAutor = new ArrayList<>();
        for (Produto autor : produtos) {
            if (autorInserido.equalsIgnoreCase(autor.getAutor().getNome())) {
                produtoDoAutor.add(autor);
            }
        }
        return produtoDoAutor;

    }

    public static Produto pesquisarProdutoPorId(int IdInserido) {
        for (Produto produto : produtos) {
            if (Objects.equals(produto.getTipo(), "livro")){
                // isto é um cast, diz ao sistema que o produto é do tipo livro, e passo para um variavel desse tipo
                // tem que ser utilizado quando queremos aceder a atributos não comuns (livro / cd)
                Livro aux = (Livro) produto;
                if (IdInserido == aux.getId()) {
                    return produto;
                }
            }
        }
        return null;
    }


    public ArrayList<Livro> pesquisarLivroCategoria(String categoriaInserida) {
        ArrayList<Livro> categoriaLivros = new ArrayList<>();
        for (Produto categoria : produtos) {
            if (categoriaInserida.equalsIgnoreCase(categoria.getCategoria().getNome())) {
                categoriaLivros.add((Livro) categoria);
            }
        }
        return categoriaLivros;

    }

    public Produto pesquisarLivroISBN(String ISBNinserido) {
        for (Produto produto : produtos) {
            if (Objects.equals(produto.getTipo(), "livro")) {
                // isto é um cast, diz ao sistema que o produto é do tipo livro, e passo para um variavel desse tipo
                // tem que ser utilizado quando queremos aceder a atributos não comuns (livro / cd)
                Livro aux = (Livro) produto;
                if (ISBNinserido.equalsIgnoreCase(aux.getISBN())) {
                    return produto;
                }
            }
        }
        return null;

    }

    public ArrayList<CD> pesquisarCDPorTitulo(String tituloDoCD) {
        ArrayList<CD> cdsTitulo = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto instanceof CD cd) {
                if (tituloDoCD.equalsIgnoreCase(cd.getTitulo())) {
                    cdsTitulo.add(cd);
                }
            }
        }
        return cdsTitulo;
    }
    public ArrayList<CD> pesquisarCDPorAutor(String AutorDoCD) {
        ArrayList<CD> cdsAutor = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto instanceof CD cd) {
                if (AutorDoCD.equalsIgnoreCase(cd.getAutor().getNome())) {
                    cdsAutor.add(cd);
                }
            }
        }
        return cdsAutor;
    }

    public ArrayList<Autor> pesquisarAutorPorNome(String nomeInserido) {
        ArrayList<Autor> nomeAutor = new ArrayList<>();
        for (Autor nome : autores) {
            if (nomeInserido.equalsIgnoreCase(nome.getNome())) {
                nomeAutor.add(nome);
            }
        }
        return nomeAutor;
    }
    public boolean adicionarLivros(String titulo, String subtitulo, int quantidade, int numDePaginas, Autor
            autorAdicionado, Categoria categorias, LocalDate dataDePublicacao, String faixaEtaria, String editora, String
                                                  ISBN) {
        Produto livro = new Livro(0, titulo, quantidade, autorAdicionado, categorias, dataDePublicacao, faixaEtaria, editora, ISBN, subtitulo, numDePaginas);
        produtos.add(livro);
        return true;
    }

    public boolean removerLivro(int idLivroRemover) {
        boolean encontrou = false;
        //percorrer as reservas para ver se encontra
        for (Reserva reserva : ControllerReservas.reservas) {
            for (Produto livrosEscolhido : reserva.getLivros()) {
                if (idLivroRemover == livrosEscolhido.getId()) {
                    encontrou = true;
                    break;
                }
            }
        }
        //se encontrar remove
        if (!encontrou) {
            //for(Livro livro: livros){
            //    if(idLivroRemover == livro.getId()){
            //        livros.remove(livro);
            //       }
            //     }
            //   }

            //função sugerida pelo intelij usando lambda para e o "removeIf" para remover, facilitando o uso dos loops
            produtos.removeIf(livro -> idLivroRemover == livro.getId());
        }

        return encontrou;
    }
    public boolean editarCDDoLivro(int idCDEditar, String tituloNovo) {
        for (Produto CD : produtos) {
            if (idCDEditar == CD.getId()) {
                CD.setTitulo(tituloNovo);
                return true;
            }
        }
        return false;
    }

    public boolean editarTituloDoLivro(int idLivroEditar, String tituloNovo) {
        for (Produto livro : produtos) {
            if (idLivroEditar == livro.getId()) {
                livro.setTitulo(tituloNovo);
                return true;
            }
        }
        return false;
    }

    public boolean editarQuantidade(int idEditarQuantidade, int novaQuantidade) {
        for (Produto livro : produtos) {
            if (idEditarQuantidade == livro.getId()) {
                livro.setQuantidade(novaQuantidade);
                return true;
            }
        }
        return false;
    }

    public boolean editarAutor(int idEditarLivro, String novoNomeAutor) {
        Autor autorEncontrado = null;
        for (Autor autor : autores) {
            if (autor.getNome().equals(novoNomeAutor)) {
                autorEncontrado = autor;
                break;
            }
        }
        if (autorEncontrado == null) {
            return false;
        }
        for (Produto livro : produtos) {
            if (idEditarLivro == livro.getId()) {
                livro.setAutor(autorEncontrado);
                return true;
            }
        }
        return false;
    }


    public boolean editarCategoria(int idEditarLivro, String novaCategoria) {
        Categoria categoriaEncontrada = null;
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equals(novaCategoria)) {
                categoriaEncontrada = categoria;
                break;
            }
        }
        if (categoriaEncontrada == null) {
            return false;
        }
        for (Produto livro : produtos) {
            if (idEditarLivro == livro.getId()) {
                livro.setCategoria(categoriaEncontrada);
                return true;
            }
        }
        return false;
    }

    public boolean editarDataDePubli(int idEditarTitulo, LocalDate novaData) {
        for (Produto livro : produtos) {
            if (idEditarTitulo == livro.getId()) {
                livro.setDataDePublicacao(novaData);
                return true;
            }
        }
        return false;
    }

    public boolean editarFaixaEtaria(int idEditarTitulo, String novaFaixaEtaria) {
        for (Produto livro : produtos) {
            if (idEditarTitulo == livro.getId()) {
                livro.setFaixaEtaria(novaFaixaEtaria);
                return true;
            }
        }
        return false;
    }

    public boolean editarEditora(int idEditarTitulo, String novaEditora) {
        for (Produto livro : produtos) {
            if (idEditarTitulo == livro.getId()) {
                livro.setEditora(novaEditora);
                return true;
            }
        }
        return false;
    }

    //não fazem parte do produto

    public boolean editarISBN(int idEditarTitulo, String novoISBN) {
        for (Produto produto : produtos) {
            if (produto instanceof Livro livro && idEditarTitulo == produto.getId()) {
                livro.setISBN(novoISBN);
                return true;
            }
        }
        return false;
    }



    public boolean editarNumPaginas(int idEditarTitulo, int numPaginas) {
        for (Produto produto : produtos) {
            if (produto instanceof Livro livro && idEditarTitulo == produto.getId()) {
                livro.setNumDePaginas(numPaginas);
                return true;
            }
        }
        return false;
    }


    public boolean editarSubTituloDoLivro(int idLivroEditar, String subTituloNovo) {
        for (Produto produto : produtos) {
            if (produto instanceof Livro livro && idLivroEditar == produto.getId()) {
                livro.setSubtitulo(subTituloNovo);
                return true;
            }
        }
        return false;
    }


    public boolean adicionarCDS(String titulo, int quantidade, int numCapitulos, Autor autorAdicionado, Categoria categoriaEncontrada, LocalDate dataDePublicacao, String faixaEtaria, String editora) {
        Produto CD = new CD(0,titulo, quantidade, autorAdicionado, categoriaEncontrada, dataDePublicacao,  faixaEtaria, editora,numCapitulos);
        produtos.add(CD);
        return true;
    }

    public boolean removerCD(int idCDRemover) {
        return true;
    }
}










