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

        boolean sair = false;
        do {

            System.out.println("Caso pretenda sair, digite 'sair'");
            String titulo = "";
            while (titulo.trim().isEmpty()) {
                titulo = leStr("Introduza o titulo: ");
                if (titulo.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (titulo.trim().isEmpty()) {
                    System.out.println("Por favor, introduza um titulo válido!");
                }
            }
            if (sair) {
                break;
            }
            String subtitulo = "";
            while (subtitulo.trim().isEmpty()) {
                subtitulo = leStr("Introduza o subtitulo: ");
                if (subtitulo.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (subtitulo.trim().isEmpty()) {
                    System.out.println("Por favor, introduza um subtitulo válido!");
                }
            }
            if (sair) {
                break;
            }
            int quantidade = leIntPositivo("Introduza a quantidade: ");
            System.out.println("");

            int numDePaginas = leIntPositivo("Introduza o número de páginas: ");
            System.out.println("");

            ArrayList<Autor> adicionarAutorExistente;
            String nomeAutor;
            while (true) {
                nomeAutor = leStr("Insira o nome do(a) autor(a):");
                if (nomeAutor.equalsIgnoreCase("sair")) {
                    return;
                }
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


            int idAdicionarAutor = 0;
            while (true) {
                String inputId = leStr("Insira o Id do(a) autor(a) que quer adicionar: ");

                if (inputId.equalsIgnoreCase("sair")) {
                    break;
                } else {
                    try {
                        idAdicionarAutor = Integer.parseInt(inputId);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, insira um número inteiro.");
                    }
                }
            }

            Autor autorAdicionado = null;
            if (idAdicionarAutor > 0) {
                autorAdicionado = null;
                for (Autor autor : adicionarAutorExistente) {
                    if (autor.getId() == idAdicionarAutor) {
                        autorAdicionado = autor;
                        break;
                    }
                }

                if (autorAdicionado != null) {
                    gestorAutor.adicionarAutor(String.valueOf(autorAdicionado));

                    System.out.println("Autor(a) adicionado(a) com sucesso!");
                    System.out.println(" ");
                }
            }

            if (autorAdicionado != null) {
                gestorAutor.adicionarAutor(String.valueOf(autorAdicionado));

                System.out.println("Autor(a) adicionado(a) com sucesso!");
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
                if (faixaEtaria.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (faixaEtaria.trim().isEmpty()) {
                    System.out.println("Por favor, introduza uma faixa etaria válida");
                }
            }
            if (sair) {
                break;
            }
            String editora = "";
            while (editora.trim().isEmpty()) {
                editora = leStr("Introduza a editora: ");
                if (editora.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (editora.trim().isEmpty()) {
                    System.out.println("Por favor, introduza uma editora válido!");
                }
            }
            if (sair) {
                break;
            }

            String ISBN = "";
            while (ISBN.trim().isEmpty()) {
                ISBN = leStr("Introduza o ISBN: ");
                if (ISBN.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (ISBN.trim().isEmpty()) {
                    System.out.println("Por favor, introduza um ISBN válido!");
                }
            }
            if (sair) {
                break;
            }
            System.out.println("Livro " + titulo + " adicionado com sucesso!");
            System.out.println(" ");

            gestorAutor.adicionarLivrosComAutores(titulo, subtitulo, quantidade, numDePaginas, autorAdicionado, categorias, dataDePublicacao, faixaEtaria, editora, ISBN);

        } while (sair);
    }

}