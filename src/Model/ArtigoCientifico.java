package Model;

import java.time.LocalDate;

public class ArtigoCientifico extends Produto {
    public ArtigoCientifico(int id, String titulo,Autor autor,String resumo, PalavraChave palavrachave,int numeroPaginas, int quantidade, LocalDate dataPublicacao){
        super(id,titulo,quantidade, autor, dataPublicacao, palavrachave, numeroPaginas);
            this.numeroPaginas=numeroPaginas;
            this.resumo=resumo;

    }
    private String resumo;

    public String getResumo() {
        return resumo;
    }



    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    private int numeroPaginas;


    @Override
    public TipoProduto getTipo() {
        return TipoProduto.ArtigoCientifico;
    }

    @Override
    public String toString() {
        return getTipo()+" [ " +  "\n" +
                "ID: " +this.getId() + "\n" +
                "Titulo: "+this.getTitulo() + "\n" +
                "Autor: "+this.getAutor() + "\n" +
                "Palavras Chaves: "+ getPalavraschave() + "\n" +
                "Resumo: " + this.getResumo() + '\'' +
                "Numero de Paginas: " + this.getNumeroPaginas() + "\n" +
                "Data de Publicacao: " + this.getDataDePublicacao() + "\n" +
                "Quantidade: " + this.getQuantidade() + "\n" +
                ']'+ "----------------------------------------------------";
    }
}
