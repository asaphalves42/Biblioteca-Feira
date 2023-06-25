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

    /*
    Funções de leitura da base de dados
     */

    public void lerBaseDadosProdutos() {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            ResultSet resultado = basedados.Selecao("select * from produto");

            while (resultado.next()) {
                Produto aux=null;

                // enquanto existirem registos, vou ler 1 a 1
                if (resultado.getString("id_tipo").equalsIgnoreCase("1")) {
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
                } else if (resultado.getString("id_tipo").equalsIgnoreCase("2")) {
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
                } else if (resultado.getString("id_tipo").equalsIgnoreCase("3")) {
                    aux = new Jornal(
                            resultado.getInt("id"),
                            resultado.getString("titulo"),
                            resultado.getString("subtitulo"),
                            resultado.getInt("quantidade"),
                            resultado.getInt("paginas"),
                            resultado.getDate("data_publicacao").toLocalDate(),
                            resultado.getString("editora"),
                            this.controllerAutores.pesquisarAutorPorIdBD(resultado.getInt("id_autor")),
                            this.controllerCategorias.pesquisarCategoriaPorId(resultado.getInt("id_categoria")),
                            resultado.getString("faixa_etaria")
                    );
                } else if (resultado.getString("id_tipo").equalsIgnoreCase("4")) {
                    aux = new Revista(
                            resultado.getInt("id"),
                            resultado.getString("titulo"),
                            resultado.getString("subtitulo"),
                            resultado.getInt("quantidade"),
                            resultado.getInt("paginas"),
                            resultado.getDate("data_publicacao").toLocalDate(),
                            resultado.getString("editora"),
                            this.controllerAutores.pesquisarAutorPorIdBD(resultado.getInt("id_autor")),
                            this.controllerCategorias.pesquisarCategoriaPorId(resultado.getInt("id_categoria")),
                            resultado.getString("faixa_etaria")
                    );
                } else {
                    resultado.getString("id_tipo");/*aux = new Revista(
                            resultado.getInt("id"),
                            resultado.getString("titulo"),
                            resultado.getString("subtitulo"),
                            resultado.getInt("quantidade"),
                            resultado.getInt("paginas"),
                            resultado.getDate("data_publicacao").toLocalDate(),
                            resultado.getString("editora")
                    );*/
                }
                produtos.add(aux);
            }
            basedados.Desligar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarBaseDadosProduto(Produto produto, boolean atualizacao){
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();

            String script = "";
            if (atualizacao) {
                script = "UPDATE produto set titulo = '@02', quantidade = @03, id_autor = @04, id_categoria = @05, data_publicacao = '@06', faixa_etaria = '@07', editora = '@08', " +
                        " subtitulo = '@09', isbn = '@10', paginas = '@11' , capitulos = @12, id_tipo = @13 where id = @01";
            }
            else
            {
                script = "INSERT INTO produto (id, titulo, quantidade, id_autor, id_categoria, data_publicacao, faixa_etaria, editora, subtitulo, isbn, paginas, capitulos, id_tipo)" +
                        " VALUES (@01, '@02', @03, @04, @05, '@06', '@07', '@08', '@09', '@10', '@11', @12, @13)";
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");;


            script = script.replace("@01", String.valueOf(produto.getId()));
            script = script.replace("@02", produto.getTitulo());
            script = script.replace("@03", String.valueOf(produto.getQuantidade()));
            script = script.replace("@04", String.valueOf(produto.getAutor().getId()));
            script = script.replace("@05", String.valueOf(produto.getCategoria().getId()));
            script = script.replace("@06", produto.getDataDePublicacao().format(formatter));
            script = script.replace("@07", produto.getFaixaEtaria());
            script = script.replace("@08", produto.getEditora());
            script = script.replace("@13", String.valueOf(produto.getTipo().getValue()));

            // campos especificos
            if (produto.getTipo() == TipoProduto.CD){
                CD aux1 = (CD)produto;
                script = script.replace("@12",  String.valueOf(aux1.getNumCapitulos()));
            } else if (produto.getTipo() == TipoProduto.Livro) {
                Livro aux1 = (Livro)produto;
                script = script.replace("@09",  aux1.getSubtitulo());
                script = script.replace("@10",  aux1.getISBN());
                script = script.replace("@11",  String.valueOf(aux1.getNumDePaginas()));
            } else if (produto.getTipo() == TipoProduto.Jornal) {
                Jornal aux1 = (Jornal)produto;
                script = script.replace("@09",  aux1.getSubtitulo());
                script = script.replace("@11",  String.valueOf(aux1.getNumeroPaginas()));
            } else if (produto.getTipo() == TipoProduto.Revista) {
                Revista aux1 = (Revista) produto;
                script = script.replace("@09",  aux1.getSubtitulo());
                script = script.replace("@11",  String.valueOf(aux1.getNumeroPaginas()));
            }
            for (int i = 30; i > 0; i--) {
                script = script.replace("'@"+String.format("%02d", i)+"'", "NULL");
                script = script.replace("@"+String.format("%02d", i), "NULL");
            }

            // executar o SCRIPT na base de dados
            basedados.Executar(script);
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
                gravarBaseDadosProduto(produto, true);
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

    Funções de adição

     */

    public boolean adicionarLivros(String titulo, String subtitulo, int quantidade, int numDePaginas, Autor
            autorAdicionado, Categoria categorias, LocalDate dataDePublicacao, String faixaEtaria, String editora, String ISBN) {
        Produto livro = new Livro(0, titulo, quantidade, autorAdicionado, categorias, dataDePublicacao, faixaEtaria, editora, subtitulo, ISBN, numDePaginas);
        produtos.add(livro);
        gravarBaseDadosProduto(livro, false);
        return true;
    }

    public boolean adicionarCDS(String titulo, int quantidade, int numCapitulos, Autor autorAdicionado, Categoria categoriaEncontrada, LocalDate dataDePublicacao, String faixaEtaria, String editora) {
        Produto CD = new CD(0, titulo, quantidade, autorAdicionado, categoriaEncontrada, dataDePublicacao, faixaEtaria, editora, numCapitulos);
        produtos.add(CD);
        gravarBaseDadosProduto(CD, false);
        return true;
    }

    public boolean adicionarJornais(String titulo, String subtitulo, int quantidade, int numeroPaginas, LocalDate dataPublicacao, String editora, Autor autor, Categoria categoria, String faixaEtaria) {
        Produto jornal = new Jornal(0, titulo, subtitulo, quantidade, numeroPaginas, dataPublicacao, editora, autor, categoria,faixaEtaria);
        produtos.add(jornal);
        gravarBaseDadosProduto(jornal, false);
        return true;
    }

    public boolean adicionarRevistas(String titulo, String subtitulo, int quantidade, int numeroPaginas, LocalDate dataPublicacao, String editora, Autor autor, Categoria categoria,String faixaEtaria) {
        Produto revista = new Revista(0, titulo, subtitulo, quantidade, numeroPaginas, dataPublicacao, editora, autor, categoria, faixaEtaria);
        produtos.add(revista);
        gravarBaseDadosProduto(revista,false);
        return true;
    }

    /*
    Funções de remoção
     */

    public void removerBaseDadosProduto(int idProduto){
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();

            basedados.Executar("DELETE FROM produto where id = '" +idProduto + "'");

            basedados.Desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
            removerBaseDadosProduto(idProdutoRemover);
        }

        return encontrou;
    }

    /*
    Funções de edição
     */

    //OBS: Algumas funções de edição podiam ser melhoradas ao associar somente ao produto

    public boolean editarTituloDoProduto(int idProdutoEditar, String tituloNovo) {
        for (Produto produto : produtos) {
            if (idProdutoEditar == produto.getId()) {
                produto.setTitulo(tituloNovo);
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarQuantidadeProduto(int idEditarQuantidade, int novaQuantidade) {
        for (Produto produto : produtos) {
            if (idEditarQuantidade == produto.getId()) {
                produto.setQuantidade(novaQuantidade);
                gravarBaseDadosProduto(produto, true);
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
                gravarBaseDadosProduto(produto, true);
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
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }


    public boolean editarDataDePublicacaoProduto(int idEditarProduto, LocalDate novaData) {
        for (Produto produto : produtos) {
            if (idEditarProduto == produto.getId()) {
                produto.setDataDePublicacao(novaData);
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }


    public boolean editarEditoraProduto(int idEditarProduto, String novaEditora) {
        for (Produto produto : produtos) {
            if (idEditarProduto == produto.getId()) {
                produto.setEditora(novaEditora);
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarFaixaEtaria(int idEditarProduto, String novaFaixaEtaria) {
        for (Produto produto : produtos) {
            if (idEditarProduto == produto.getId()) {
                produto.setFaixaEtaria(novaFaixaEtaria);
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }


    public boolean editarNumPaginas(int idEditarProduto, int numPaginas) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Livro && idEditarProduto == produto.getId()) {
                ((Livro) produto).setNumDePaginas(numPaginas);
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarNumFaixas(int idEditarProduto, int numFaixas) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.CD && idEditarProduto == produto.getId()) {
                ((CD) produto).setNumCapitulos(numFaixas);
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSubTituloDoLivro(int idEditarProduto, String subTituloNovo) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Livro && idEditarProduto == produto.getId()) {
                ((Livro) produto).setSubtitulo(subTituloNovo);
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarNumPaginasJornal(int idEditarProduto, int numPaginas) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Jornal && idEditarProduto == produto.getId()) {
                ((Jornal) produto).setNumeroPaginas(numPaginas);
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSubTituloDoJornal(int idEditarProduto, String subTituloNovo) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Jornal && idEditarProduto == produto.getId()) {
                ((Jornal) produto).setSubtitulo(subTituloNovo);
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarNumPaginasRevista(int idEditarProduto, int numPaginas) {
        for (Produto produto : produtos) {
            if (produto.getTipo() == TipoProduto.Revista && idEditarProduto == produto.getId()) {
                ((Revista) produto).setNumeroPaginas(numPaginas);
                gravarBaseDadosProduto(produto, true);
                return true;
            }
        }
        return false;
    }

    /*
    Funções de pesquisa
     */




}














