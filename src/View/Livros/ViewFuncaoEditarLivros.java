package View.Livros;

import Controller.ControllerProdutos;
import Model.Livro;
import Model.Produto;
import Utilidades.ValidacaoData;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.*;

public class ViewFuncaoEditarLivros {

    public void editarLivrosPorTitulo(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para encerrar):");
                if (tituloLivro.equalsIgnoreCase("sair")) {
                    return;
                }

                livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto livro : livrosParaEditar) {
                        System.out.println(livro);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                System.out.println("Por favor, tente novamente.");
                System.out.println(" ");
            }
        }

        try {
            int idEditarTitulo = leInt("Insira o id do livro que quer editar: ");
            String tituloNovo = leStr("Insira o novo título:");

            boolean tituloEditado = gestor.editarTituloDoLivro(idEditarTitulo, tituloNovo);

            if (tituloEditado) {
                System.out.println("Livro editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Livro não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            System.out.println("Por favor, tente novamente.");
            System.out.println(" ");
        }
    }

    public void editarLivrosPorSubTitulo(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para encerrar):");
                if (tituloLivro.equalsIgnoreCase("sair")) {
                    return;
                }
                livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto livro : livrosParaEditar) {
                        System.out.println(livro);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os livros. Por favor, tente novamente.");
            }
        }

        try {
            String idLivroStr = leStr("Insira o id do livro que quer editar (ou 'sair' para encerrar):");
            if (idLivroStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarSubTitulo = Integer.parseInt(idLivroStr);
            String subTituloNovo = leStr("Insira o novo subtítulo (ou 'sair' para encerrar):");
            if (subTituloNovo.equalsIgnoreCase("sair")) {
                return;
            }

            boolean tituloEditado = gestor.editarSubTituloDoLivro(idEditarSubTitulo, subTituloNovo);

            if (tituloEditado) {
                System.out.println("Livro editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Livro não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o livro. Por favor, tente novamente.");
        }
    }


    public void editarQuantidade(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para encerrar):");
                if (tituloLivro.equalsIgnoreCase("sair")) {
                    return;
                }
                livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto livro : livrosParaEditar) {
                        System.out.println(livro);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os livros. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarQuantidadeStr = leStr("Insira o id do livro que quer editar (ou 'sair' para encerrar):");
            if (idEditarQuantidadeStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarQuantidade = Integer.parseInt(idEditarQuantidadeStr);

            String novaQuantidadeStr = leStr("Insira a nova quantidade (ou 'sair' para encerrar):");
            if (novaQuantidadeStr.equalsIgnoreCase("sair")) {
                return;
            }
            int novaQuantidade = Integer.parseInt(novaQuantidadeStr);

            boolean quantidadeEditada = gestor.editarQuantidade(idEditarQuantidade, novaQuantidade);

            if (quantidadeEditada) {
                System.out.println("Livro editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Livro não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o livro. Por favor, tente novamente.");
        }
    }

    public void editarLivrosPorAutor(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para encerrar):");
                if (tituloLivro.equalsIgnoreCase("sair")) {
                    return;
                }
                livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto livro : livrosParaEditar) {
                        System.out.println(livro);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os livros. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarAutorStr = leStr("Insira o id do livro que quer editar (ou 'sair' para encerrar):");
            if (idEditarAutorStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarAutor = Integer.parseInt(idEditarAutorStr);

            String novoNomeAutor = leStr("Insira o novo nome do autor (ou 'sair' para encerrar):");
            if (novoNomeAutor.equalsIgnoreCase("sair")) {
                return;
            }

            boolean autorEditado = gestor.editarAutor(idEditarAutor, novoNomeAutor);

            if (autorEditado) {
                System.out.println("Livro editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Livro não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o livro. Por favor, tente novamente.");
        }
    }

    public void editarNumPaginas(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para encerrar):");
                if (tituloLivro.equalsIgnoreCase("sair")) {
                    return;
                }
                livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto livro : livrosParaEditar) {
                        System.out.println(livro);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os livros. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarNumPaginasStr = leStr("Insira o id do livro que quer editar (ou 'sair' para encerrar):");
            if (idEditarNumPaginasStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarNumPaginas = Integer.parseInt(idEditarNumPaginasStr);

            int novaQuantidade = leIntPositivo("Insira o novo número de páginas (ou 'sair' para encerrar):");
            if (novaQuantidade == -1) {
                return;
            }

            boolean quantidadeEditada = gestor.editarNumPaginas(idEditarNumPaginas, novaQuantidade);

            if (quantidadeEditada) {
                System.out.println("Livro editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Livro não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o livro. Por favor, tente novamente.");
        }
    }

    public void editarPorCategoria(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para encerrar):");
                if (tituloLivro.equalsIgnoreCase("sair")) {
                    return;
                }
                livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto livro : livrosParaEditar) {
                        System.out.println(livro);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os livros. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarCategoriaStr = leStr("Insira o id do livro que quer editar (ou 'sair' para encerrar):");
            if (idEditarCategoriaStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarCategoria = Integer.parseInt(idEditarCategoriaStr);

            String novaCategoria = leStr("Insira o novo nome da Categoria (ou 'sair' para encerrar):");
            if (novaCategoria.equalsIgnoreCase("sair")) {
                return;
            }

            boolean categoriaEditada = gestor.editarCategoria(idEditarCategoria, novaCategoria);

            if (categoriaEditada) {
                System.out.println("Livro editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Categoria não existe!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o livro. Por favor, tente novamente.");
        }
    }


    public void editarPorData(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para encerrar):");
                if (tituloLivro.equalsIgnoreCase("sair")) {
                    return;
                }
                livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto livro : livrosParaEditar) {
                        System.out.println(livro);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os livros. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarDataStr = leStr("Insira o id do livro que quer editar (ou 'sair' para encerrar):");
            if (idEditarDataStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarData = Integer.parseInt(idEditarDataStr);

            System.out.println("Digite a nova data de publicação do livro (ou 'sair' para encerrar): ");
            ValidacaoData validarData = new ValidacaoData();
            LocalDate novaDataDePublicacao = validarData.LerData2();
            if (novaDataDePublicacao == null) {
                return;
            }

            boolean dataEditada = gestor.editarDataDePubli(idEditarData, novaDataDePublicacao);

            if (dataEditada) {
                System.out.println("Livro editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Livro não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o livro. Por favor, tente novamente.");
        }
    }

    public void editarFaixaEtaria(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para encerrar):");
                if (tituloLivro.equalsIgnoreCase("sair")) {
                    return;
                }
                livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto livro : livrosParaEditar) {
                        System.out.println(livro);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os livros. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarFaixaStr = leStr("Insira o id do livro que quer editar (ou 'sair' para encerrar):");
            if (idEditarFaixaStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarFaixa = Integer.parseInt(idEditarFaixaStr);

            String novaFaixaEtaria = leStr("Insira a nova faixa etária (ou 'sair' para encerrar):");
            if (novaFaixaEtaria.equalsIgnoreCase("sair")) {
                return;
            }

            boolean faixaEditada = gestor.editarFaixaEtaria(idEditarFaixa, novaFaixaEtaria);

            if (faixaEditada) {
                System.out.println("Livro editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Livro não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o livro. Por favor, tente novamente.");
        }
    }

    public void editarEditora(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para encerrar):");
                if (tituloLivro.equalsIgnoreCase("sair")) {
                    return;
                }
                livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto livro : livrosParaEditar) {
                        System.out.println(livro);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os livros. Por favor, tente novamente.");
            }
        }

        try {
            String idEditarEditoraStr = leStr("Insira o id do livro que quer editar (ou 'sair' para encerrar):");
            if (idEditarEditoraStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarEditora = Integer.parseInt(idEditarEditoraStr);

            String novaEditora = leStr("Insira a nova editora (ou 'sair' para encerrar):");
            if (novaEditora.equalsIgnoreCase("sair")) {
                return;
            }

            boolean editoraEditada = gestor.editarEditora(idEditarEditora, novaEditora);

            if (editoraEditada) {
                System.out.println("Livro editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Livro não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o livro. Por favor, tente novamente.");
        }
    }

    public void editarISBN(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para encerrar):");
                if (tituloLivro.equalsIgnoreCase("sair")) {
                    return;
                }
                livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaEditar.isEmpty()) {
                    System.out.println("Não existem livros com este título!");
                    System.out.println(" ");
                } else {
                    for (Produto livro : livrosParaEditar) {
                        System.out.println(livro);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao pesquisar os livros. Por favor, tente novamente.");
            }
        }

        try {
            int idEditarEditora = leInt("Insira o id do livro que quer editar (ou 'sair' para encerrar):");
            if (idEditarEditora == -1) {
                return;
            }

            String novaEditora = leStr("Insira a nova editora (ou 'sair' para encerrar):");
            if (novaEditora.equalsIgnoreCase("sair")) {
                return;
            }

            boolean editoraEditada = gestor.editarEditora(idEditarEditora, novaEditora);

            if (editoraEditada) {
                System.out.println("Livro editado com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Livro não encontrado!");
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao editar o livro. Por favor, tente novamente.");
        }
    }
}

