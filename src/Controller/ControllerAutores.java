package Controller;

import Model.Autor;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerAutores {

    ArrayList<Autor> autores = new ArrayList<>();

    /*public class lerAutorDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("Autores.txt");
        if (!linhas.isEmpty()) {
            for (String linha : linhas) {
                String[] value_split = linha.split("\\|");
                //Autor aux = new Autor(value_split[0], )
            }
        }
    }
*/
    public void gravarAutorParaFicheiro() {
        String conteudo = "";
        for (Autor aux : autores) {
            conteudo += aux.getNome() + "|";
            conteudo += aux.getMorada() + "|";
            conteudo += aux.getDataDeNascimento() + "|";
        }
        GestorFicheiros.GravarFicheiro("Autores.txt", conteudo);
    }


    public void adicionarAutores(int id, String nome, String morada, LocalDate dataDeNascimento) {
        Autor autor = new Autor(id, nome, morada, dataDeNascimento);
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

    public Autor pesquisarAutorPorId (int idInserido) {
        for (Autor autor : autores) {
            if (idInserido == autor.getId()){
                return autor;
            }
        }
        return null;
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

