package Model;

import java.time.LocalDate;

public class CD extends Produto{
    public CD(int id, String titulo, int quantidade, Autor nomeAutor, Categoria categoria, LocalDate dataDePublicacao, String faixaEtaria, String editora,
              String numCapitulos) {
        super(id, titulo, quantidade, nomeAutor, categoria, dataDePublicacao, faixaEtaria, editora);
        this.numCapitulos = numCapitulos;
    }
    private String numCapitulos;

    public String getNumCapitulos() {
        return numCapitulos;
    }

    public void setNumCapitulos(String numCapitulos) {
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
                "Autor: " + this.getAutor() + "\n" +
                "Número de capítulos: " + this.getNumCapitulos() + "\n" +
                "Categoria: " + this.getCategoria() + "\n" +
                "Data de publicacao: " + this.getDataDePublicacao() + "\n" +
                "Faixa etaria: " + this.getFaixaEtaria() + "\n" +
                "Editora: " + this.getEditora() + "]" + "\n" +
              "----------------------------------------------------";
    }

}
