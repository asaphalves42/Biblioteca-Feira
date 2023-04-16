package Controller;


import Model.Socio;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerSocios {

    ArrayList<Socio> socios = new ArrayList<>();

    public void adicionarSocio(String nome, String morada, LocalDate dataDeNascimento, int telefone){
    Socio socio= new Socio (nome,morada,dataDeNascimento,telefone);

        this.socios.add(socio);
    }
    public ArrayList<Socio> listarSocio(){
        return this.socios;

    }
    public boolean editarSocio (String nome, String morada, LocalDate dataDeNascimento, int telefone, String numMecanografico) {
        for (Socio socio : socios) {
            if ( numMecanografico== socio.getNumMecanografico()) {
                socio.setNome(nome);
                socio.setMorada(morada);
                socio.setDataDeNascimento(dataDeNascimento);
                socio.setTelefone(telefone);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Socio> pesquisarSocioPorNome(String nomeInserido) {
        ArrayList<Socio> nomeSocio = new ArrayList<>();
        for (Socio nome : socios) {
            if (nomeInserido.equalsIgnoreCase(nome.getNome())){
                nomeSocio.add(nome);
            }
        }
        return nomeSocio;
    }

    public ArrayList<Socio> pesquisarSocioPorNumMecanografico (String numMecanografico) {
        ArrayList<Socio> socioEncontrado = new ArrayList<>();
        for (Socio socio : socios) {
            if (numMecanografico == socio.getNumMecanografico()){
                socioEncontrado.add(socio);
            }
        }
        return socioEncontrado;
    }

    public boolean removerSocio(String numMecanografico) {
        for (Socio socio : socios) {
            if (numMecanografico.equals(socio.getNumMecanografico())) {
                socios.remove(socio);
                return true;
            }
        }
        System.out.println("Não existe sócio com o nome inserido");
        return false;
    }
}