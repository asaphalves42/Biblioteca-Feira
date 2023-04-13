package Controller;

import Model.Autor;
import Model.Livro;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerAutores {
    ArrayList<Autor> autores = new ArrayList<>();
   public void lerAutorDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("Autores.txt");

            for (String linha : linhas) {
                if (linha.isEmpty() == false) {
                String[] value_split = linha.split("\\|");
                if(value_split.length !=0){
                    Autor aux = new Autor(Integer.parseInt(value_split[0]),
                            value_split[1],
                            value_split[2],
                    LocalDate.parse(value_split[3]));
                    autores.add(aux);
                }

            }
        }
    }

    public void gravarAutorParaFicheiro() {
        String conteudo = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Autor aux : autores) {
            String formated_date = aux.getDataDeNascimento().format(formatter);

            conteudo += aux.getId() + "|";
            conteudo += aux.getNome() + "|";
            conteudo += aux.getMorada() + "|";
            conteudo += formated_date +  "\n";
        }
        GestorFicheiros.GravarFicheiro("Autores.txt", conteudo);
    }

    public int verificarIdAutor(){
        int max = 0;
        for(Autor id : autores){
            if(id.getId() > max){
                max = id.getId();
            }
        }
        return max;

    }


    public void adicionarAutores(String nome, String morada, LocalDate dataDeNascimento) {
       this.verificarIdAutor();
        Autor autor = new Autor(nome, morada, dataDeNascimento);
        this.autores.add(autor);

    }

    public ArrayList<Autor> listarAutores() {

        return this.autores;

    }

    public boolean editarAutor (int id, String nome, String morada, LocalDate dataDeNascimento) {
        for (Autor autor : autores) {
            if (id == autor.getId()) {
                autor.setId(id);
                autor.setNome(nome);
                autor.setMorada(morada);
                autor.setDataDeNascimento(dataDeNascimento);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Autor> pesquisarAutorPorNome(String nomeInserido) {
        ArrayList<Autor> nomeAutor = new ArrayList<>();
            for (Autor nome : autores) {
                if (nomeInserido.equalsIgnoreCase(nome.getNome())){
                    nomeAutor.add(nome);
                }
            }
        return nomeAutor;
    }

    public ArrayList<Autor> pesquisarAutorPorId (int idInserido) {
        ArrayList<Autor> autoresEncontrados = new ArrayList<>();
        for (Autor autor : autores) {
            if (idInserido == autor.getId()){
                autoresEncontrados.add(autor);
            }
        }
        return autoresEncontrados;
    }

    public boolean removerAutor(String nomeAutor) {
        for (Autor autor : autores) {
            if (nomeAutor.equals(autor.getNome())) {
                autores.remove(autor);
                return true;
            }
        }
        System.out.println("Não existe autor(a) com o nome inserido");
        return false;
    }

    public boolean editarAutor(String novoNome, String novaMorada) {
        return false;
    }
}

