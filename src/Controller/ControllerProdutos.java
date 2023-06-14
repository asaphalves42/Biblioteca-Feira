package Controller;

import Model.*;
import Utilidades.BaseDados;
import Utilidades.GestorFicheiros;

import java.sql.ResultSet;
import java.sql.SQLException;
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
                        Categoria categoria = null;
                        for (String linhaLivro : linhasLivro) {
                            if (linhaLivro.startsWith(value_split_produto[0])) {
                                value_split_livro = linha.split("\\|");
                                String autorLido = value_split_produto[4];
                                int idCategoria = Integer.parseInt(value_split_produto[5]);
                                autor = controllerAutores.pesquisarAutorPorNomeTESTE(autorLido);
                                categoria = controllerCategorias.pesquisarCategoriaPorId(idCategoria);
                            }
                        }

                        assert value_split_livro != null;
                        aux = new Livro(
                                Integer.parseInt(value_split_produto[0]),
                                value_split_produto[2],
                                Integer.parseInt(value_split_produto[3]),
                                autor,
                                categoria,
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
                        Categoria categoria = null;
                        for (String linhaCD : linhasCD) {
                            if (linhaCD.startsWith(value_split_produto[0])) {
                                value_split_cd = linhaCD.split("\\|");
                                String autorLido = value_split_produto[4];
                                int idCategoria = Integer.parseInt(value_split_produto[5]);
                                autor = controllerAutores.pesquisarAutorPorNomeTESTE(autorLido);
                                categoria = controllerCategorias.pesquisarCategoriaPorId(idCategoria);
                            }
                        }

                        assert value_split_cd != null;

                        aux = new CD(
                                Integer.parseInt(value_split_produto[0]),
                                value_split_produto[2],
                                Integer.parseInt(value_split_produto[3]),
                                autor,
                                categoria,
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
            conteudoProduto += aux.getCategoria().getId() + "|";// 5
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

    public void lerBaseDadosProdutos() {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            ResultSet resultado = basedados.Selecao("select * from produto");

            while (resultado.next()) {
                Produto aux;

                // enquanto existirem registos, vou ler 1 a 1
                if (resultado.getString("tipo").equalsIgnoreCase(TipoProduto.CD.toString())) {
                    aux = new CD(
                            resultado.getInt("id"),
                            resultado.getString("titulo"),
                            resultado.getInt("quantidade"),
                            this.controllerAutores.pesquisarAutorPorIdBD(resultado.getInt("id_autor")),
                            this.controllerCategorias.pesquisarCategoriaPorId(resultado.getInt("id_categoria")),
                            resultado.getDate("data_publicacao").toLocalDate(),
                            resultado.getString("faixa_etaria"),
                            resultado.getString("editora"),
                            resultado.getInt("capitulos")
                    );
                    produtos.add(aux);
                } else if (resultado.getString("tipo").equalsIgnoreCase(TipoProduto.Livro.toString())) {
                    aux = new Livro(
                            resultado.getInt("id"),
                            resultado.getString("titulo"),
                            resultado.getInt("quantidade"),
                            this.controllerAutores.pesquisarAutorPorIdBD(resultado.getInt("id_autor")),
                            this.controllerCategorias.pesquisarCategoriaPorId(resultado.getInt("id_categoria")),
                            resultado.getDate("data_publicacao").toLocalDate(),
                            resultado.getString("faixa_etaria"),
                            resultado.getString("editora"),
                            resultado.getString("subtitulo"),
                            resultado.getString("isbn"),
                            resultado.getInt("paginas")
                    );
                    produtos.add(aux);
                }

            }
            basedados.Desligar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarBaseDadosProdutos() {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            //insere ou atualizar os registos
            for (Produto aux : produtos) {
                if (aux.getPendenteGravacao()) {
                    basedados.Executar("DELETE FROM produto where id = " + aux.getId());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    ;
                    //campos comuns
                    String campos = "id, tipo, titulo, quantidade, id_autor, id_categoria, data_publicacao, faixa_etaria, editora,";
                    String valores = aux.getId() + ",  '" + aux.getTipo().toString() + "', '" + aux.getTitulo() + "', " + aux.getQuantidade() + ", " + aux.getAutor().getId() + "," + aux.getCategoria().getId() + ", " +
                            "'" + aux.getDataDePublicacao().format(formatter) + "', '" + aux.getFaixaEtaria() + "', '" + aux.getEditora() + "',";

                    // campos especificos
                    if (aux.getTipo() == TipoProduto.CD) {
                        CD aux1 = (CD) aux;
                        campos += "capitulos";
                        valores += aux1.getNumCapitulos();
                    } else if (aux.getTipo() == TipoProduto.Livro) {
                        Livro aux1 = (Livro) aux;
                        campos += "subtitulo, isbn, paginas";
                        valores += "'" + aux1.getSubtitulo() + "', '" + aux1.getISBN() + "', " + aux1.getNumDePaginas();
                    }

                    // executar o SCRIPT na base de dados
                    basedados.Executar("INSERT INTO produto " +
                            "(" + campos + ")" +
                            " values " +
                            "(" + valores + ")");
                }
            }

            //eliminar registos que foram apagados
            if (eliminados.size() > 0) {
                for (Integer aux : eliminados) {
                    basedados.Executar("DELETE FROM produto where id = '" + aux + "'");
                }
                eliminados.clear(); //apago o array porque já foi processado
            }

            basedados.Desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public ArrayList<Jornal> listarProdutosJornal() {
        ArrayList<Jornal> jornais = new ArrayList<>();
        for (Produto produtoJornal : produtos) {
            if (produtoJornal.getTipo() == TipoProduto.Jornal) {
                jornais.add((Jornal) produtoJornal);
            }
        }
        return jornais;
    }

    public ArrayList<Revista> listarProdutosRevistas() {
        ArrayList<Revista> revistas = new ArrayList<>();
        for (Produto produtoRevistas : produtos) {
            if (produtoRevistas.getTipo() == TipoProduto.Revista) {
                revistas.add((Revista) produtoRevistas);
            }

        }
        return revistas;
    }
    /*

    Funções de pesquisa

     */

    public ArrayList<Livro> pesquisarLivroPorTitulo(String tituloInserido) {
        ArrayList<Livro> livrosTitulo = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Livro && tituloInserido.equalsIgnoreCase(produto.getTitulo())) {
                livrosTitulo.add((Livro) produto);
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

    public boolean adicionarJornais(String titulo, String subtitulo, int quantidade, int numeroPaginas, LocalDate dataPublicacao, String editora) {
        Produto jornal = new Jornal(0, titulo, subtitulo, quantidade, numeroPaginas, dataPublicacao, editora);
        //jornal.setPedenteGravacao(true);
        produtos.add(jornal);
        return true;
    }

    public boolean adicionarRevistas(String titulo, String subtitulo, int quantidade, int numeroPaginas, LocalDate dataPublicacao, String editora) {
        Produto revista = new Revista(0, titulo, subtitulo, quantidade, numeroPaginas, dataPublicacao, editora);
        //revista.setPedenteGravacao(true);
        produtos.add(revista);
        return true;
    }

    public boolean removerProduto(int idProdutoRemover) {

        boolean encontrou = false;
        // Percorrer as reservas para ver se encontra o produto
        for (Reserva reserva : ControllerReservas.reservas) {
            for (Produto produtoEscolhido : reserva.getProdutos()) {
                if (idProdutoRemover == produtoEscolhido.getId()) {
                    encontrou = true;
                    break;
                }
            }
        }

        // Remover o produto se não estiver em nenhuma reserva
        if (!encontrou) {
            // Remover o produto da lista de produtos

            produtos.removeIf(produto -> idProdutoRemover == produto.getId());
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

    public boolean editarCategoriaProdutoID(int idEditarProduto, int idNovaCategoria) {
        Categoria categoriaEncontrada = this.controllerCategorias.pesquisarCategoriaPorId(idNovaCategoria);
        if (categoriaEncontrada == null) {
            return false;
        }
        for (Produto produto : produtos) {
            if (idEditarProduto == produto.getId()) {
                produto.setCategoria(this.controllerCategorias.pesquisarCategoriaPorId(idNovaCategoria));
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

    public ArrayList<Jornal> pesquisarJornalPorTitulo(String tituloDoJornal) {
        ArrayList<Jornal> JornaisTitulos = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Jornal) { //Cast instancia do ...
                if (tituloDoJornal.equalsIgnoreCase(produto.getTitulo())) {
                    JornaisTitulos.add((Jornal) produto);
                }
            }
        }
        return JornaisTitulos;
    }

    public ArrayList<Jornal> pesquisarJornalPorEditora(String EditoraDoJornal) {
        ArrayList<Jornal> jornaisEditora = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Jornal) {
                if (EditoraDoJornal.equalsIgnoreCase(produto.getEditora())) {
                    jornaisEditora.add((Jornal) produto);
                }
            }
        }
        return jornaisEditora;
    }

    public boolean editarNumPaginasJornal(int idEditarProduto, int numPaginas) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Jornal && idEditarProduto == produto.getId()) {
                ((Jornal) produto).setNumeroPaginas(numPaginas);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }
    public boolean editarSubTituloDoJornal(int idEditarProduto, String subTituloNovo) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Jornal && idEditarProduto == produto.getId()) {
                ((Jornal) produto).setSubtitulo(subTituloNovo);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean editarNumPaginasRevista(int idEditarProduto, int numPaginas) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Revista && idEditarProduto == produto.getId()) {
                ((Revista) produto).setNumeroPaginas(numPaginas);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Revista> pesquisarRevistaPorTitulo(String tituloDaRevista) {
        ArrayList<Revista> RevistasTitulos = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Revista) { //Cast instancia do ...
                if (tituloDaRevista.equalsIgnoreCase(produto.getTitulo())) {
                    RevistasTitulos.add((Revista) produto);
                }
            }
        }
        return RevistasTitulos;
    }
    public boolean editarSubTituloRevista(int idEditarProduto, String subTituloNovo) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Revista && idEditarProduto == produto.getId()) {
                ((Revista) produto).setSubtitulo(subTituloNovo);
                produto.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Revista> pesquisarRevistaPorEditora(String EditoraDaRevista) {
        ArrayList<Revista> RevistasEditora = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Revista) {
                if (EditoraDaRevista.equalsIgnoreCase(produto.getEditora())) {
                    RevistasEditora.add((Revista) produto);
                }
            }
        }
        return RevistasEditora;
    }


}














