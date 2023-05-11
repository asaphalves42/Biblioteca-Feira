package Model;

import java.time.LocalDate;

public class Livro {
    public Livro(String titulo, String subtitulo, int quantidade, int numDePaginas, Autor autorAdicionado, Categoria categoria, LocalDate dataDePublicacao, String faixaEtaria, String editora, String ISBN) {
        this.id = ++proximoId;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.quantidade = quantidade;
        this.numDePaginas = numDePaginas;
        this.autor = autorAdicionado;
        this.categoria = categoria;
        this.dataDePublicacao = dataDePublicacao;
        this.faixaEtaria = faixaEtaria;
        this.editora = editora;
        this.ISBN = ISBN;
    }

    public Livro(int id, String titulo, String subtitulo, int quantidade, Autor autorAdicionado, int numDePaginas, Categoria categoria, LocalDate dataDePublicacao, String faixaEtaria, String editora, String ISBN) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.quantidade = quantidade;
        this.numDePaginas = numDePaginas;
        this.categoria = categoria;
        this.dataDePublicacao = dataDePublicacao;
        this.faixaEtaria = faixaEtaria;
        this.editora = editora;
        this.ISBN = ISBN;
        this.autor = autorAdicionado;

        if(id>proximoId){
            proximoId = id;
        }
    }
    private static int proximoId = 0;
    private int id;
    private String titulo;
    private String subtitulo;
    private int quantidade;
    private int numDePaginas;
    private Categoria categoria;
    private LocalDate dataDePublicacao;
    private String faixaEtaria;
    private String editora;
    private String ISBN;
    private Autor autor;


    public void decrementarQuantidade(){
        if(quantidade > 0){
            quantidade--;
        }
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

    public LocalDate getDataDePublicacao() {
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


    public void setDataDePublicacao(LocalDate dataDePublicacao) {
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Livro [ " + "\n" +
                "ID: " + this.id + "\n" +
                "Quantidade: " + this.quantidade + "\n" +
                "Título: " + this.titulo + "\n" +
                "Subtitulo: " + this.subtitulo + "\n" +
                "Autor: " + this.autor.getNome() + "\n" +
                "Número de páginas: " + this.numDePaginas + "\n" +
                "Categoria: " + categoria.getNome() + "\n" +
                "Data de publicacao: " + this.dataDePublicacao + "\n" +
                "Faixa etaria: " + this.faixaEtaria + "\n" +
                "Editora: " + this.editora + "\n" +
                "ISBN: " + this.ISBN + "]"+ "\n" + "----------------------------------------------------";

    }
}

