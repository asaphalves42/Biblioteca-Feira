package Model;

import java.time.LocalDate;

public class Revista extends Produto {
    public Revista(int id, String titulo, String subtitulo,int numeroPaginas, int quantidade, LocalDate dataPublicacao, String editora) {
        super(id, titulo, subtitulo ,quantidade,dataPublicacao, editora);
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
        return getTipo() + " [ " +
                "Titulo: " + this.getTitulo() + '\n' +
                "Subtitulo: " + this.getSubtitulo() + '\n' +
                "Numero de Paginas: " + this.getNumeroPaginas() + '\n' +
                "DataPublicacao: " + this.getDataDePublicacao() + '\n' +
                "Editora: " + getEditora() + '\n' +
                "Quantidade: " + this.getQuantidade() + '\n' +
                ']' + "----------------------------------------------------";
    }



}

