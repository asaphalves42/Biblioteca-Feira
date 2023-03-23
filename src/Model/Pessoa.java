package Model;

import java.util.Date;

public class Pessoa {
    private String nome;
    private String morada;
    private Date dataDeNascimento;


    public Pessoa (){

    }
    public Pessoa(String nome, String morada, Date dataDeNascimento) {
        this.nome = nome;
        this.morada = morada;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }


}
