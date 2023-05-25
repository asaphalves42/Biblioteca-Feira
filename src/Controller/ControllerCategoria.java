package Controller;


import Model.Categoria;
import Model.Produto;
import Utilidades.BaseDados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static Controller.ControllerProdutos.produtos;

public class ControllerCategoria {
    public static ArrayList<Categoria> categorias = new ArrayList<>();

    // lista com os identificadores dos registos eliminados. utilizado durante o processo de gravação
    public static ArrayList<String> eliminados = new ArrayList<String>();
    public void lerBaseDadosCategoria() {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            ResultSet resultado = basedados.Selecao("select * from categoria");

            while(resultado.next()){
                // enquanto existirem registos, vou ler 1 a 1
                Categoria aux = new Categoria(resultado.getString("nome"));
                categorias.add(aux);
            }
            basedados.Desligar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarFicheiroCategoria(){
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            //insere ou atualizar os registos
            int contador = 0;
            for (Categoria aux : categorias) {
                contador++;
                if (aux.getPendenteGravacao()) {
                    basedados.Executar("DELETE FROM categoria where id = " + contador); //deve ser alterado para o ID quando existir;
                    basedados.Executar("INSERT INTO categoria (id, nome) values (" + contador + ", '" + aux.getNome() + "')");
                }
            }

            //eliminar registos que foram apagados
            if (eliminados.size() > 0){
                for (String aux : eliminados) {
                    basedados.Executar("DELETE FROM categoria where nome = '" + aux + "'");
                }
                eliminados.clear(); //apago o array porque já foi processado
            }

            basedados.Desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adicionarCategorias(String nomeCategoria){
        // Verificar se a categoria já existe
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equalsIgnoreCase(nomeCategoria)) {
                return false; // A categoria já existe, não é possível adicioná-la novamente
            }
        }

        Categoria adicionarCategoria = new Categoria(nomeCategoria);
        adicionarCategoria.setPendenteGravacao(true);
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
        for (Produto livro : produtos) {
            if (livro.getCategoria().getNome().equalsIgnoreCase(categoriaRemover.getNome())) {
                // A categoria está associada a um livro, não é possível remover
                return false;
            }
        }
        // Remove a categoria da lista de categorias
        eliminados.add(categoriaRemover.getNome()); //deve ser adicionado o ID
        categorias.remove(categoriaRemover);
        return true;
    }

    public ArrayList<Categoria> listarCategorias() {
        return categorias;
    }
}
