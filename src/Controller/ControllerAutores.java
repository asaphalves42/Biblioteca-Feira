package Controller;

import Model.Autor;
import Model.Produto;
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
    public static ArrayList<Integer> eliminados = new ArrayList<Integer>();

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


    // lista com os identificadores dos registos eliminados. utilizado durante o processo de gravação


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

    public void gravarAutorParaBaseDados() {

        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            //insere ou atualizar os registos
            for (Autor aux : autores) {
                if (aux.getPendenteGravacao()) {
                    basedados.Executar("DELETE FROM autor where id = " + aux.getId());
                    basedados.Executar("INSERT INTO autor (id, nome, morada, data_nascimento) " +
                            " values ('" + aux.getId() + "', '" + aux.getNome() + "', '" + aux.getMorada() + "', '" + aux.getDataDeNascimento().format(formatter) + "')");
                }
            }

            //eliminar registos que foram apagados
            if (eliminados.size() > 0) {
                for (Integer aux : eliminados) {
                    basedados.Executar("DELETE FROM autor where id = " + aux);
                }
                eliminados.clear(); //apago o array porque já foi processado
            }

            basedados.Desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public boolean adicionarAutores(String nome, String morada, LocalDate dataDeNascimento) {

        Autor autor = new Autor(nome, morada, dataDeNascimento);
        autor.setPendenteGravacao(true);
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
                autor.setPendenteGravacao(true);

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
                eliminados.add(idAutor);
                autores.remove(index);
                return true;
            } else {
                // O autor não foi encontrado na lista de autores
                return false;
            }
        }
    }

}



