package Model;

import java.time.LocalDate;


public class Jornal extends Produto {
    public Jornal(int id, String titulo, String subtitulo, int quantidade, Autor nomeAutor, Categoria categoria, int numeroPaginas, LocalDate dataPublicacao, String editora) {
        super(id, titulo, quantidade, nomeAutor, categoria, dataPublicacao, subtitulo, editora);
        this.numeroPaginas = numeroPaginas;
        quantidade = 1;

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
        return TipoProduto.Jornal;
    }

    @Override
    public String toString() {
        return "Jornal[" +
                "titulo='" + this.getTitulo() + '\'' +
                ", subtitulo='" + this.getSubtitulo() + '\'' +
                ", numeroPaginas='" + this.getNumeroPaginas() + '\'' +
                ", dataPublicacao='" + this.getDataDePublicacao() + '\'' +
                ", editora='" + getEditora() + '\'' +
                ", quantidade='" + this.getQuantidade() + '\'' +
                ']';
    }


}