package View.Livros;

import Controller.ControllerLivros;
import Model.Livro;

import java.util.ArrayList;

import static Utilidades.Leitura.*;

public class ViewFuncaoRemoverLivros {
    public void eliminarLivroPorTitulo(ControllerLivros gestor){

        String tituloLivro = leStr("Insira o título do livro: ");
        ArrayList<Livro> livrosParaRemover = gestor.pesquisarLivroPorTitulo(tituloLivro);

        if(livrosParaRemover.isEmpty()){
            System.out.println("Nao existem livros no stock!");
            System.out.println(" ");
        } else{
            for(Livro livro : livrosParaRemover){
                System.out.println(livro);
            }
        }

        int idLivroRemover = LeInt("Insira o id do livro que quer remover: ");

        boolean removido =  gestor.removerLivros(idLivroRemover);

        if(removido){
            System.out.println("Livro removido com sucesso");
            System.out.println(" ");
        }else{
            System.out.println("Livro não encontrado!");
            System.out.println(" ");
        }

    }
}
