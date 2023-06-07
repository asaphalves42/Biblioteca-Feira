package View.Livros;


import Controller.ControllerAutores;
import Controller.ControllerCategoria;
import Controller.ControllerProdutos;
import Model.Autor;
import Model.Categoria;
import Utilidades.ValidacaoData;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.leIntPositivo;
import static Utilidades.Leitura.leStr;

public class ViewAdicionarLivros {
    public void menuAdicionarLivros(ControllerProdutos gestor, ControllerCategoria gestorCategoria, ControllerAutores gestorAutores){

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
            System.out.println(" ");

            int numDePaginas = leIntPositivo("Introduza o número de páginas: ");
            System.out.println(" ");

            //adicionar autor com autor existente no programa

            ArrayList<Autor> adicionarAutorExistente = null;
            String nomeAutor;

            ArrayList<Autor> autoresListados = gestorAutores.listarAutores();
            for (Autor autor : autoresListados) {
                System.out.println(autor.toString());
            }
            nomeAutor = leStr("Insira o nome do(a) autor(a):");
            if (nomeAutor.equalsIgnoreCase("sair")) {
                return;
            }
            adicionarAutorExistente = gestorAutores.pesquisarAutorPorNome(nomeAutor);

            if (adicionarAutorExistente.isEmpty()) {
                System.out.println("Não existem autores com esse nome!");
                System.out.println(" ");
                break;
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
                for (Autor autor : adicionarAutorExistente) {
                    if (autor.getId() == idAdicionarAutor) {
                        autorAdicionado = autor;
                        break;
                    }
                }
                System.out.println("Autor(a) adicionado(a) com sucesso!");
                System.out.println(" ");
            }

            // adicionar categorias puxando da lista de categorias

            System.out.println("Categorias   | ID");
            for (Categoria cat : gestorCategoria.listarCategorias()) {
                System.out.printf("%-12s | %d%n", cat.getNome(), cat.getId());
            }

            int id;
            Categoria categoriaEncontrada = null;

            while (categoriaEncontrada == null) {
                id = leIntPositivo("Insira a categoria pelo ID ou 0 para sair:");
                if (id==0) {
                    sair = true;
                    break;
                }
                categoriaEncontrada = gestorCategoria.pesquisarCategoriaPorId(id);

                if (categoriaEncontrada == null) {
                    System.out.println("Categoria não encontrada!");
                    System.out.println(" ");
                }
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
            while (ISBN.trim().isEmpty() || ISBN.length() != 13 || !ISBN.matches("\\d+")) { //A expressão regular "\d+" verifica se a string contém um ou mais dígitos.
                ISBN = leStr("Introduza o ISBN: ");
                if (ISBN.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (ISBN.trim().isEmpty() || ISBN.length() != 13 || !ISBN.matches("\\d+")) { //A expressão regular "\d+" verifica se a string contém um ou mais dígitos.
                    System.out.println("Por favor, introduza um ISBN válido com 13 dígitos numéricos!");
                }
            }
            if (sair) {
                break;
            }

            boolean adicionado = gestor.adicionarLivros(titulo, subtitulo, quantidade, numDePaginas, autorAdicionado, categoriaEncontrada, dataDePublicacao, faixaEtaria, editora, ISBN);
            if (adicionado){
                System.out.println("Livro " + titulo + " adicionado com sucesso!");
                System.out.println(" ");
            }else{
                System.out.println("Ocorreu um erro ao adicionar o livro!\n");
            }

        } while (sair);
    }

}