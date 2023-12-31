package Model;

import java.time.LocalDate;

public class Revista extends Produto {
    public Revista(int id, String titulo, String subtitulo, int quantidade, int numeroPaginas, LocalDate dataPublicacao, String editora, Autor autor, Categoria categoria, String faixaEtaria) {
        super(id, titulo, quantidade, dataPublicacao, editora, autor, categoria,faixaEtaria);
        this.numeroPaginas = numeroPaginas;
        this.subtitulo = subtitulo;
        this.editora = editora;

    }

    private String subtitulo;
    private int numeroPaginas;
    private String editora;

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String getEditora() {
        return editora;
    }

    @Override
    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public TipoProduto getTipo() {
        return TipoProduto.Revista;
    }

    @Override
    public String toString() {
        return getTipo() + " [ " + "\n" +
                "ID: " + this.getId() + "\n" +
                "Titulo: " + this.getTitulo() +  "\n" +
                "Subtítulo: " + this.getSubtitulo() + "\n" +
                "Número de páginas: " + this.getNumeroPaginas() + "\n" +
                "Data de publicação: " + this.getDataDePublicacao() + "\n" +
                "Editora: " + getEditora() + "\n" +
                "Quantidade: " + this.getQuantidade() + " ] " + "\n" +
                "----------------------------------------------------";
    }



}

