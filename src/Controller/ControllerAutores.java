package Controller;

import Model.Autor;
import Model.Produto;
import Utilidades.BaseDados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import static Controller.ControllerProdutos.produtos;

public class ControllerAutores {
    public static ArrayList<Autor> autores = new ArrayList<>();
    // lista com os identificadores dos registos eliminados. utilizado durante o processo de gravação
    public static ArrayList<String> eliminados = new ArrayList<>();
    public void lerAutorDeBaseDados() {

        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            ResultSet resultado = basedados.Selecao("select * from autor inner join pessoa on autor.id_pessoa = pessoa.id");

            while(resultado.next()){
                // enquanto existirem registos, vou ler 1 a 1
                Autor aux = new Autor(resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("morada"),
                        LocalDate.parse(resultado.getDate("data_nascimento").toString()));
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
                    basedados.Executar("DELETE FROM pessoa where id = '" + aux.getIdPessoa() + "'");
                    basedados.Executar("INSERT INTO pessoa (id, nome, morada, data_nascimento) " +
                            " values ('" + aux.getIdPessoa() + "', '" + aux.getNome() + "', '" + aux.getMorada() + "', '"+aux.getDataDeNascimento().format(formatter)+"')");
                    basedados.Executar("INSERT INTO autor (id, id_pessoa) " +
                            " values (" + aux.getId() + ", '" + aux.getIdPessoa()+"')");

                }
            }

            //eliminar registos que foram apagados
            if (eliminados.size() > 0){
                for (String aux : eliminados) {
                    basedados.Executar("DELETE FROM autor where id_pessoa = " + aux);
                    basedados.Executar("DELETE FROM pessoa where id = " + aux);
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
            // Remove o autor da lista de autores
            int index = -1;
            for (int i = 0; i < autores.size(); i++) {
                if (autores.get(i).getId() == idAutor) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                this.eliminados.add(autores.get(index).getIdPessoa());
                autores.remove(index);
                return true;
            } else {
                // O autor não foi encontrado na lista de autores
                return false;
            }
        }
    }

}



