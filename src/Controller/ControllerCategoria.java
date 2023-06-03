package Controller;


import Model.Categoria;
import Model.Produto;
import Utilidades.BaseDados;
import Utilidades.GestorFicheiros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static Controller.ControllerProdutos.produtos;

public class ControllerCategoria {
    public static ArrayList<Categoria> categorias = new ArrayList<>();
    public static ArrayList<Integer> eliminados = new ArrayList<Integer>();

    public void lerFicheiroCategoria() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("categorias.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");
                if (value_split.length != 0) {
                    Categoria aux = new Categoria(
                            Integer.parseInt(value_split[0]),
                            value_split[1]);

                    categorias.add(aux);
                }

            }
        }
    }

    public void gravarFicheiroCategoria(){
        String conteudo = "";
        for (Categoria aux : categorias) {
            conteudo += aux.getNome() + "\n";
            conteudo += aux.getId() + "\n";

        }
        GestorFicheiros.gravarFicheiro("categorias.txt", conteudo);
    }

    public void lerBaseDadosCategoria() {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            ResultSet resultado = basedados.Selecao("select * from categoria");

            while(resultado.next()){
                // enquanto existirem registos, vou ler 1 a 1
                Categoria aux = new Categoria(resultado.getInt("id"), resultado.getString("nome"));
                categorias.add(aux);
            }
            basedados.Desligar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarCategoriParaBaseDados(){
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            //insere ou atualizar os registos
            for (Categoria aux : categorias) {
                if (aux.getPendenteGravacao()) {
                    basedados.Executar("DELETE FROM categoria where id = " + aux.getId()); //deve ser alterado para o ID quando existir;
                    basedados.Executar("INSERT INTO categoria (id, nome) values (" + aux.getId() + ", '" + aux.getNome() + "')");
                }
            }

            //eliminar registos que foram apagados
            if (eliminados.size() > 0){
                for (Integer aux : eliminados) {
                    basedados.Executar("DELETE FROM categoria where id = '" + aux + "'");
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

        Categoria adicionarCategoria = new Categoria(0, nomeCategoria);
        adicionarCategoria.setPendenteGravacao(true);
        categorias.add(adicionarCategoria);

        return true;
    }

    public Categoria pesquisarCategoriaPorNome(String nomeCategoria){
        for(Categoria categoria : categorias){
            if(Objects.equals(categoria.getNome(), nomeCategoria)){
                return categoria;
            }
        }
        return null;
    }
    public Categoria pesquisarCategoriaPorId(int idCategoria){
        for(Categoria categoria : categorias){
            if(categoria.getId() == idCategoria){
                return categoria;
            }
        }
        return null;
    }

    public boolean removerCategoria(int idCategoria) {
        Categoria categoriaEncontrada = pesquisarCategoriaPorId(idCategoria);

        if (categoriaEncontrada != null) {
            // Verifica se a categoria está associada a algum produto
            for (Produto produto : produtos) {
                if (produto.getCategoria().getId() == idCategoria) {
                    // A categoria está associada a um produto, não é possível remover
                    return false;
                }
            }

            // Remove a categoria da lista de categorias
            eliminados.add(categoriaEncontrada.getId());
            categorias.remove(categoriaEncontrada);
            return true;
        }
        return false; // A categoria não foi encontrada
    }

    public ArrayList<Categoria> listarCategorias() {
        return categorias;
    }
}
