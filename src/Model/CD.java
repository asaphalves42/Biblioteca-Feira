package Model;

import java.time.LocalDate;

public class CD extends Produto{
    public CD(int id, String titulo, int quantidade, Autor nomeAutor, Categoria categoria, LocalDate dataDePublicacao, String faixaEtaria, String editora,
              int numCapitulos) {
        super(id, titulo, quantidade, nomeAutor, categoria, dataDePublicacao, faixaEtaria, editora);
        this.numCapitulos = numCapitulos;
    }
    private int numCapitulos;

    public int getNumCapitulos() {
        return numCapitulos;
    }

    public void setNumCapitulos(int numCapitulos) {
        this.numCapitulos = numCapitulos;
    }

    @Override
    public String getTipo() {
        return "CD";
    }
    public String toString() {
        return getTipo()+" [ " + "\n" +
                "ID: " + this.getId() + "\n" +
                "Quantidade: " + this.getQuantidade() + "\n" +
                "Título: " + this.getTitulo() + "\n" +
                "Autor: " + this.getAutor().getNome() + "\n" +
                "Número de capítulos: " + this.getNumCapitulos() + "\n" +
                "Categoria: " + this.getCategoria().getNome() + "\n" +
                "Data de lançamento: " + this.getDataDePublicacao() + "\n" +
                "Faixa etaria: " + this.getFaixaEtaria() + "\n" +
                "Produtora: " + this.getEditora() + "]" + "\n" +
              "----------------------------------------------------";
    }

}
