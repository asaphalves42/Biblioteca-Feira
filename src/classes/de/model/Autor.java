package classes.de.model;

import java.util.Date;

public class Autor extends Pessoa {
    public Autor() {
    }

    public Autor(String nome, String morada, Date dataDeNascimento) {
        super(nome, morada, dataDeNascimento);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getMorada() {
        return super.getMorada();
    }

    @Override
    public Date getDataDeNascimento() {
        return super.getDataDeNascimento();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setMorada(String morada) {
        super.setMorada(morada);
    }

    @Override
    public void setDataDeNascimento(Date dataDeNascimento) {
        super.setDataDeNascimento(dataDeNascimento);
    }
}
