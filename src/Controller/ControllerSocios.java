package Controller;


import Model.Socio;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerSocios {
    public static ArrayList<Socio> socios = new ArrayList<>();

    public void lerSociosDoFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("socios.txt");
        for (String linha : linhas) {
            if (linha.isEmpty() == false) {
                String[] value_split = linha.split("\\|");
                if (value_split.length != 0) {
                    Socio aux = new Socio(value_split[0],
                            value_split[1],
                            value_split[2],
                            LocalDate.parse(value_split[3]),
                            Integer.parseInt(value_split[4]));
                    socios.add(aux);
                }
            }
        }
    }

    public void gravarSociosParaFicheiro(){
        String conteudo = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Socio aux : socios){
            String formated_date = aux.getDataDeNascimento().format(formatter);

            conteudo += aux.getNumMecanografico() + "|";
            conteudo += aux.getNome() + "|" ;
            conteudo += aux.getMorada() + "|" ;
            conteudo += formated_date + "|" ;
            conteudo += aux.getTelefone() + "|" + "\n";
        }
        GestorFicheiros.GravarFicheiro("socios.txt", conteudo);
    }

    public String verificarNumMecanografico() {
        String max = "";
        for (Socio id : socios) {
            if (id.getNumMecanografico().compareTo(max) > 0) {
                max = id.getNumMecanografico();
            }
        }
        return max;
    }

    public void adicionarSocio(String nome, String morada, LocalDate dataDeNascimento, int telefone){
        this.verificarNumMecanografico();
        Socio socio = new Socio (nome, morada,dataDeNascimento,telefone);
        this.socios.add(socio);
    }
    public ArrayList<Socio> listarSocio(){
        return this.socios;

    }
    public boolean editarSocio (String numMecanografico , String nome, String morada, LocalDate dataDeNascimento, int telefone) {
        for (Socio socio : socios) {
            if (numMecanografico.equals(socio.getNumMecanografico())) {
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