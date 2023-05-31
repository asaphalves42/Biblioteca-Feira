package Controller;

import Model.Autor;
import Model.Produto;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import static Controller.ControllerProdutos.produtos;

public class ControllerAutores {
    public static ArrayList<Autor> autores = new ArrayList<>();

    public void lerAutorDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("Autores.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");

                Autor aux = new Autor(Integer.parseInt(value_split[0]),
                        value_split[1],
                        value_split[2],
                        LocalDate.parse(value_split[3]));
                autores.add(aux);
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
            conteudo += formated_date + "\n";
        }
        GestorFicheiros.gravarFicheiro("Autores.txt", conteudo);
    }



    public boolean adicionarAutores(String nome, String morada, LocalDate dataDeNascimento) {

        Autor autor = new Autor(nome, morada, dataDeNascimento);

        autores.add(autor);

        return true;
    }

    public ArrayList<Autor> listarAutores() {

        return autores;

    }

    public boolean editarAutor(int id, String nome, String morada, LocalDate dataDeNascimento) {
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
            if (nomeInserido.equalsIgnoreCase(nome.getNome())) {
                nomeAutor.add(nome);
            }
        }
        return nomeAutor;
    }
    public Autor pesquisarAutorPorNomeTESTE(String nomeInserido) {
        Autor autor;
        for (Autor nome : autores) {
            if (nomeInserido.equalsIgnoreCase(nome.getNome())) {
                autor= nome;
                return autor;
            }
        }
        return null;
    }

    public ArrayList<Autor> pesquisarAutorPorId(int idInserido) {
        ArrayList<Autor> autoresEncontrados = new ArrayList<>();
        for (Autor autor : autores) {
            if (idInserido == autor.getId()) {
                autoresEncontrados.add(autor);
            }
        }
        return autoresEncontrados;
    }

    public boolean removerAutor(int idAutor) {
        boolean autorAssociadoLivro = false;
        // Verifica se o autor está associado a algum livro
        for (Produto livro : produtos) {
            if (Objects.equals(livro.getAutor().getId(), idAutor)) {
                autorAssociadoLivro = true;
                break;
            }
        }
        if (autorAssociadoLivro) {
            // O autor está associado a um livro, não é possível removê-lo
            return false;
        } else {

            //buscar o autor da lista que imprimiu e apagar somente aquele

            //proximo sprint

            // Remove o autor da lista de autores
            int index = -1;
            for (int i = 0; i < autores.size(); i++) {
                if (autores.get(i).getId() == idAutor) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                autores.remove(index);
                return true;
            } else {
                // O autor não foi encontrado na lista de autores
                return false;
            }
        }
    }

}



