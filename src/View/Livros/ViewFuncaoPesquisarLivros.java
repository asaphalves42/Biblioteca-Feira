package View.Livros;

import Controller.ControllerLivros;
import Model.Livro;

import java.util.ArrayList;

import static Utilidades.Leitura.LeStr;

public class ViewFuncaoPesquisarLivros {

    public void livroPorTitulo(ControllerLivros gestor){

        String tituloInserido = LeStr("Insira o título do livro:");

        ArrayList<Livro> livros = gestor.pesquisarLivroPorTitulo(tituloInserido);

        if(livros.isEmpty()){
            System.out.println("Livro nao existente!");
        }else{
            System.out.println(gestor.pesquisarLivroPorTitulo(tituloInserido));
        }
    }

    public void livrosPorAutor(ControllerLivros gestor){

        String autorInserido = LeStr("Insira o autor do livro:");

        ArrayList<Livro> livros = gestor.pesquisarLivroPorAutor(autorInserido);

        if(livros.isEmpty()){
            System.out.println("Autor nao existe!");
        }else{
            System.out.println(livros);
        }

    }

    public void livrosPorCategoria(ControllerLivros gestor){

        String categoriaInserida = LeStr("Insira a categoria do livro:");

        ArrayList<Livro> livros = gestor.pesquisarLivroCategoria(categoriaInserida);

        if(livros.isEmpty()){
            System.out.println("Categoria nao existente!");
        }else{
            System.out.println(livros);
        }

    }

    public void livroPorISBN(ControllerLivros gestor){

        String ISBNinserido = LeStr("Insira o ISBN do livro:");

        Livro livro = gestor.pesquisarLivroISBN(ISBNinserido);

        if (livro == null){
            System.out.println("ISBN nao existente!");
        }else{
            System.out.println(livro);
        }

    }

}
