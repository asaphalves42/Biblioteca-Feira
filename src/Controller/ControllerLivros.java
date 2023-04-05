package Controller;

import Model.Livro;

import java.util.ArrayList;
import java.util.Date;

public class ControllerLivros {
    public ArrayList<Livro> livros = new ArrayList<>();

    public void adicionarLivros(String titulo, String subTitulo, int quantidade, String autor, int numPaginas, String categoria, Date dataDePublicacao, String faixaEtaria, String editora, String ISBN) {

        Livro livro = new Livro(titulo, subTitulo, quantidade, autor, numPaginas, categoria, dataDePublicacao, faixaEtaria, editora, ISBN);

        livro.setTitulo(titulo);
        livro.setSubtitulo(subTitulo);
        livro.setQuantidade(quantidade);
        livro.setAutor(autor);
        livro.setNumDePaginas(numPaginas);
        livro.setCategoria(categoria);
        livro.setDataDePublicacao(dataDePublicacao);
        livro.setFaixaEtaria(faixaEtaria);
        livro.setEditora(editora);
        livro.setISBN(ISBN);

        this.livros.add(livro);

    }

    public ArrayList<Livro> listarLivros() {
        return this.livros;

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

    public ArrayList<Livro> pesquisarLivroPorAutor(String autorInserido){
        ArrayList<Livro> livrosDoAutor = new ArrayList<>();
        for (Livro autor : livros) {
            if (autorInserido.equalsIgnoreCase(autor.getAutor())) {
                livrosDoAutor.add(autor);
            }
        }
        return livrosDoAutor;

    }

    public ArrayList<Livro> pesquisarLivroCategoria(String categoriaInserida){
        ArrayList<Livro> categoriaLivros = new ArrayList<>();
        for (Livro categoria : livros) {
            if (categoriaInserida.equalsIgnoreCase(categoria.getCategoria())) {
                categoriaLivros.add(categoria);
            }
        }
        return categoriaLivros;

    }

    public ArrayList<Livro> pesquisarLivroISBN(String ISBNinserido){
        ArrayList<Livro> ISBNLivros = new ArrayList<>();
        for (Livro ISBN : livros) {
            if (ISBNinserido.equalsIgnoreCase(ISBN.getISBN())) {
                ISBNLivros.add(ISBN);
            }
        }
        return ISBNLivros;

    }

    public boolean removerLivros(int idLivroRemover) {

        for (Livro livro : livros) {
            if (idLivroRemover == livro.getId()) {
                if (livro.getQuantidade() - 1 > 0) {
                    livro.setQuantidade(livro.getQuantidade() - 1);
                } else {
                    livros.remove(livro);
                }
                return true;
            }
        }
        return false;

    }

    public boolean editarLivros(int idLivroEditar, String novoTitulo, String subTitulo, int quantidade, String autor, int numPaginas, String categoria, Date dataDePublicacao, String faixaEtaria, String editora, String ISBN) {
        for (Livro livro : livros) {
            if (idLivroEditar == livro.getId()) {
                livro.setTitulo(novoTitulo);
                livro.setSubtitulo(subTitulo);
                livro.setQuantidade(quantidade);
                livro.setAutor(autor);
                livro.setNumDePaginas(numPaginas);
                livro.setCategoria(categoria);
                livro.setDataDePublicacao(dataDePublicacao);
                livro.setFaixaEtaria(faixaEtaria);
                livro.setEditora(editora);
                livro.setISBN(ISBN);

                return true;
            }
        }
        return false;
    }

    public boolean editarTituloDoLivro(int idEditarTitulo, String tituloNovo) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setTitulo(tituloNovo);
                return true;
            }
        }
        return false;
    }

    public boolean editarSubTituloDoLivro(int idEditarTitulo, String subTituloNovo) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setSubtitulo(subTituloNovo);
                return true;
            }
        }
        return false;
    }

    public boolean editarQuantidade(int idEditarTitulo, int novaQuantidade) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setQuantidade(novaQuantidade);
                return true;
            }
        }
        return false;
    }
    public boolean editarAutor(int idEditarTitulo, String novoAutor) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setAutor(novoAutor);
                return true;
            }
        }
        return false;
    }

}










