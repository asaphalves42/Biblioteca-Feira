package Model;

import java.time.LocalDate;

public class Pessoa {

    public Pessoa(String nome, String morada, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.morada = morada;
        this.dataDeNascimento = dataDeNascimento;
    }
    private String nome;
    private String morada;
    private LocalDate dataDeNascimento;


    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

}
