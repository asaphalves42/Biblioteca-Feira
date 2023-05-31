package View.CD;

import Controller.ControllerProdutos;
import Model.CD;
import Model.Produto;
import Utilidades.ValidacaoData;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.*;

public class ViewEditarCd {
    public void editarCDSPorTitulo(ControllerProdutos gestor) {


        ArrayList<CD> cdsParaEditar = new ArrayList<>();
        while (true) {
            try {
                String tituloCD = leStr("Insira o título do CD que quer editar (ou 'sair' para voltar ao menu anterior):");

                if (tituloCD.equalsIgnoreCase("sair")) {
                    break;  // Sair do loop e retornar ao menu anterior
                }

                cdsParaEditar = gestor.pesquisarCDPorTitulo(tituloCD);

                if (cdsParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto CD : cdsParaEditar) {
                        System.out.println(CD);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Por favor, tente novamente.");
            }
        }

        if (cdsParaEditar != null) {
            int idEditarTitulo = leInt("Insira o id do CD que quer editar: ");
            String tituloNovo = leStr("Insira o novo título:");

            boolean tituloEditado = gestor.editarTituloDoProduto(idEditarTitulo, tituloNovo);

            if (tituloEditado) {
                System.out.println("CD editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("CD não encontrado!");
                System.out.println(" ");
            }
        }
    }

    public void editarQuantidadeCD(ControllerProdutos gestor) {
        ArrayList<CD> cdsParaEditar = new ArrayList<>();

        while (true) {
            try {
                String tituloCD = leStr("Insira o título do CD que quer editar (ou 'sair' para voltar ao menu anterior):");

                if (tituloCD.equalsIgnoreCase("sair")) {
                    break;  // Sair do loop e retornar ao menu anterior
                }

                cdsParaEditar = gestor.pesquisarCDPorTitulo(tituloCD);

                if (cdsParaEditar.isEmpty()) {
                    System.out.println("Não existem CDs com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto CD : cdsParaEditar) {
                        System.out.println(CD);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Por favor, tente novamente.");
            }
        }

        if (cdsParaEditar != null) {
            int idEditarQuantidade = leInt("Insira o id do livro que quer editar: ");
            int novaQuantidade = leIntPositivo("Insira a nova quantidade:");

            boolean quantidadeEditada = gestor.editarQuantidadeProduto(idEditarQuantidade, novaQuantidade);

            if (quantidadeEditada) {
                System.out.println("CD editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("CD não encontrado!");
                System.out.println(" ");
            }
        }
    }

    public void editarCDSPorAutor(ControllerProdutos gestor) {
        ArrayList<CD> cdsParaEditar = new ArrayList<>();

        while (true) {
            try {
                String tituloCD = leStr("Insira o CD do livro que quer editar (ou 'sair' para voltar ao menu anterior):");

                if (tituloCD.equalsIgnoreCase("sair")) {
                    break;  // Sair do loop e retornar ao menu anterior
                }

                cdsParaEditar = gestor.pesquisarCDPorTitulo(tituloCD);

                if (cdsParaEditar.isEmpty()) {
                    System.out.println("Não existem CDs com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto CD : cdsParaEditar) {
                        System.out.println(CD);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Por favor, tente novamente.");
            }
        }

        if (!cdsParaEditar.isEmpty()) {
            int idEditarAutor = leInt("Insira o id do livro que quer editar: ");

            String novoNomeAutor = leStr("Insira o novo nome do autor: ");

            boolean autorEditado = gestor.editarAutorProduto(idEditarAutor, novoNomeAutor);

            if (autorEditado) {
                System.out.println("CD editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("CD não encontrado!");
                System.out.println(" ");
            }
        }
    }

    public void editarNumFaixas(ControllerProdutos gestor) {
        ArrayList<CD> cdsParaEditar = new ArrayList<>();

        while (true) {
            try {
                String tituloCD = leStr("Insira o título do CD que quer editar (ou 'sair' para voltar ao menu anterior):");

                if (tituloCD.equalsIgnoreCase("sair")) {
                    break;  // Sair do loop e retornar ao menu anterior
                }

                cdsParaEditar = gestor.pesquisarCDPorTitulo(tituloCD);

                if (cdsParaEditar.isEmpty()) {
                    System.out.println("Não existem CDs com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto CD : cdsParaEditar) {
                        System.out.println(CD);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Por favor, tente novamente.");
            }
        }

        if (!cdsParaEditar.isEmpty()) {
            int idEditarNumFaixas = leInt("Insira o id do CD que quer editar: ");
            int novaQuantidade = leIntPositivo("Insira o novo número de faixas:");

            boolean quantidadeEditada = gestor.editarNumFaixas(idEditarNumFaixas, novaQuantidade);

            if (quantidadeEditada) {
                System.out.println("CD editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("CD não encontrado!");
                System.out.println(" ");
            }
        }
    }

// As demais funções seguem a mesma estrutura de adição do bloco try-catch e da opção "sair"

    public void editarPorCategoriaCD(ControllerProdutos gestor) {
        ArrayList<CD> cdsParaEditar = new ArrayList<>();

        while (true) {
            try {
                String tituloCD = leStr("Insira o título do CD que quer editar (ou 'sair' para voltar ao menu anterior):");

                if (tituloCD.equalsIgnoreCase("sair")) {
                    break;  // Sair do loop e retornar ao menu anterior
                }

                cdsParaEditar = gestor.pesquisarCDPorTitulo(tituloCD);

                if (cdsParaEditar.isEmpty()) {
                    System.out.println("Não existem CDs com esse título! ");
                    System.out.println(" ");
                } else {
                    for (Produto CD : cdsParaEditar) {
                        System.out.println(CD);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Por favor, tente novamente.");
            }
        }

        if (!cdsParaEditar.isEmpty()) {
            int idEditarCategoria = leInt("Insira o id do CD que quer editar: ");

            String novaCategoria = leStr("Insira o novo nome da Categoria: ");

            boolean categoriaEditada = gestor.editarCategoriaProduto(idEditarCategoria, novaCategoria);

            if (categoriaEditada) {
                System.out.println("CD editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Categoria não existe!");
                System.out.println(" ");
            }
        }
    }

    public void editarPorDataCD(ControllerProdutos gestor) {
        ArrayList<CD> cdsParaEditar = new ArrayList<>();

        while (true) {
            try {
                String tituloCD = leStr("Insira o título do CD que quer editar (ou 'sair' para voltar ao menu anterior):");

                if (tituloCD.equalsIgnoreCase("sair")) {
                    break;  // Sair do loop e retornar ao menu anterior
                }

                cdsParaEditar = gestor.pesquisarCDPorTitulo(tituloCD);

                if (cdsParaEditar.isEmpty()) {
                    System.out.println("Não existem CDs com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto CD : cdsParaEditar) {
                        System.out.println(CD);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Por favor, tente novamente.");
            }
        }

        if (!cdsParaEditar.isEmpty()) {
            int idEditarData = leInt("Insira o id do CD que quer editar: ");
            System.out.println("Digite a nova data de publicação do CD: ");
            ValidacaoData validarData = new ValidacaoData();
            LocalDate novaDataDePublicacao = validarData.LerData2();

            boolean dataEditada = gestor.editarDataDePublicacaoProduto(idEditarData, novaDataDePublicacao);

            if (dataEditada) {
                System.out.println("CD editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("CD não encontrado!");
                System.out.println(" ");
            }
        }
    }

    public void editarFaixaEtaria(ControllerProdutos gestor) {
        ArrayList<CD> cdsParaEditar = new ArrayList<>();

        while (true) {
            try {
                String tituloCD = leStr("Insira o título do cd que quer editar (ou 'sair' para voltar ao menu anterior):");

                if (tituloCD.equalsIgnoreCase("sair")) {
                    break;  // Sair do loop e retornar ao menu anterior
                }

                cdsParaEditar = gestor.pesquisarCDPorTitulo(tituloCD);

                if (cdsParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto CD : cdsParaEditar) {
                        System.out.println(CD);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Por favor, tente novamente.");
            }
        }

        if (!cdsParaEditar.isEmpty()) {
            int idEditarFaixa = leInt("Insira o id do CD que quer editar: ");
            String novaFaixaEtaria = leStr("Insira a nova faixa etária:");

            boolean faixaEditada = gestor.editarFaixaEtaria(idEditarFaixa, novaFaixaEtaria);

            if (faixaEditada) {
                System.out.println("CD editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("CD não encontrado!");
                System.out.println(" ");
            }
        }
    }

    public void editarEditoraCD(ControllerProdutos gestor) {
        ArrayList<CD> cdsParaEditar = new ArrayList<>();

        while (true) {
            try {
                String tituloCD = leStr("Insira o título do CD que quer editar (ou 'sair' para voltar ao menu anterior):");

                if (tituloCD.equalsIgnoreCase("sair")) {
                    break;  // Sair do loop e retornar ao menu anterior
                }

                cdsParaEditar = gestor.pesquisarCDPorTitulo(tituloCD);

                if (cdsParaEditar.isEmpty()) {
                    System.out.println("Não existem cd's com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto CD : cdsParaEditar) {
                        System.out.println(CD);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Por favor, tente novamente.");
            }
        }

        if (!cdsParaEditar.isEmpty()) {
            int idEditarEditora = leInt("Insira o id do cd que quer editar: ");
            String novaEditora = leStr("Insira a nova produtora:");

            boolean editoraEditada = gestor.editarEditoraProduto(idEditarEditora, novaEditora);

            if (editoraEditada) {
                System.out.println("CD editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("CD não encontrado!");
                System.out.println(" ");
            }
        }
    }



}
