package Controller;

import Model.Autor;
import Model.Categoria;
import Model.Livro;
import Model.Reserva;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static Controller.ControllerAutores.autores;
import static Controller.ControllerCategoria.categorias;


public class ControllerLivros {
    public static ArrayList<Livro> livros = new ArrayList<>();
    public ControllerAutores controllerAutores;

    public ControllerLivros(ControllerAutores controllerAutores) {
        this.controllerAutores = controllerAutores;
    }

    public void lerLivrosDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("livros.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");
                String autorLido = value_split[4];
                Autor autor = controllerAutores.pesquisarAutorPorNomeTESTE(autorLido);
                Livro aux = new Livro(Integer.parseInt(value_split[0]),
                        value_split[1],
                        value_split[2],
                        Integer.parseInt(value_split[3]),
                        // mudar para Autor
                        autor,
                        Integer.parseInt(value_split[5]),

                        //mudar para categorias
                        new Categoria(value_split[6]),
                        LocalDate.parse(value_split[7]),
                        value_split[8],
                        value_split[9],
                        value_split[10]);
                livros.add(aux);
            }

        }
    }


    public void gravarLivrosParaFicheiro(){
        String conteudo = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Livro aux : livros){
            String formated_date = aux.getDataDePublicacao().format(formatter);

            conteudo += aux.getId() + "|";
            conteudo += aux.getTitulo() + "|" ;
            conteudo += aux.getSubtitulo() + "|" ;
            conteudo += aux.getQuantidade() + "|" ;
            conteudo += aux.getAutor().getNome() + "|" ;
            conteudo += aux.getNumDePaginas() + "|" ;
            conteudo += aux.getCategoria().getNome() + "|" ;
            conteudo += formated_date + "|" ;
            conteudo += aux.getFaixaEtaria() + "|" ;
            conteudo += aux.getEditora() + "|" ;
            conteudo += aux.getISBN() +  "\n";
        }
        GestorFicheiros.gravarFicheiro("livros.txt", conteudo);
    }

    public ArrayList<Livro> listarLivros() {
        return livros;
    }

    public ArrayList<Livro> pesquisarLivroPorTitulo(String tituloInserido) {
        ArrayList<Livro> livrosTitulo = new ArrayList<>();
        for (Livro livro : livros) {
            if (tituloInserido.equalsIgnoreCase(livro.getTitulo())) {
               livrosTitulo.add(livro);
            }
        }
        return livrosTitulo;
    }
    public void verificarId(){
        int max = 0;
        for(Livro id : livros){
            if(id.getId() > max){
                max = id.getId();
            }
        }

    }
    public void adicionarLivrosComAutores(String titulo, String subtitulo, int quantidade, int numDePaginas, Autor autorAdicionado, Categoria categoria, LocalDate dataDePublicacao, String faixaEtaria, String editora, String ISBN) {
        this.verificarId();
        Livro livro = new Livro(titulo, subtitulo, quantidade, numDePaginas, autorAdicionado, categoria, dataDePublicacao,faixaEtaria, editora, ISBN);

        livros.add(livro);


    }

    public ArrayList<Livro> pesquisarLivroPorAutor(String autorInserido){
        ArrayList<Livro> livrosDoAutor = new ArrayList<>();
        for (Livro autor : livros) {
            if (autorInserido.equalsIgnoreCase(autor.getAutor().getNome())) {
                livrosDoAutor.add(autor);
            }
        }
        return livrosDoAutor;

    }
    public ArrayList<Autor> pesquisarAutorPorNome(String nomeInserido) {
        ArrayList<Autor> nomeAutor = new ArrayList<>();
        for (Autor nome : autores) {
            if (nomeInserido.equalsIgnoreCase(nome.getNome())){
                nomeAutor.add(nome);
            }
        }
        return nomeAutor;
    }


    public ArrayList<Livro> pesquisarLivroCategoria(String categoriaInserida){
        ArrayList<Livro> categoriaLivros = new ArrayList<>();
        for (Livro livro : livros) {
            if (categoriaInserida.equalsIgnoreCase(livro.getCategoria().getNome())) {
                categoriaLivros.add(livro);
            }
        }
        return categoriaLivros;

    }

    public Livro pesquisarLivroISBN(String ISBNinserido){
        for (Livro livro : livros) {
            if (ISBNinserido.equalsIgnoreCase(livro.getISBN())) {
                return livro;
            }
        }
        return null;
    }

    public boolean removerLivro(int idLivroRemover) {
        boolean encontrou = false;
                //percorrer as reservas para ver se encontra
                for (Reserva reserva : ControllerReservas.reservas) {
                    for (Livro livrosEscolhido : reserva.getLivros()) {
                        if (idLivroRemover == livrosEscolhido.getId()) {
                            encontrou = true;
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
                livros.removeIf(livro -> idLivroRemover == livro.getId());
            }

        return encontrou;
    }


    public boolean editarTituloDoLivro(int idLivroEditar, String tituloNovo) {
        for (Livro livro : livros) {
            if (idLivroEditar == livro.getId()) {
                livro.setTitulo(tituloNovo);
                return true;
            }
        }
        return false;
    }

    public boolean editarSubTituloDoLivro(int idLivroEditar, String subTituloNovo) {
        for (Livro livro : livros) {
            if (idLivroEditar == livro.getId()) {
                livro.setSubtitulo(subTituloNovo);
                return true;
            }
        }
        return false;
    }

    public boolean editarQuantidade(int idEditarQuantidade, int novaQuantidade) {
        for (Livro livro : livros) {
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
        for (Livro livro : livros) {
            if (idEditarLivro == livro.getId()) {
                livro.setAutor(autorEncontrado);
                return true;
            }
        }
        return false;
    }

    public boolean editarNumPaginas(int idEditarTitulo, int numPaginas) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setNumDePaginas(numPaginas);
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
        for (Livro livro : livros) {
            if (idEditarLivro == livro.getId()) {
                livro.setCategoria(categoriaEncontrada);
                return true;
            }
        }
        return false;
    }

    public boolean editarDataDePubli(int idEditarTitulo, LocalDate novaData) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setDataDePublicacao(novaData);
                return true;
            }
        }
        return false;
    }
    public boolean editarFaixaEtaria(int idEditarTitulo, String novaFaixaEtaria) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setFaixaEtaria(novaFaixaEtaria);
                return true;
            }
        }
        return false;
    }
    public boolean editarEditora(int idEditarTitulo, String novaEditora) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setEditora(novaEditora);
                return true;
            }
        }
        return false;
    }

    public boolean editarISBN(int idEditarTitulo, String novoISBN) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setISBN(novoISBN);
                return true;
            }
        }
        return false;
    }

    public Livro pesquisarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

}










