package Model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Socio extends Pessoa {

    public Socio(String nome, String morada, LocalDate dataDeNascimento, int telefone){
        super(nome, morada, dataDeNascimento);
        this.numMecanografico = ++ultimoNumMecanografico;
        this.telefone = telefone;
        this.livrosReservados = 0;
    }

    public Socio(int numMecanografico,String nome, String morada, LocalDate dataDeNascimento, int telefone) {
        super(nome, morada, dataDeNascimento);
        this.telefone = telefone;
        this.numMecanografico = numMecanografico;
        if (numMecanografico >ultimoNumMecanografico) {
            ultimoNumMecanografico = numMecanografico;
        }
    }
    private int livrosReservados;
    private int telefone;
    private int numMecanografico;
    private static int ultimoNumMecanografico=0;

    public void aumentarQuantidade(){
        livrosReservados++;
    }
    public void decrementarQuantidade(){
        if(livrosReservados > 0){
            livrosReservados--;
        }
    }

    public int getLivrosReservados() {
        return livrosReservados;
    }

    public void setLivrosReservados(int livrosReservados) {
        this.livrosReservados = livrosReservados;
    }

    public int getNumMecanografico() {
        return numMecanografico;
    }

    public void setNumMecanografico(int numMecanografico) {
        this.numMecanografico = numMecanografico;
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