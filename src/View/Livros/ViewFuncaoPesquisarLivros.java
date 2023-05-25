package View.Livros;

import Controller.ControllerProdutos;
import Model.Livro;
import Model.Produto;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoPesquisarLivros {

    public void livroPorTitulo(ControllerProdutos gestor) {
        try {
            String tituloInserido = leStr("Insira o título do livro (ou 'sair' para encerrar):");
            if (tituloInserido.equalsIgnoreCase("sair")) {
                return;
            }

            ArrayList<Livro> livros = gestor.pesquisarLivroPorTitulo(tituloInserido);

            if (livros.isEmpty()) {
                System.out.println("Livro não existente!");
            } else {
                System.out.println(gestor.pesquisarLivroPorTitulo(tituloInserido));
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar o livro por título. Por favor, tente novamente.");
        }
    }

    public void livrosPorAutor(ControllerProdutos gestor) {
        try {
            String autorInserido = leStr("Insira o autor do livro (ou 'sair' para encerrar):");
            if (autorInserido.equalsIgnoreCase("sair")) {
                return;
            }

            ArrayList<Produto> livros = gestor.pesquisarProdutoPorAutor(autorInserido);

            if (livros.isEmpty()) {
                System.out.println("Autor não existe!");
            } else {
                System.out.println(livros);
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar os livros por autor. Por favor, tente novamente.");
        }
    }

    public void livrosPorCategoria(ControllerProdutos gestor) {
        try {
            String categoriaInserida = leStr("Insira a categoria do livro (ou 'sair' para encerrar):");
            if (categoriaInserida.equalsIgnoreCase("sair")) {
                return;
            }

            ArrayList<Livro> livros = gestor.pesquisarLivroCategoria(categoriaInserida);

            if (livros.isEmpty()) {
                System.out.println("Não há livros cadastrados nesta categoria!");
                System.out.println(" ");
            } else {
                System.out.println("Livros encontrados na categoria " + categoriaInserida + ":");
                System.out.println(" ");
                for (Livro livro : livros) {
                    System.out.println(livro.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar os livros por categoria. Por favor, tente novamente.");
        }
    }

    public void livroPorISBN(ControllerProdutos gestor) {
        try {
            String ISBNinserido = leStr("Insira o ISBN do livro (ou 'sair' para encerrar):");
            if (ISBNinserido.equalsIgnoreCase("sair")) {
                return;
            }

            Livro livro = (Livro) gestor.pesquisarLivroISBN(ISBNinserido);

            if (livro == null) {
                System.out.println("ISBN não existente!");
            } else {
                System.out.println(livro);
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar o livro por ISBN. Por favor, tente novamente.");
        }
    }


}