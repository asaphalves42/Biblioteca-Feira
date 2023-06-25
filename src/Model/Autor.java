package Model;

import java.time.LocalDate;

public class Autor extends Pessoa {

    public Autor(String nome, String morada, LocalDate dataDeNascimento) {
        super(nome, morada, dataDeNascimento);
        this.id = ++ultimoId;
        this.setNome(nome);
        this.setMorada(morada);
        this.setDataDeNascimento(dataDeNascimento);


    }
    public Autor(int id, String nome, String morada, LocalDate dataDeNascimento){
        super(nome, morada, dataDeNascimento);
        this.id = id;
        this.setNome(nome);
        this.setMorada(morada);
        this.setDataDeNascimento(dataDeNascimento);

        if(id>ultimoId){
            ultimoId = id;
        }

    }
    private int id;
    private static int ultimoId = 0;

    public Autor() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "[Autor: " + "\n" +
                "ID: " + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "Morada: " + getMorada() + "\n" +
                "Data de nascimento: " + getDataDeNascimento() + "]" + "\n"
                + "----------------------------------------------------";

    }
 }
