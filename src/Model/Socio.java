package Model;

import java.time.LocalDate;

public class Socio extends Pessoa {

    public Socio(String nome, String morada, LocalDate dataDeNascimento, int telefone){
        super(nome, morada, dataDeNascimento);
        this.numMecanografico = ++ultimoNumMecanografico;
        this.telefone = telefone;
        this.produtosReservados = 0;
    }

    public Socio(int numMecanografico,String nome, String morada, LocalDate dataDeNascimento, int telefone) {
        super(nome, morada, dataDeNascimento);
        this.telefone = telefone;
        this.numMecanografico = numMecanografico;
        if (numMecanografico >ultimoNumMecanografico) {
            ultimoNumMecanografico = numMecanografico;
        }
    }
    private int produtosReservados;
    private int telefone;
    private final int numMecanografico;
    private static int ultimoNumMecanografico=0;

    public void aumentarQuantidade(){
        produtosReservados++;
    }
    public void decrementarQuantidade(){
        if(produtosReservados > 0){
            produtosReservados--;
        }
    }

    public void resetQuantidade(){
        produtosReservados = 0;

    }

    public int getProdutosReservados() {
        return produtosReservados;
    }

    public void setProdutosReservados(int produtosReservados) {
        this.produtosReservados = produtosReservados;
    }

    public int getNumMecanografico() {
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