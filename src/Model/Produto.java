package Model;

import java.time.LocalDate;
public abstract class Produto {

    public Produto(int id, String titulo, int quantidade, LocalDate dataPublicacao, String editora, Autor autor, Categoria categoria, String faixaEtaria) {
        this.id = id;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.dataDePublicacao = dataPublicacao;
        this.editora = editora;
        this.autor = autor;
        this.categoria = categoria;
        this.faixaEtaria = faixaEtaria;

        if (id > proximoId){
            proximoId = id;
        }
        if (id == 0){
            this.id = ++proximoId;
        }
    }



    public Produto(int id , String titulo, int quantidade, Autor nomeAutor, Categoria categoria, LocalDate dataDePublicacao, String faixaEtaria, String editora) {
        this.id = id;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.dataDePublicacao = dataDePublicacao;
        this.faixaEtaria = faixaEtaria;
        this.editora = editora;
        this.autor = nomeAutor;

        if (id > proximoId){
            proximoId = id;
        }
        if (id == 0){
            this.id = ++proximoId;
        }
    }
    private static int proximoId = 0;
    private int id;
    private String titulo;
    private int quantidade;
    private Categoria categoria;
    private LocalDate dataDePublicacao;
    private String faixaEtaria;
    private String editora;
    private Autor autor;




    public void decrementarQuantidade(){
        if(quantidade > 0){
            quantidade--;
        }
    }
    public void aumentarQuantidade(){
        quantidade ++;
    }

    public String getTitulo() {
        return titulo;
    }

    public Categoria getCategoria() {
        return categoria;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public abstract TipoProduto getTipo();


}