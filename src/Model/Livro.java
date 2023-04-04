package Model;

import java.time.LocalDate;
import java.util.Date;

public class Livro {
    private static int proximoId = 1;
    private int id;
    private String titulo;
    private String subtitulo;
    private int quantidade;
    private int numDePaginas;
    private String categoria;
    private Date dataDePublicacao;
    private String faixaEtaria;
    private String editora;
    private String ISBN;
    private String autor;

    public Livro() {

    }

    public Livro(String titulo, String subtitulo, int quantidade, String autor, int numDePaginas, String categoria, Date dataDePublicacao, String faixaEtaria, String editora, String ISBN) {
        this.id = proximoId++;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.quantidade = quantidade;
        this.numDePaginas = numDePaginas;
        this.categoria = categoria;
        this.dataDePublicacao = dataDePublicacao;
        this.faixaEtaria = faixaEtaria;
        this.editora = editora;
        this.ISBN = ISBN;
        this.autor = autor;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Livros [ " + "\n" +
                "ID: " + this.id + "\n" +
                "Quantidade: " + this.quantidade + "\n" +
                "Título: " + this.titulo + "\n" +
                "Subtitulo: " + this.subtitulo + "\n" +
                "Autor: " + this.autor + "\n" +
                "Número de páginas: " + this.numDePaginas + "\n" +
                "Categoria: " + this.categoria + "\n" +
                "Data de publicacao: " + this.dataDePublicacao + "\n" +
                "Faixa etaria: " + this.faixaEtaria + "\n" +
                "Editora: " + this.editora + "\n" +
                "ISBN: " + this.ISBN + "]"+ "\n" +
                " " + "----------------------------------------------------";

    }
}

