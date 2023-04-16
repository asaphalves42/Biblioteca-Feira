package View.Livros;


import Controller.ControllerLivrosEautores;
import Model.Autor;
import Utilidades.ValidacaoData;
import View.Categorias.Categorias;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.*;

public class ViewAdicionarLivrosEautores {
    ArrayList<String> categorias = new ArrayList<>();
    public void menuAdicionarLivros(ControllerLivrosEautores gestorAutor) {

        String titulo = "";
        while (titulo.trim().isEmpty()) {
            titulo = leStr("Introduza o titulo: ");
            if (titulo.trim().isEmpty()) {
                System.out.println("Por favor, introduza um titulo válido!");
            }
        }

        String subtitulo = "";
        while (subtitulo.trim().isEmpty()) {
            subtitulo = leStr("Introduza o subtitulo: ");
            if (subtitulo.trim().isEmpty()) {
                System.out.println("Por favor, introduza um subtitulo válido!");
            }
        }

        int quantidade = leIntPositivo("Introduza a quantidade: ");

        int numDePaginas = leIntPositivo("Introduza o número de páginas: ");

        ArrayList<Autor> adicionarAutorExistente;
        String nomeAutor;
        while (true) {
            nomeAutor = leStr("Insira o autor:");
            adicionarAutorExistente = gestorAutor.pesquisarAutorPorNome(nomeAutor);

            if (adicionarAutorExistente.isEmpty()) {
                System.out.println("Não existem autores com esse nome!");
                System.out.println(" ");
            } else {
                for (Autor autor : adicionarAutorExistente) {
                    System.out.println(autor.toString());
                }
                break;
            }
        }

        int idAdicionarAutor = leint("Insira o id do autor que quer adicionar: ");

        Autor autorAdicionado = null;
        for (Autor autor : adicionarAutorExistente) {
            if (autor.getId() == idAdicionarAutor) {
                autorAdicionado = autor;
                break;
            }
        }

        if (autorAdicionado != null) {
            gestorAutor.adicionarAutor(String.valueOf(autorAdicionado));

            System.out.println("Autor adicionado com sucesso!");
            System.out.println(" ");
        }

        Categorias escolherCat = new Categorias();
        int opcaoCategoria = escolherCat.escolherCategorias();

        switch (opcaoCategoria) {
            case 1:
                categorias.add("Artes");
                break;
            case 2:
                categorias.add("Ciencias");
                break;
            case 3:
                categorias.add("Matematica");
                break;
            case 4:
                categorias.add("Psicologia");
                break;
            case 5:
                categorias.add("Tecnologia");
                break;
            default:
                break;
        }

        System.out.println("Digite a data de publicação do livro: ");
        ValidacaoData validarData = new ValidacaoData();
        LocalDate dataDePublicacao = validarData.LerData2();

        String faixaEtaria = "";
        while (faixaEtaria.trim().isEmpty()) {
            faixaEtaria = leStr("Introduza a faixa etaria: ");
            if (faixaEtaria.trim().isEmpty()) {
                System.out.println("Por favor, introduza uma faixa etaria válida");
            }
        }

        String editora = "";
        while (editora.trim().isEmpty()) {
            editora = leStr("Introduza a editora: ");
            if (editora.trim().isEmpty()) {
                System.out.println("Por favor, introduza uma editora válido!");
            }
        }

        String ISBN = "";
        while (ISBN.trim().isEmpty()) {
            ISBN = leStr("Introduza o ISBN: ");
            if (ISBN.trim().isEmpty()) {
                System.out.println("Por favor, introduza um ISBN válido!");
            }
        }

        System.out.println(" ");
        System.out.println("Livro adicionado com sucesso!");
        System.out.println(" ");

        gestorAutor.adicionarLivrosComAutores(titulo,subtitulo,quantidade, numDePaginas,autorAdicionado, categorias, dataDePublicacao,faixaEtaria,editora,ISBN);
    }

    }

