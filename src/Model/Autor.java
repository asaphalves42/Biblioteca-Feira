package Model;

import java.time.LocalDate;

public class Autor extends Pessoa {

    public Autor(int id, String nome, String morada, LocalDate dataDeNascimento) {
        super(nome, morada, dataDeNascimento);
        this.id = ultimoId ++;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    private static int ultimoId = 1;
    @Override
    public String toString() {
        return  "Autor: " + "\n" +
                "ID: " + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "Morada: " + getMorada() + "\n" +
                "Data de nascimento: " + getDataDeNascimento() + "\n" +
                " " + "----------------------------------------------------" + "\n";

    }
 }
