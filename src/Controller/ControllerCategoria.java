package Controller;


import Model.Categoria;
import Model.Livro;
import Utilidades.GestorFicheiros;

import java.util.ArrayList;
import java.util.Objects;

import static Controller.ControllerLivros.livros;

public class ControllerCategoria {
    public static ArrayList<Categoria> categorias = new ArrayList<>();

    public void lerFicheiroCategoria() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("categorias.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");
                if (value_split.length != 0) {
                    Categoria aux = new Categoria(
                            value_split[0]);

                    categorias.add(aux);
                }

            }
        }
    }

    public void gravarFicheiroCategoria(){
        String conteudo = "";
        for (Categoria aux : categorias) {
            conteudo += aux.getNome() + "\n";

        }
        GestorFicheiros.gravarFicheiro("categorias.txt", conteudo);
    }

    public boolean adicionarCategorias(String nomeCategoria){
        //verfificar se categoria ja existe
        Categoria adicionarCategoria = new Categoria(nomeCategoria);
        categorias.add(adicionarCategoria);
        return true;

    }

    public Categoria pesquisarCategoria(String nomeCategoria){
        for(Categoria categoria : categorias){
            if(Objects.equals(categoria.getNome(), nomeCategoria)){
                return categoria;
            }
        }

        return null;
    }

    public boolean removerCategoria(Categoria categoriaRemover) {
        // Verifica se a categoria está associada a algum livro
        for (Livro livro : livros) {
            if (livro.getCategoria().equals(categoriaRemover)) {
                // A categoria está associada a um livro, não é possível remover
                return false;
            }
        }
        // Remove a categoria da lista de categorias
        categorias.remove(categoriaRemover);
        return true;
    }

    public ArrayList<Categoria> listarCategorias() {
        return categorias;
    }
}
