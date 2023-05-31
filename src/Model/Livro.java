package Model;

import java.time.LocalDate;

public class Livro extends Produto {
    public Livro(int id, String titulo, int quantidade, Autor autor, Categoria categoria,
                 LocalDate dataDePublicacao, String faixaEtaria, String editora,  String subtitulo, String ISBN, int numDePaginas ) {
        super(id, titulo, quantidade, autor, categoria,dataDePublicacao, faixaEtaria, editora);
        this.subtitulo = subtitulo;
        this.ISBN = ISBN;
        this.numDePaginas = numDePaginas;
    }

    private String subtitulo;
    private int numDePaginas;
    private String ISBN;

    public String getSubtitulo() {
        return subtitulo;
    }

    public int getNumDePaginas() {
        return numDePaginas;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public void setNumDePaginas(int numDePaginas) {
        this.numDePaginas = numDePaginas;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public TipoProduto getTipo() {
        return TipoProduto.Livro;
    }

    @Override
    public String toString() {
        return getTipo()+" [ " + "\n" +
                "ID: " + this.getId() + "\n" +
                "Quantidade: " + this.getQuantidade() + "\n" +
                "Título: " + this.getTitulo() + "\n" +
                "Subtitulo: " + this.getSubtitulo() + "\n" +
                "Autor: " + this.getAutor().getNome() + "\n" +
                "Número de páginas: " + this.getNumDePaginas() + "\n" +
                "Categoria: " + this.getCategoria().getNome() + "\n" +
                "Data de publicacao: " + this.getDataDePublicacao() + "\n" +
                "Faixa etaria: " + this.getFaixaEtaria() + "\n" +
                "Editora: " + this.getEditora() + "\n" +
                "ISBN: " + this.getISBN() + "]"+ "\n" + "----------------------------------------------------";

    }
}

