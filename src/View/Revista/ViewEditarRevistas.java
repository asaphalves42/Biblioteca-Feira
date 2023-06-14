package View.Revista;

import Controller.ControllerProdutos;
import Model.Produto;
import Model.Revista;
import Utilidades.ValidacaoData;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.*;

public class ViewEditarRevistas {
    public void editarRevistaPorTitulo(ControllerProdutos gestor) {
        ArrayList<Revista> revistasParaEditar;

        while (true) {
            try {
                String tituloRevista = leStr("Insira o título da revista que quer editar (ou 'sair' para encerrar):");
                if (tituloRevista.equalsIgnoreCase("sair")) {
                    return;
                }

                revistasParaEditar = gestor.pesquisarRevistaPorTitulo(tituloRevista);

                if (revistasParaEditar.isEmpty()) {
                    System.out.println("Não existem revistas com este título!");
                    System.out.println(" ");
                } else {
                    for (Revista revista : revistasParaEditar) {
                        System.out.println(revista);
                    }

                    int idEditarTitulo = leInt("Insira o ID da revista que quer editar: ");
                    String tituloNovo = leStr("Insira o novo título:");

                    boolean tituloEditado = gestor.editarTituloDoProduto(idEditarTitulo, tituloNovo);

                    if (tituloEditado) {
                        System.out.println("Revista editada com sucesso!");
                        System.out.println(" ");
                    } else {
                        System.out.println("Revista não encontrada!");
                        System.out.println(" ");
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                System.out.println("Por favor, tente novamente.");
                System.out.println(" ");
            }
        }
    }


    public void editarRevistaPorSubTitulo(ControllerProdutos gestor) {
        ArrayList<Revista> revistasParaEditar;

        while (true) {
            try {
                String tituloRevista = leStr("Insira o título da revista que quer editar (ou 'sair' para encerrar):");
                if (tituloRevista.equalsIgnoreCase("sair")) {
                    return;
                }
                revistasParaEditar = gestor.pesquisarRevistaPorTitulo(tituloRevista);

                if (revistasParaEditar.isEmpty()) {
                    System.out.println("Não existem Revistas com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto revista : revistasParaEditar) {
                        System.out.println(revista);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os revistas. Por favor, tente novamente.");
            }
        }

        try {
            String idRevistaStr = leStr("Insira o id da revista que quer editar (ou 'sair' para encerrar):");
            if (idRevistaStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarSubTitulo = Integer.parseInt(idRevistaStr);
            String subTituloNovo = leStr("Insira o novo subtítulo (ou 'sair' para encerrar):");
            if (subTituloNovo.equalsIgnoreCase("sair")) {
                return;
            }

            boolean tituloEditado = gestor.editarSubTituloRevista(idEditarSubTitulo, subTituloNovo);

            if (tituloEditado) {
                System.out.println("Revista editada com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Revista não encontrada!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar a revista. Por favor, tente novamente.");
        }
    }
    public void editarNumPaginasRevista(ControllerProdutos gestor) {
        ArrayList<Revista> revistasParaEditar;

        while (true) {
            try {
                String tituloRevista = leStr("Insira o título da revista que quer editar (ou 'sair' para encerrar):");
                if (tituloRevista.equalsIgnoreCase("sair")) {
                    return;
                }
                revistasParaEditar = gestor.pesquisarRevistaPorTitulo(tituloRevista);

                if (revistasParaEditar.isEmpty()) {
                    System.out.println("Não existem revistas com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto revista : revistasParaEditar) {
                        System.out.println(revista);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar as revistas. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarNumPaginasStr = leStr("Insira o id da revista que quer editar (ou 'sair' para encerrar):");
            if (idEditarNumPaginasStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarNumPaginas = Integer.parseInt(idEditarNumPaginasStr);

            int novaQuantidade = leIntPositivo("Insira o novo número de páginas (ou 'sair' para encerrar):");
            if (novaQuantidade == -1) {
                return;
            }

            boolean quantidadeEditada = gestor.editarNumPaginasRevista(idEditarNumPaginas, novaQuantidade);

            if (quantidadeEditada) {
                System.out.println("Revista editada com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Revista não encontrada!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar a revista. Por favor, tente novamente.");
        }
    }
    public void editarPorDataRevista(ControllerProdutos gestor) {
        ArrayList<Revista> revistasParaEditar;

        while (true) {
            try {
                String tituloRevista = leStr("Insira o título da revista que quer editar (ou 'sair' para encerrar):");
                if (tituloRevista.equalsIgnoreCase("sair")) {
                    return;
                }
                revistasParaEditar = gestor.pesquisarRevistaPorTitulo(tituloRevista);

                if (revistasParaEditar.isEmpty()) {
                    System.out.println("Não existem revistas com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto revista : revistasParaEditar) {
                        System.out.println(revista);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar as revistas. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarDataStr = leStr("Insira o id da revista que quer editar (ou 'sair' para encerrar):");
            if (idEditarDataStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarData = Integer.parseInt(idEditarDataStr);

            System.out.println("Digite a nova data de publicação da revista (ou 'sair' para encerrar): ");
            ValidacaoData validarData = new ValidacaoData();
            LocalDate novaDataDePublicacao = validarData.LerData2();
            if (novaDataDePublicacao == null) {
                return;
            }

            boolean dataEditada = gestor.editarDataDePublicacaoProduto(idEditarData, novaDataDePublicacao);

            if (dataEditada) {
                System.out.println("Revista editada com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Revista não encontrada!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar a revista. Por favor, tente novamente.");
        }
    }
    public void editarEditoraRevista(ControllerProdutos gestor) {
        ArrayList<Revista> revistasParaEditar;

        while (true) {
            try {
                String tituloRevista = leStr("Insira o título da revista que quer editar (ou 'sair' para encerrar):");
                if (tituloRevista.equalsIgnoreCase("sair")) {
                    return;
                }
                revistasParaEditar = gestor.pesquisarRevistaPorTitulo(tituloRevista);

                if (revistasParaEditar.isEmpty()) {
                    System.out.println("Não existem revistas com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto revista : revistasParaEditar) {
                        System.out.println(revista);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar as revista. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarEditoraStr = leStr("Insira o id da revista que quer editar (ou 'sair' para encerrar):");
            if (idEditarEditoraStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarEditora = Integer.parseInt(idEditarEditoraStr);

            String novaEditora = leStr("Insira a nova editora (ou 'sair' para voltar ao menu anterior):");
            if (novaEditora.equalsIgnoreCase("sair")) {
                return;
            }

            boolean editoraEditada = gestor.editarEditoraProduto(idEditarEditora, novaEditora);

            if (editoraEditada) {
                System.out.println("Revista editada com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Revista não encontrada!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar a revista. Por favor, tente novamente.");
        }
    }
}



