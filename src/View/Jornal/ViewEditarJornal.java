package View.Jornal;

import Controller.ControllerProdutos;
import Model.Jornal;
import Model.Produto;
import Utilidades.ValidacaoData;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.leIntPositivo;
import static Utilidades.Leitura.leStr;

public class ViewEditarJornal {
    public void editarJornalPorTitulo(ControllerProdutos gestor) {

        while (true) {
            try {
                for (Jornal jornal : gestor.listarProdutosJornal()){
                    System.out.println(jornal);
                }

            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                System.out.println("Por favor, tente novamente.");
                System.out.println(" ");
            }

            try {
                String idRevistaStr = leStr("Insira o id do jornal que quer editar (ou 'sair' para encerrar):");
                if (idRevistaStr.equalsIgnoreCase("sair")) {
                    return;
                }
                int idEditarSubTitulo = Integer.parseInt(idRevistaStr);
                String subTituloNovo = leStr("Insira o novo título (ou 'sair' para encerrar):");
                if (subTituloNovo.equalsIgnoreCase("sair")) {
                    return;
                }

                boolean tituloEditado = gestor.editarTituloDoProduto(idEditarSubTitulo, subTituloNovo);

                if (tituloEditado) {
                    System.out.println("Jornal editada com sucesso!");
                    System.out.println(" ");
                } else {
                    System.out.println("Jornal não encontrado!");
                    System.out.println(" ");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao editar o jornal. Por favor, tente novamente.");
            }
        }

        }

    public void editarJornalPorSubTitulo(ControllerProdutos gestor) {
        while (true) {
            try {
                for (Jornal jornal : gestor.listarProdutosJornal()) {
                    System.out.println(jornal);
                }

            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os jornais. Por favor, tente novamente.");
            }


            try {
                String idJornalStr = leStr("Insira o id do jornal que quer editar (ou 'sair' para encerrar):");
                if (idJornalStr.equalsIgnoreCase("sair")) {
                    return;
                }
                int idEditarSubTitulo = Integer.parseInt(idJornalStr);
                String subTituloNovo = leStr("Insira o novo subtítulo (ou 'sair' para encerrar):");
                if (subTituloNovo.equalsIgnoreCase("sair")) {
                    return;
                }

                boolean tituloEditado = gestor.editarSubTituloDoJornal(idEditarSubTitulo, subTituloNovo);

                if (tituloEditado) {
                    System.out.println("Jornal editado com sucesso!");
                    System.out.println(" ");
                } else {
                    System.out.println("Jornal não encontrado!");
                    System.out.println(" ");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao editar o jornal. Por favor, tente novamente.");
            }
        }
    }
    public void editarNumPaginasJornal(ControllerProdutos gestor) {

        ArrayList<Jornal> jornaisParaEditar;

        while (true) {
            try {
                String tituloJornal = leStr("Insira o título do jornal que quer editar (ou 'sair' para encerrar):");
                if (tituloJornal.equalsIgnoreCase("sair")) {
                    return;
                }
                jornaisParaEditar = gestor.pesquisarJornalPorTitulo(tituloJornal);

                if (jornaisParaEditar.isEmpty()) {
                    System.out.println("Não existem jornais com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto jornal : jornaisParaEditar) {
                        System.out.println(jornal);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os jornais. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarNumPaginasStr = leStr("Insira o id do jornal que quer editar (ou 'sair' para encerrar):");
            if (idEditarNumPaginasStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarNumPaginas = Integer.parseInt(idEditarNumPaginasStr);

            int novaQuantidade = leIntPositivo("Insira o novo número de páginas (ou 'sair' para encerrar):");
            if (novaQuantidade == -1) {
                return;
            }

            boolean quantidadeEditada = gestor.editarNumPaginasJornal(idEditarNumPaginas, novaQuantidade);

            if (quantidadeEditada) {
                System.out.println("Jornal editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Jornal não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o jornal. Por favor, tente novamente.");
        }
    }
    public void editarPorDataJornal(ControllerProdutos gestor) {
        ArrayList<Jornal> jornaisParaEditar;

        while (true) {
            try {
                String tituloJornal = leStr("Insira o título do jornal que quer editar (ou 'sair' para encerrar):");
                if (tituloJornal.equalsIgnoreCase("sair")) {
                    return;
                }
                jornaisParaEditar = gestor.pesquisarJornalPorTitulo(tituloJornal);

                if (jornaisParaEditar.isEmpty()) {
                    System.out.println("Não existem jornais com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto jornal : jornaisParaEditar) {
                        System.out.println(jornal);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os jornais. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarDataStr = leStr("Insira o id do jornal que quer editar (ou 'sair' para encerrar):");
            if (idEditarDataStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarData = Integer.parseInt(idEditarDataStr);

            System.out.println("Digite a nova data de publicação do jornal (ou 'sair' para encerrar): ");
            ValidacaoData validarData = new ValidacaoData();
            LocalDate novaDataDePublicacao = validarData.LerData2();
            if (novaDataDePublicacao == null) {
                return;
            }

            boolean dataEditada = gestor.editarDataDePublicacaoProduto(idEditarData, novaDataDePublicacao);

            if (dataEditada) {
                System.out.println("Jornal editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Jornal não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o jornal. Por favor, tente novamente.");
        }
    }
    public void editarEditoraJornal(ControllerProdutos gestor) {
        ArrayList<Jornal> jornaisParaEditar;

        while (true) {
            try {
                String tituloJornal = leStr("Insira o título do jornal que quer editar (ou 'sair' para encerrar):");
                if (tituloJornal.equalsIgnoreCase("sair")) {
                    return;
                }
                jornaisParaEditar = gestor.pesquisarJornalPorTitulo(tituloJornal);

                if (jornaisParaEditar.isEmpty()) {
                    System.out.println("Não existem jornais com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto jornal : jornaisParaEditar) {
                        System.out.println(jornal);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os jornais. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarEditoraStr = leStr("Insira o id do jornal que quer editar (ou 'sair' para encerrar):");
            if (idEditarEditoraStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarEditora = Integer.parseInt(idEditarEditoraStr);

            String novaEditora = leStr("Insira a nova editora (ou 'sair' para encerrar):");
            if (novaEditora.equalsIgnoreCase("sair")) {
                return;
            }

            boolean editoraEditada = gestor.editarEditoraProduto(idEditarEditora, novaEditora);

            if (editoraEditada) {
                System.out.println("Jornal editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Jornal não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o jornal. Por favor, tente novamente.");
        }
    }
}
