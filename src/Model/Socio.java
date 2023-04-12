package Model;

import java.time.LocalDate;

public class Socio extends Pessoa {

    public Socio(String nome, String morada, LocalDate dataDeNascimento, String telefone, String numMecanografico) {
        super(nome, morada, dataDeNascimento);
        this.telefone = telefone;
        this.numMecanografico = numMecanografico;
    }
    private String telefone;
    private String numMecanografico;

    public String getNumMecanografico() {
        return numMecanografico;
    }

    public void setNumMecanografico(String numMecanografico) {
        this.numMecanografico = numMecanografico;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
