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

            int quantidade = leIntPositivo("Introduza a quantidade: ");
            System.out.println(" ");

            int NumCapitulos = leIntPositivo("Introduza o número de capítulos: ");
            System.out.println(" ");

            //adicionar autor com autor existente no programa


            ArrayList<Autor> adicionarAutorExistente = null;
            String nomeAutor;
            while (true) {
                ArrayList<Autor> autoresListados = gestorAutores.listarAutores();
                String Continuar = leStr("Caso deseja ver todos os autores exitentes  insira um ENTER");
                if (Continuar.equalsIgnoreCase("")) {
                    for (Autor autor : autoresListados) {
                        System.out.println(autor.toString());

                    }
                } else {
                    System.out.println("Ocurreu um erro a listar todos os autores! ");
                }
                nomeAutor = leStr("Insira o nome do(a) autor(a):");
                if (nomeAutor.equalsIgnoreCase("sair")) {
                    return;
                }
                gestorCds.listarAutorPorNomeEncontrado(nomeAutor);

                if (autoresListados.isEmpty()) {
                    System.out.println("Não existem autores registados\n");
                }
                    adicionarAutorExistente = gestorAutores.pesquisarAutorPorNome(nomeAutor);

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
                    id = leIntPositivo("Insira a categoria pelo ID:");
                    categoriaEncontrada = gestorCategoria.pesquisarCategoriaPorId(id);

                    if (categoriaEncontrada == null) {
                        System.out.println("Categoria não encontrada!");
                        System.out.println(" ");
                    }
                }


                System.out.println("Digite a data de lançamento do cd: ");
                ValidacaoData validarData = new ValidacaoData();
                LocalDate dataDePublicacao = validarData.LerData2();

                String FaixaEtaria = "";
                while (FaixaEtaria.trim().isEmpty()) {
                    FaixaEtaria = leStr("Introduza a faixa etaria: ");
                    if (FaixaEtaria.equalsIgnoreCase("sair")) {
                        sair = true;
                        break;
                    }
                    if (FaixaEtaria.trim().isEmpty()) {
                        System.out.println("Por favor, introduza uma faixa etaria válida");
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
                boolean adicionado = gestorCds.adicionarCDS(titulo, quantidade, NumCapitulos, autorAdicionado, categoriaEncontrada, dataDePublicacao, FaixaEtaria, editora);

                if (adicionado) {
                    System.out.println("CD " + titulo + " adicionado com sucesso!");
                    System.out.println(" ");
                } else {
                    System.out.println("Ocorreu um erro ao adicionar o CD!\n");
                }
            }while (sair);

        }
    }





