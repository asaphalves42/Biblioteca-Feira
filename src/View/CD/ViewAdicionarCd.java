package View.CD;

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

public class ViewAdicionarCd {
    public void MenuAdicionarCd(ControllerProdutos gestorCds, ControllerCategoria gestorCategoria, ControllerAutores gestorAutores) {

        boolean sair = false;
        do {

            System.out.println("Caso pretenda sair, digite 'sair'");
            String titulo = "";
            while (titulo.trim().isEmpty()) {
                titulo = leStr("Introduza o título: ");
                if (titulo.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (titulo.trim().isEmpty()) {
                    System.out.println("Por favor, introduza um título válido!");
                }
            }
            if (sair) {
                break;
            }

            int quantidade = leIntPositivo("Introduza a quantidade: ");
            System.out.println();

            int NumCapitulos = leIntPositivo("Introduza o número de capítulos: ");
            System.out.println();

            // Adicionar autor existente no programa
            ArrayList<Autor> autoresListados = gestorAutores.listarAutores();
            System.out.println("Autores disponíveis: ");
            for (Autor autor : autoresListados) {
                System.out.println(autor.toString());
            }

            int idAdicionarAutor = 0;
            while (true) {
                String inputId = leStr("Insira o ID do autor que deseja adicionar (ou 'sair' para cancelar): ");

                if (inputId.equalsIgnoreCase("sair")) {
                    sair = true;
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
                for (Autor autor : autoresListados) {
                    if (autor.getId() == idAdicionarAutor) {
                        autorAdicionado = autor;
                        break;
                    }
                }
            }

            if (autorAdicionado == null) {
                System.out.println("Autor não encontrado ou seleção cancelada!\n");
                continue;
            }

            // Adicionar categorias puxando da lista de categorias
            System.out.println("Categorias disponíveis: ");
            for (Categoria cat : gestorCategoria.listarCategorias()) {
                System.out.printf("%-12s | %d%n", cat.getNome(), cat.getId());
            }

            int id;
            Categoria categoriaEncontrada = null;

            while (categoriaEncontrada == null) {
                id = leIntPositivo("Insira o ID da categoria:");
                categoriaEncontrada = gestorCategoria.pesquisarCategoriaPorId(id);

                if (categoriaEncontrada == null) {
                    System.out.println("Categoria não encontrada!");
                    System.out.println();
                }
            }

            System.out.println("Digite a data de lançamento do CD: ");
            ValidacaoData validarData = new ValidacaoData();
            LocalDate dataDePublicacao = validarData.LerData2();

            String faixaEtaria = "";
            while (faixaEtaria.trim().isEmpty()) {
                faixaEtaria = leStr("Introduza a faixa etária: ");
                if (faixaEtaria.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (faixaEtaria.trim().isEmpty()) {
                    System.out.println("Por favor, introduza uma faixa etária válida");
                }
            }
            if (sair) {
                break;
            }

            String editora = "";
            while (editora.trim().isEmpty()) {
                editora = leStr("Introduza a produtora: ");
                if (editora.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (editora.trim().isEmpty()) {
                    System.out.println("Por favor, introduza uma produtora válida!");
                }
            }
            if (sair) {
                break;
            }

            boolean adicionado = gestorCds.adicionarCDS(titulo, quantidade, NumCapitulos, autorAdicionado, categoriaEncontrada, dataDePublicacao, faixaEtaria, editora);

            if (adicionado) {
                System.out.println("CD " + titulo + " adicionado com sucesso!");
                System.out.println();
            } else {
                System.out.println("Ocorreu um erro ao adicionar o CD!\n");
            }

        } while (!sair);
    }

}



