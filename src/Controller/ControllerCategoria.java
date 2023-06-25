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

    public void gravarFicheiroCategoria() {
        String conteudo = "";
        for (Categoria aux : categorias) {
            conteudo += aux.getNome() + "\n";
            conteudo += aux.getId() + "\n";

        }
        GestorFicheiros.gravarFicheiro("categorias.txt", conteudo);
    }

    /*
    Leitura e gravação na base de dados
     */

    public void lerBaseDadosCategoria() {

        try {

            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            ResultSet resultado = basedados.Selecao("SELECT * FROM categoria");

            while (resultado.next()) {

                Categoria aux = new Categoria(resultado.getInt("id"), resultado.getString("nome"));
                categorias.add(aux);
            }

            basedados.Desligar();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarCategoriaParaBaseDados(Categoria categoria, boolean atualizacao) {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();

            String script = "";

            if (atualizacao) {
                script = "UPDATE categoria set nome = '@02', where id = @01";
            } // upadate se o boolean for pra atualizar dados, senão insere
            else {
                script = "INSERT INTO categoria (id, nome)" +
                        " VALUES (@01, '@02')";
            }

            script = script.replace("@01", String.valueOf(categoria.getId()));
            script = script.replace("@02", categoria.getNome());

            for (int i = 30; i > 0; i--) {
                script = script.replace("'@" + String.format("%02d", i) + "'", "NULL"); //loop entre os dados que nao foram inseridos e substituem para "NULL"
                script = script.replace("@" + String.format("%02d", i), "NULL");
            }

            // executar o SCRIPT na base de dados
            basedados.Executar(script);

            basedados.Desligar();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    Funções de listagem
     */

    public ArrayList<Categoria> listarCategorias() {
        return categorias;
    }

    /*
    Funções de adição e remoção
     */

    public boolean adicionarCategorias(String nomeCategoria) {
        // Verificar se a categoria já existe
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equalsIgnoreCase(nomeCategoria)) {
                return false; // A categoria já existe, não é possível adicioná-la novamente
            }
        }

        Categoria adicionarCategoria = new Categoria(0, nomeCategoria);
        categorias.add(adicionarCategoria);
        gravarCategoriaParaBaseDados(adicionarCategoria, false);

        return true;
    }

    public void removerCategoriaBaseDados(int idCategoria) {

        try {

            BaseDados basedados = new BaseDados();
            basedados.Ligar();

            basedados.Executar("DELETE FROM categoria where id = '" + idCategoria + "'");

            basedados.Desligar();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

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
            categorias.remove(categoriaEncontrada);
            removerCategoriaBaseDados(idCategoria);
            return true;
        }
        return false; // A categoria não foi encontrada
    }

    /*
    Funções de pesquisa
     */

    public Categoria pesquisarCategoriaPorNome(String nomeCategoria) {
        for (Categoria categoria : categorias) {
            if (Objects.equals(categoria.getNome(), nomeCategoria)) {
                return categoria;
            }
        }
        return null;
    }

    public Categoria pesquisarCategoriaPorId(int idCategoria) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == idCategoria) {
                return categoria;
            }
        }
        return null;
    }


}

