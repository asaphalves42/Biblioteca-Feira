package Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Socio extends Pessoa {

    public Socio(String nome, String morada, Date dataDeNascimento, String telefone) {
        super(nome, morada, dataDeNascimento);
        this.telefone = telefone;
        this.numMecanografico = gerarNumMecanografico();
    }
    private String telefone;
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

        while (numerosUtilizados.contains(numMecanografico)) {
            numMecanografico = "";
            while (numMecanografico.length() < 6) {
                numMecanografico += rand.nextInt(10);
            }
        }

        numerosUtilizados.add(numMecanografico);

        return numMecanografico;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Sócio [ " + "\n" +
                "Nome: " + this.getNome() + "\n" +
                "Morada: " + this.getMorada() + "\n" +
                "Telefone: " + this.telefone + "\n" +
                "Data de nascimento: " + this.getDataDeNascimento() + "\n" +
                "Número mecanográfico: " + this.numMecanografico +
                "]" + "\n" +
                " " + "\n" + "----------------------------------------------";
    }
}