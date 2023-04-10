package Controller;

import Model.Autor;
import Utilidades.GestorFicheiros;

import java.util.ArrayList;
import java.util.Date;

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


    public void adicionarAutores(String id, String nome, String morada, Date dataDeNascimento) {
        Autor autor = new Autor(id, nome, morada, dataDeNascimento);
        this.autores.add(autor);

    }

    public ArrayList<Autor> listarAutores() {

        return this.autores;

    }

    public boolean editarAutor (String id, String nome, String morada, Date dataDeNascimento) {
        for (Autor autor : autores) {
            if (id.equals(autor.getId())) {
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

    public ArrayList<Autor> pesquisarAutorPorId (String idInserido) {
        ArrayList<Autor> idAutor = new ArrayList<>();
            for (Autor id : autores) {
                if (idInserido.equalsIgnoreCase(id.getId())){
                    idAutor.add(id);
                }
            }
        return idAutor;
    }

    public boolean removerAutor(String idAutor) {
        for (Autor autor : autores) {
            if (idAutor.equals(autor.getId())) {
                autores.remove(autor);
                return true;
            }
        }
        System.out.println("Não existe autor com o ID inserido");
        return false;
    }
}

