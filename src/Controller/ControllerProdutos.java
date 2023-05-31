package Controller;

import Model.*;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class ControllerProdutos {

    public ControllerAutores controllerAutores;
    public ControllerCategoria controllerCategorias;

    public ControllerProdutos(ControllerAutores controllerAutores, ControllerCategoria controllerCategorias) {
        this.controllerAutores = controllerAutores;
        this.controllerCategorias = controllerCategorias;
    }

    public static ArrayList<Produto> produtos = new ArrayList<>();
    public static ArrayList<Integer> eliminados = new ArrayList<Integer>();

    public void lerProdutosDeFicheiro() {
        ArrayList<String> linhasProduto = GestorFicheiros.LerFicheiro("produtos.txt");
        ArrayList<String> linhasLivro = GestorFicheiros.LerFicheiro("livros.txt");
        ArrayList<String> linhasCD = GestorFicheiros.LerFicheiro("cd.txt");

        for (String linha : linhasProduto) {
            if (!linha.isEmpty()) {
                String[] value_split_produto = linha.split("\\|");
                if (value_split_produto.length != 0) {
                    Produto aux = null;
                    if (Objects.equals(value_split_produto[1], "Livro")) {
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
                                new Categoria(0, value_split_produto[5]),
                                LocalDate.parse(value_split_produto[6]),
                                value_split_produto[7],
                                value_split_produto[8],
                                value_split_livro[1],
                                value_split_livro[2],
                                Integer.parseInt(value_split_livro[3])
                        );
                    } else if (Objects.equals(value_split_produto[1], "CD")) {
                        String[] value_split_cd = null;
                        Autor autor = null;
                        for (String linhaCD : linhasCD) {
                            if (linhaCD.startsWith(value_split_produto[0])) {
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
                                new Categoria(0, value_split_produto[5]),
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

            if (aux.getTipo() == TipoProduto.Livro) {
                Livro livro = (Livro) aux;
                conteudoLivro += aux.getId() + "|";
                conteudoLivro += livro.getSubtitulo() + "|";
                conteudoLivro += livro.getNumDePaginas() + "|";
                conteudoLivro += livro.getISBN() + "\n";
            } else if (aux.getTipo() == TipoProduto.CD) {
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

    /*


    Funções de listagem


     */

    public ArrayList<Livro> listarProdutosLivros() {
        ArrayList<Livro> livros = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Livro) {
                livros.add((Livro) produto);
            }
        }
        return livros;
    }

    public ArrayList<CD> listarProdutosCd() {
        ArrayList<CD> cds = new ArrayList<>();
        for (Produto produtoCd : produtos) {
            if (produtoCd.getTipo() == TipoProduto.CD) {
                cds.add((CD) produtoCd);
            }
        }
        return cds;
    }

    /*

    Funções de pesquisa

     */

    public ArrayList<Livro> pesquisarLivroPorTitulo(String tituloInserido) {
        ArrayList<Livro> livrosTitulo = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Livro && tituloInserido.equalsIgnoreCase(produto.getTitulo())) {
                livrosTitulo.add((Livro)produto);
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

    public Produto pesquisarProdutoPorId(int IdInserido) {
        for (Produto produto : produtos) {
            if (produto.getId() == IdInserido) {
                return produto;
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
            if (produto.getTipo() == TipoProduto.Livro) {
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
            if (produto.getTipo() == TipoProduto.CD) { //Cast instancia do ...
                if (tituloDoCD.equalsIgnoreCase(produto.getTitulo())) {
                    cdsTitulo.add((CD) produto);
                }
            }
        }
        return cdsTitulo;
    }

    public ArrayList<CD> pesquisarCDPorAutor(String AutorDoCD) {
        ArrayList<CD> cdsAutor = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.CD) {
                if (AutorDoCD.equalsIgnoreCase(produto.getAutor().getNome())) {
                    cdsAutor.add((CD) produto);
                }
            }
        }
        return cdsAutor;
    }

    /*

    Funções dos produtos

     */

    public boolean adicionarLivros(String titulo, String subtitulo, int quantidade, int numDePaginas, Autor
            autorAdicionado, Categoria categorias, LocalDate dataDePublicacao, String faixaEtaria, String editora, String ISBN) {
        Produto livro = new Livro(0, titulo, quantidade, autorAdicionado, categorias, dataDePublicacao, faixaEtaria, editora, subtitulo, ISBN, numDePaginas);
        livro.setPendenteGravacao(true);
        produtos.add(livro);
        return true;
    }

    public boolean adicionarCDS(String titulo, int quantidade, int numCapitulos, Autor autorAdicionado, Categoria categoriaEncontrada, LocalDate dataDePublicacao, String faixaEtaria, String editora) {
        Produto CD = new CD(0, titulo, quantidade, autorAdicionado, categoriaEncontrada, dataDePublicacao, faixaEtaria, editora, numCapitulos);
        CD.setPendenteGravacao(true);
        produtos.add(CD);
        return true;
    }

    public boolean removerProduto(int idProdutoRemover) {
        boolean encontrou = false;
        //percorrer as reservas para ver se encontra
        for (Reserva reserva : ControllerReservas.reservas) {
            for (Produto livrosEscolhido : reserva.getProdutos()) {
                if (idProdutoRemover == livrosEscolhido.getId()) {
                    encontrou = true;
                    break;
                }
            }
        }
        //se encontrar remove
        if (!encontrou) {
            //função sugerida pelo intelij usando lambda para e o "removeIf" para remover, facilitando o uso dos loops
            produtos.removeIf(livro -> idProdutoRemover == livro.getId());
            eliminados.add(idProdutoRemover);
        }

        return encontrou;
    }

    public boolean editarTituloDoProduto(int idProdutoEditar, String tituloNovo) {
        for (Produto produto : produtos) {
            if (idProdutoEditar == produto.getId()) {
                produto.setTitulo(tituloNovo);
                return true;
            }
        }
        return false;
    }

    public boolean editarQuantidadeProduto(int idEditarQuantidade, int novaQuantidade) {
        for (Produto produto : produtos) {
            if (idEditarQuantidade == produto.getId()) {
                produto.setQuantidade(novaQuantidade);
                return true;
            }
        }
        return false;
    }

    public boolean editarAutorProduto(int idEditarProduto, String novoNomeAutor) {
        Autor autorEncontrado = null;
        for (Autor autor : this.controllerAutores.listarAutores()) {
            if (autor.getNome().equals(novoNomeAutor)) {
                autorEncontrado = autor;
                break;
            }
        }
        if (autorEncontrado == null) {
            return false;
        }
        for (Produto produto : produtos) {
            if (idEditarProduto == produto.getId()) {
                produto.setAutor(autorEncontrado);
                return true;
            }
        }
        return false;
    }

    public boolean editarCategoriaProduto(int idEditarProduto, String novaCategoria) {
        Categoria categoriaEncontrada = this.controllerCategorias.pesquisarCategoriaPorNome(novaCategoria);
        if (categoriaEncontrada == null) {
            return false;
        }
        for (Produto produto : produtos) {
            if (idEditarProduto == produto.getId()) {
                produto.setCategoria(categoriaEncontrada);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean editarDataDePublicacaoProduto(int idEditarProduto, LocalDate novaData) {
        for (Produto produto : produtos) {
            if (idEditarProduto == produto.getId()) {
                produto.setDataDePublicacao(novaData);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean editarEditoraProduto(int idEditarProduto, String novaEditora) {
        for (Produto produto : produtos) {
            if (idEditarProduto == produto.getId()) {
                produto.setEditora(novaEditora);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean editarFaixaEtaria(int idEditarProduto, String novaFaixaEtaria) {
        for (Produto produto : produtos) {
            if (idEditarProduto == produto.getId()) {
                produto.setFaixaEtaria(novaFaixaEtaria);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    //não fazem parte do produto

    public boolean editarNumPaginas(int idEditarProduto, int numPaginas) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Livro && idEditarProduto == produto.getId()) {
                ((Livro) produto).setNumDePaginas(numPaginas);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean editarNumFaixas(int idEditarProduto, int numFaixas) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.CD && idEditarProduto == produto.getId()) {
                ((CD) produto).setNumCapitulos(numFaixas);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSubTituloDoLivro(int idEditarProduto, String subTituloNovo) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Livro && idEditarProduto == produto.getId()) {
                ((Livro) produto).setSubtitulo(subTituloNovo);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }


}














