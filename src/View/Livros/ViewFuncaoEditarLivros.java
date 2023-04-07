package View.Livros;

import Controller.ControllerLivros;
import Model.Livro;
import Utilidades.ValidacaoData;

import java.util.ArrayList;
import java.util.Date;

import static Utilidades.Leitura.*;

public class ViewFuncaoEditarLivros {

    public void editarLivros(ControllerLivros gestor) {

        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idLivroEditar = LeInt("Insira o id do livro que quer editar: ");

        String novoTitulo = LeStr("Insira o novo titulo do livro:");

        String subTitulo = LeStr("Insira o novo subtitulo:");

        int quantidade = LeInt("Insira a nova quantidade:");

        String autor = LeStr("Insira o novo autor do livro:");

        int numPaginas = LeInt("Insira o novo número de páginas:");

        String categoria = LeStr("Insira a nova categoria do livro:");

        System.out.println("Digite a nova data de publicação do livro: ");
        String date = ler.next();
        ler.nextLine();
        ValidacaoData validarData = new ValidacaoData();
        Date dataDePublicacao = validarData.LerData(date);

        String faixaEtaria = LeStr("Insira a nova faixa etária do livro:");

        String editora = LeStr("Insira a nova editora do livro:");

        String ISBN = LeStr("Insira o novo ISBN do livro:");

        boolean editado = gestor.editarLivro(idLivroEditar, novoTitulo, subTitulo, quantidade, autor, numPaginas, categoria, dataDePublicacao,faixaEtaria,editora,ISBN);

        if(editado){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }

    }

    public void editarLivrosPorTitulo(ControllerLivros gestor){
        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idEditarTitulo = LeInt("Insira o id do livro que quer editar: ");
        String tituloNovo = LeStr("Insira o novo título:");

        boolean tituloEditado = gestor.editarTituloDoLivro(idEditarTitulo, tituloNovo);

        if(tituloEditado){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarLivrosPorSubTitulo(ControllerLivros gestor){
        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idEditarSubTitulo = LeInt("Insira o id do livro que quer editar: ");
        String subTituloNovo = LeStr("Insira o novo título:");

        boolean tituloEditado = gestor.editarSubTituloDoLivro(idEditarSubTitulo, subTituloNovo);

        if(tituloEditado){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarQuantidade(ControllerLivros gestor){
        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idEditarQuantidade = LeInt("Insira o id do livro que quer editar: ");
        int novaQuantidade = LeInt("Insira a nova quantidade:");

        boolean quantidadeEditada = gestor.editarQuantidade(idEditarQuantidade, novaQuantidade);

        if(quantidadeEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }
    public void editarLivrosPorAutor(ControllerLivros gestor){
        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idEditarAutor = LeInt("Insira o id do livro que quer editar: ");
        String novoAutor = LeStr("Insira o novo autor:");

        boolean autorEditado = gestor.editarAutor(idEditarAutor, novoAutor);

        if(autorEditado){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarNumPaginas(ControllerLivros gestor){
        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idEditarNumPaginas = LeInt("Insira o id do livro que quer editar: ");
        int novaQuantidade = LeInt("Insira o novo numero de paginas:");

        boolean quantidadeEditada = gestor.editarNumPaginas(idEditarNumPaginas, novaQuantidade);

        if(quantidadeEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarPorCategoria(ControllerLivros gestor){
        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idEditarCategoria = LeInt("Insira o id do livro que quer editar: ");
        String novaCategoria = LeStr("Insira a nova categoria:");

        boolean categoriaEditada = gestor.editarCategoria(idEditarCategoria, novaCategoria);

        if(categoriaEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarPorData(ControllerLivros gestor){
        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idEditarData = LeInt("Insira o id do livro que quer editar: ");
        System.out.println("Digite a nova data de publicação do livro: ");
        String date = ler.next();
        ler.nextLine();
        ValidacaoData validarData = new ValidacaoData();
        Date novaDataDePublicacao = validarData.LerData(date);

        boolean dataEditada = gestor.editarDataDePubli(idEditarData, novaDataDePublicacao);

        if(dataEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarFaixaEtaria(ControllerLivros gestor){
        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idEditarFaixa = LeInt("Insira o id do livro que quer editar: ");
        String novaFaixaEtaria = LeStr("Insira a nova faixa etaria:");

        boolean faixaEditada = gestor.editarFaixaEtaria(idEditarFaixa, novaFaixaEtaria);

        if(faixaEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarEditora(ControllerLivros gestor){
        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idEditarEditora = LeInt("Insira o id do livro que quer editar: ");
        String novaEditora = LeStr("Insira a nova editora:");

        boolean editoraEditada = gestor.editarEditora(idEditarEditora, novaEditora);

        if(editoraEditada){
            System.out.println("Livro editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }
    }

    public void editarISBN(ControllerLivros gestor){
        String tituloLivro = LeStr("Insira o título do livro que quer editar:");
        ArrayList<Livro> livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if (livrosParaEditar.isEmpty()) {
            System.out.println("Não existem livros com este título!");
            System.out.println(" ");
        } else {
            for (Livro livro : livrosParaEditar) {
                System.out.println(livro);
            }
        }

        int idEditarISBN = LeInt("Insira o id do livro que quer editar: ");
        String novoISBN = LeStr("Insira o novo ISBN");

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


