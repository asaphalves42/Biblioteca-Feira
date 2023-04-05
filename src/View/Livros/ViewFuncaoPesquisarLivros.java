package View.Livros;

import Controller.ControllerLivros;
import Model.Livro;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoPesquisarLivros {

    public void livroPorTitulo(ControllerLivros gestor){

        String tituloInserido = leStr("Insira o título do livro:");

        ArrayList<Livro> livros = gestor.pesquisarLivroPorTitulo(tituloInserido);

        if(livros.isEmpty()){
            System.out.println("Livro nao existente!");
        }else{
            System.out.println(gestor.pesquisarLivroPorTitulo(tituloInserido));
        }
    }

    public void livrosPorAutor(ControllerLivros gestor){

        String autorInserido = leStr("Insira o autor do livro:");

        ArrayList<Livro> livros = gestor.pesquisarLivroPorAutor(autorInserido);

        if(livros.isEmpty()){
            System.out.println("Autor nao existe!");
        }else{
            System.out.println(livros);
        }

    }

    public void livrosPorCategoria(ControllerLivros gestor){

        String categoriaInserida = leStr("Insira a categoria do livro:");

        ArrayList<Livro> livros = gestor.pesquisarLivroCategoria(categoriaInserida);

        if(livros.isEmpty()){
            System.out.println("Categoria nao existente!");
        }else{
            System.out.println(livros);
        }

    }

    public void livrosPorISBN(ControllerLivros gestor){

        String ISBNinserido = leStr("Insira o ISBN do livro:");

        ArrayList<Livro> livros = gestor.pesquisarLivroISBN(ISBNinserido);

        if(livros.isEmpty()){
            System.out.println("ISBN nao existente!");
        }else{
            System.out.println(livros);
        }

    }

}
