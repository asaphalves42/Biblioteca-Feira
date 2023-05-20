package View.Livros;

import Controller.ControllerProdutos;
import Model.Livro;
import Model.Produto;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoPesquisarLivros {

    public void livroPorTitulo(ControllerProdutos gestor){

        String tituloInserido = leStr("Insira o título do livro:");

        ArrayList<Livro> livros = gestor.pesquisarLivroPorTitulo(tituloInserido);

        if(livros.isEmpty()){
            System.out.println("Livro nao existente!");
        }else{
            System.out.println(gestor.pesquisarLivroPorTitulo(tituloInserido));
        }
    }

    public void livrosPorAutor(ControllerProdutos gestor){

        String autorInserido = leStr("Insira o autor do livro:");

        ArrayList<Produto> livros = gestor.pesquisarProdutoPorAutor(autorInserido);

        if(livros.isEmpty()){
            System.out.println("Autor nao existe!");
        }else{
            System.out.println(livros);
        }

    }

    public void livrosPorCategoria(ControllerProdutos gestor) {
        String categoriaInserida = leStr("Insira a categoria do livro:");
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
    }


    public void livroPorISBN(ControllerProdutos gestor){

        String ISBNinserido = leStr("Insira o ISBN do livro:");

        Livro livro = (Livro) gestor.pesquisarLivroISBN(ISBNinserido);

        if (livro == null){
            System.out.println("ISBN nao existente!");
        }else{
            System.out.println(livro);
        }

    }

}
