package Model;

import java.util.Date;

public class Livro {
    private String titulo;
    private String subtitulo;
    private int numDePaginas;
    private String categoria;
    private Date dataDePublicacao;
    private String faixaEtaria;
    private String editora;
    private String ISBN;
    private String autor;

    public Livro(){

    }

    public Livro(String titulo, String subtitulo, int numDePaginas, String categoria, Date dataDePublicacao, String faixaEtaria, String editora, String ISBN, String autor) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.numDePaginas = numDePaginas;
        this.categoria = categoria;
        this.dataDePublicacao = dataDePublicacao;
        this.faixaEtaria = faixaEtaria;
        this.editora = editora;
        this.ISBN = ISBN;
        this.autor=autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public int getNumDePaginas() {
        return numDePaginas;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getDataDePublicacao() {
        return dataDePublicacao;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public String getEditora() {
        return editora;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public void setNumDePaginas(int numDePaginas) {
        this.numDePaginas = numDePaginas;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDataDePublicacao(Date dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
}
