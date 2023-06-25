package Controller;

import Model.*;
import Utilidades.BaseDados;
import Utilidades.GestorFicheiros;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    /*
        Leitura e gravação na base de dados
    */

    public void lerAutorDeBaseDados() {

        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            ResultSet resultado = basedados.Selecao("select * from autor");

            while (resultado.next()) {
                // enquanto existirem registos, vou ler 1 a 1
                Autor aux = new Autor(resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("morada"),
                        resultado.getDate("data_nascimento").toLocalDate());
                autores.add(aux);
            }
            basedados.Desligar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarAutorParaBaseDados(Autor autor, boolean atualizacao) {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();

            String script = "";
            if (atualizacao) {
                script = "UPDATE autor set nome = '@02', morada = '@03', data_nascimento = '@04' where id = @01";
            } // upadate se o boolean for pra atualizar dados, senão insere
            else {
                script = "INSERT INTO autor (id, nome, morada, data_nascimento)" +
                        " VALUES (@01, '@02', '@03', '@04')";
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            ;

            script = script.replace("@01", String.valueOf(autor.getId()));
            script = script.replace("@02", autor.getNome());
            script = script.replace("@03", autor.getMorada());
            script = script.replace("@04", autor.getDataDeNascimento().format(formatter));

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

    public ArrayList<Autor> listarAutores() {

        return autores;

    }

    /*
    Funções de adição e remoção
     */

    public boolean adicionarAutores(String nome, String morada, LocalDate dataDeNascimento) {

        Autor autor = new Autor(nome, morada, dataDeNascimento);
        autores.add(autor);
        gravarAutorParaBaseDados(autor, false);

        return true;
    }

    public void removerAutorBaseDados(int idAutor) {

        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();

            basedados.Executar("DELETE FROM autor where id = '" + idAutor + "'");

            basedados.Desligar();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
                removerAutorBaseDados(idAutor);
                return true;
            } else {
                // O autor não foi encontrado na lista de autores
                return false;

            }

        }
    }

    /*
    Funções de edição
     */

    public boolean editarAutor(int id, String nome, String morada, LocalDate dataDeNascimento) {
        for (Autor autor : autores) {
            if (id == autor.getId()) {
                autor.setId(id);
                autor.setNome(nome);
                autor.setMorada(morada);
                autor.setDataDeNascimento(dataDeNascimento);
                gravarAutorParaBaseDados(autor, true);
                return true;
            }
        }
        return false;
    }

    /*
    Funções de pesquisa
     */

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
                autor = nome;
                return autor;
            }
        }
        return null;
    }


    public Autor pesquisarAutorPorIdBD(int idInserido) {
        for (Autor autor : autores) {
            if (idInserido == autor.getId()) {
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


}



