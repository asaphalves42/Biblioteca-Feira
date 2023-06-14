package View.Livros;

import Controller.ControllerProdutos;
import Controller.ControllerCategoria;
import Model.Categoria;
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
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
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

            boolean tituloEditado = gestor.editarTituloDoProduto(idEditarTitulo, tituloNovo);

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
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
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
            String idLivroStr = leStr("Insira o id do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
            if (idLivroStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarSubTitulo = Integer.parseInt(idLivroStr);
            String subTituloNovo = leStr("Insira o novo subtítulo (ou 'sair' para voltar ao menu anterior):");
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
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
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
            String idEditarQuantidadeStr = leStr("Insira o id do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
            if (idEditarQuantidadeStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarQuantidade = Integer.parseInt(idEditarQuantidadeStr);

            String novaQuantidadeStr = leStr("Insira a nova quantidade (ou 'sair' para voltar ao menu anterior):");
            if (novaQuantidadeStr.equalsIgnoreCase("sair")) {
                return;
            }
            int novaQuantidade = Integer.parseInt(novaQuantidadeStr);

            boolean quantidadeEditada = gestor.editarQuantidadeProduto(idEditarQuantidade, novaQuantidade);

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
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
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
            String idEditarAutorStr = leStr("Insira o id do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
            if (idEditarAutorStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarAutor = Integer.parseInt(idEditarAutorStr);

            String novoNomeAutor = leStr("Insira o novo nome do autor (ou 'sair' para voltar ao menu anterior):");
            if (novoNomeAutor.equalsIgnoreCase("sair")) {
                return;
            }

            boolean autorEditado = gestor.editarAutorProduto(idEditarAutor, novoNomeAutor);

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
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
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
            String idEditarNumPaginasStr = leStr("Insira o id do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
            if (idEditarNumPaginasStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarNumPaginas = Integer.parseInt(idEditarNumPaginasStr);

            int novaQuantidade = leIntPositivo("Insira o novo número de páginas (ou 'sair' para voltar ao menu anterior):");
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

    public void editarPorCategoria(ControllerProdutos gestor,ControllerCategoria gestorCategoria) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            try {
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
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
            String idEditarCategoriaStr = leStr("Insira o id do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
            if (idEditarCategoriaStr.equalsIgnoreCase("sair")) {
                return;
            }

            System.out.println("Categorias   | ID");
            for (Categoria cat : gestorCategoria.listarCategorias()) {
                System.out.printf("%-12s | %d%n", cat.getNome(), cat.getId());
            }

            int id = -1;
            Categoria categoriaEncontrada = null;

            while (categoriaEncontrada == null) {
                id = leIntPositivo("Escolha o ID da categoria pela qual quer trocar (ou 0 para sair):");
                if (id==0) {
                    break;
                }
                categoriaEncontrada = gestorCategoria.pesquisarCategoriaPorId(id);

                if (categoriaEncontrada == null) {
                    System.out.println("Categoria não encontrada!");
                    System.out.println(" ");
                }
            }

            int idEditarCategoria = Integer.parseInt(idEditarCategoriaStr);

            //String novaCategoria = leStr("Insira o novo nome da Categoria (ou 'sair' para encerrar):");
            //if (novaCategoria.equalsIgnoreCase("sair")) {
            //    return;
            //}

            boolean categoriaEditada = gestor.editarCategoriaProdutoID(idEditarCategoria, id);

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
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
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
            String idEditarDataStr = leStr("Insira o id do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
            if (idEditarDataStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarData = Integer.parseInt(idEditarDataStr);

            System.out.println("Digite a nova data de publicação do livro (ou 'sair' para voltar ao menu anterior): ");
            ValidacaoData validarData = new ValidacaoData();
            LocalDate novaDataDePublicacao = validarData.LerData2();
            if (novaDataDePublicacao == null) {
                return;
            }

            boolean dataEditada = gestor.editarDataDePublicacaoProduto(idEditarData, novaDataDePublicacao);

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
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
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
            String idEditarFaixaStr = leStr("Insira o id do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
            if (idEditarFaixaStr.equalsIgnoreCase("sair")) {
                return;
            }
            int idEditarFaixa = Integer.parseInt(idEditarFaixaStr);

            String novaFaixaEtaria = leStr("Insira a nova faixa etária (ou 'sair' para voltar ao menu anterior):");
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
                String tituloLivro = leStr("Insira o título do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
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
            String idEditarEditoraStr = leStr("Insira o id do livro que quer editar (ou 'sair' para voltar ao menu anterior):");
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

