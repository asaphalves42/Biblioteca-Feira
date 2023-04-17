package Model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Socio extends Pessoa {

    public Socio(String numMecanografico, String nome, String morada, LocalDate dataDeNascimento, int telefone){
        super(nome, morada, dataDeNascimento);
        this.numMecanografico = numMecanografico;
        this.telefone = telefone;
    }

    public Socio(String nome, String morada, LocalDate dataDeNascimento, int telefone) {
        super(nome, morada, dataDeNascimento);
        this.telefone = telefone;
        this.numMecanografico = gerarNumMecanografico();
    }
    private int telefone;
    private String numMecanografico;

    public String getNumMecanografico() {
        return numMecanografico;
    }

    public void setNumMecanografico(String numMecanografico) {
        this.numMecanografico = numMecanografico;
    }

    private String gerarNumMecanografico() {
        String numMecanografico = "";
        Set<String> numerosUtilizados = new HashSet<>();
        Random rand = new Random();

        while (numMecanografico.length() < 6) {
            numMecanografico += rand.nextInt(10);
        }

        numerosUtilizados.add(numMecanografico);

        return numMecanografico;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }


    @Override
    public String toString() {
        return "Sócio [ " + "\n" +
                "Número mecanográfico: " + this.numMecanografico + "\n" +
                "Nome: " + this.getNome() + "\n" +
                "Morada: " + this.getMorada() + "\n" +
                "Telefone: " + this.telefone + "\n" +
                "Data de nascimento: " + this.getDataDeNascimento() + "]" +
                "\n" + "----------------------------------------------";
    }
}