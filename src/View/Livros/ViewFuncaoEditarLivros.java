package View.Livros;

import Controller.ControllerProdutos;
import Model.Livro;
import Model.Produto;
import Utilidades.ValidacaoData;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.*;

public class ViewFuncaoEditarLivros {

    public void editarLivrosPorTitulo(ControllerProdutos gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = leStr("Insira o título do livro que quer editar:");
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
        }

        int idEditarTitulo = leInt("Insira o id do livro que quer editar: ");
        String tituloNovo = leStr("Insira o novo título:");

        boolean tituloEditado = gestor.editarTituloDoLivro(idEditarTitulo, tituloNovo);

        if(tituloEditado){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarLivrosPorSubTitulo(ControllerProdutos gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = leStr("Insira o título do livro que quer editar:");
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
        }

        int idEditarSubTitulo = leInt("Insira o id do livro que quer editar: ");
        String subTituloNovo = leStr("Insira o novo subtítulo:");

        boolean tituloEditado = gestor.editarSubTituloDoLivro(idEditarSubTitulo, subTituloNovo);

        if(tituloEditado){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarQuantidade(ControllerProdutos gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = leStr("Insira o título do livro que quer editar:");
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
        }

        int idEditarQuantidade = leInt("Insira o id do livro que quer editar: ");
        int novaQuantidade = leIntPositivo("Insira a nova quantidade:");

        boolean quantidadeEditada = gestor.editarQuantidade(idEditarQuantidade, novaQuantidade);

        if(quantidadeEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }
    public void editarLivrosPorAutor(ControllerProdutos gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = leStr("Insira o título do livro que quer editar:");
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
        }

        int idEditarAutor = leInt("Insira o id do livro que quer editar: ");

        String novoNomeAutor = leStr("Insira o novo nome do autor: ");

        boolean autorEditado = gestor.editarAutor(idEditarAutor, novoNomeAutor);

        if(autorEditado){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarNumPaginas(ControllerProdutos gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = leStr("Insira o título do livro que quer editar:");
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
        }

        int idEditarNumPaginas = leInt("Insira o id do livro que quer editar: ");
        int novaQuantidade = leIntPositivo("Insira o novo numero de paginas:");

        boolean quantidadeEditada = gestor.editarNumPaginas(idEditarNumPaginas, novaQuantidade);

        if(quantidadeEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarPorCategoria(ControllerProdutos gestor) {
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = leStr("Insira o título do livro que quer editar:");
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
        }

        int idEditarCategoria = leInt("Insira o id do livro que quer editar: ");

        String novaCategoria = leStr("Insira o novo nome da Categoria: ");

        boolean categoriaEditada = gestor.editarCategoria(idEditarCategoria, novaCategoria);

        if(categoriaEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Categoria não existe!");
            System.out.println(" ");
        }
    }



    public void editarPorData(ControllerProdutos gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = leStr("Insira o título do livro que quer editar:");
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
        }

        int idEditarData = leInt("Insira o id do livro que quer editar: ");
        System.out.println("Digite a nova data de publicação do livro: ");
        ValidacaoData validarData = new ValidacaoData();
        LocalDate novaDataDePublicacao = validarData.LerData2();

        boolean dataEditada = gestor.editarDataDePubli(idEditarData, novaDataDePublicacao);

        if(dataEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarFaixaEtaria(ControllerProdutos gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = leStr("Insira o título do livro que quer editar:");
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
        }

        int idEditarFaixa = leInt("Insira o id do livro que quer editar: ");
        String novaFaixaEtaria = leStr("Insira a nova faixa etaria:");

        boolean faixaEditada = gestor.editarFaixaEtaria(idEditarFaixa, novaFaixaEtaria);

        if(faixaEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarEditora(ControllerProdutos gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = leStr("Insira o título do livro que quer editar:");
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
        }

        int idEditarEditora = leInt("Insira o id do livro que quer editar: ");
        String novaEditora = leStr("Insira a nova editora:");

        boolean editoraEditada = gestor.editarEditora(idEditarEditora, novaEditora);

        if(editoraEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarISBN(ControllerProdutos gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = leStr("Insira o título do livro que quer editar:");
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
        }

        int idEditarISBN = leInt("Insira o id do livro que quer editar: ");
        String novoISBN = leStr("Insira o novo ISBN");

        boolean editadoISBN = gestor.editarISBN(idEditarISBN, novoISBN);

        if(editadoISBN){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

}


