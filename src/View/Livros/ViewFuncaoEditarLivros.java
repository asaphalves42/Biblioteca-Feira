package View.Livros;

import Controller.ControllerLivros;
import Model.Livro;
import Utilidades.ValidacaoData;
import View.Categorias.Categorias;

import java.time.LocalDate;
import java.util.ArrayList;

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
                System.out.println(livro.toString());
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
        ValidacaoData validarData = new ValidacaoData();
        LocalDate dataDePublicacao = validarData.LerData2();

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
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = LeStr("Insira o título do livro que quer editar:");
            livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

            if (livrosParaEditar.isEmpty()) {
                System.out.println("Não existem livros com este título!");
                System.out.println(" ");
            } else {
                for (Livro livro : livrosParaEditar) {
                    System.out.println(livro);
                }
                break;
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
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = LeStr("Insira o título do livro que quer editar:");
            livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

            if (livrosParaEditar.isEmpty()) {
                System.out.println("Não existem livros com este título!");
                System.out.println(" ");
            } else {
                for (Livro livro : livrosParaEditar) {
                    System.out.println(livro);
                }
                break;
            }
        }

        int idEditarSubTitulo = LeInt("Insira o id do livro que quer editar: ");
        String subTituloNovo = LeStr("Insira o novo subtítulo:");

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
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = LeStr("Insira o título do livro que quer editar:");
            livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

            if (livrosParaEditar.isEmpty()) {
                System.out.println("Não existem livros com este título!");
                System.out.println(" ");
            } else {
                for (Livro livro : livrosParaEditar) {
                    System.out.println(livro);
                }
                break;
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
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = LeStr("Insira o título do livro que quer editar:");
            livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

            if (livrosParaEditar.isEmpty()) {
                System.out.println("Não existem livros com este título!");
                System.out.println(" ");
            } else {
                for (Livro livro : livrosParaEditar) {
                    System.out.println(livro);
                }
                break;
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
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = LeStr("Insira o título do livro que quer editar:");
            livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

            if (livrosParaEditar.isEmpty()) {
                System.out.println("Não existem livros com este título!");
                System.out.println(" ");
            } else {
                for (Livro livro : livrosParaEditar) {
                    System.out.println(livro);
                }
                break;
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

    public void editarPorCategoria(ControllerLivros gestor) {
        ArrayList<Livro> livros;
        do {
            String tituloInserido = LeStr("Insira o título do livro: ");
            livros = gestor.pesquisarLivroPorTitulo(tituloInserido);

            if (livros.isEmpty()) {
                System.out.println("Não existem livros com esse título!");
                System.out.println(" ");
            } else {
                for (Livro livro : livros) {
                    System.out.println(livro.toString());
                }
            }
        } while (livros.isEmpty());

        int idLivro = LeInt("Insira o id do livro que deseja editar a categoria:");
        Livro livroParaEditar = gestor.pesquisarLivroPorId(idLivro);

        if (livroParaEditar == null) {
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        } else {
            System.out.println("Escolha a nova categoria:");
            Categorias escolherCat = new Categorias();
            int opcaoCategoria = escolherCat.escolherCategorias();

            String novaCategoria;
            switch (opcaoCategoria) {
                case 1:
                    novaCategoria = "Artes";
                    break;
                case 2:
                    novaCategoria = "Ciencia";
                    break;
                case 3:
                    novaCategoria = "Matematica";
                    break;
                case 4:
                    novaCategoria = "Psicologia";
                    break;
                case 5:
                    novaCategoria = "Tecnologia";
                    break;
                default:
                    novaCategoria = "";
                    break;
            }

            if (gestor.editarCategoria(idLivro, novaCategoria)) {
                System.out.println("Categoria editada com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Livro não encontrado!");
            }
        }
    }

    public void editarPorData(ControllerLivros gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = LeStr("Insira o título do livro que quer editar:");
            livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

            if (livrosParaEditar.isEmpty()) {
                System.out.println("Não existem livros com este título!");
                System.out.println(" ");
            } else {
                for (Livro livro : livrosParaEditar) {
                    System.out.println(livro);
                }
                break;
            }
        }

        int idEditarData = LeInt("Insira o id do livro que quer editar: ");
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

    public void editarFaixaEtaria(ControllerLivros gestor){
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = LeStr("Insira o título do livro que quer editar:");
            livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

            if (livrosParaEditar.isEmpty()) {
                System.out.println("Não existem livros com este título!");
                System.out.println(" ");
            } else {
                for (Livro livro : livrosParaEditar) {
                    System.out.println(livro);
                }
                break;
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
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = LeStr("Insira o título do livro que quer editar:");
            livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

            if (livrosParaEditar.isEmpty()) {
                System.out.println("Não existem livros com este título!");
                System.out.println(" ");
            } else {
                for (Livro livro : livrosParaEditar) {
                    System.out.println(livro);
                }
                break;
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
        ArrayList<Livro> livrosParaEditar;

        while (true) {
            String tituloLivro = LeStr("Insira o título do livro que quer editar:");
            livrosParaEditar = gestor.pesquisarLivroPorTitulo(tituloLivro);

            if (livrosParaEditar.isEmpty()) {
                System.out.println("Não existem livros com este título!");
                System.out.println(" ");
            } else {
                for (Livro livro : livrosParaEditar) {
                    System.out.println(livro);
                }
                break;
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


