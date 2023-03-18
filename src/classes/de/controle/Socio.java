package classes.de.controle;

import java.util.Date;

public class Socio extends Pessoa {
    private String telefone;

    public Socio(String telefone) {
        this.telefone = telefone;
    }

    public Socio(){

    }
    public Socio(String nome, String morada, Date dataDeNascimento, String telefone) {
        super(nome, morada, dataDeNascimento);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
