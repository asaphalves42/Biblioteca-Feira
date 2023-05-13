package View.Livros;

import Controller.ControllerProdutos;
import Model.Produto;

import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoRemoverLivros {
    public void eliminarLivroPorTitulo(ControllerProdutos gestor){

        String tituloLivro = leStr("Insira o título do livro: ");
        ArrayList<Produto> livrosParaRemover = gestor.pesquisarProdutoPorTitulo(tituloLivro);

        if(livrosParaRemover.isEmpty()){
            System.out.println("Nao existem livros no stock!");
            System.out.println(" ");
        } else{
            for(Produto livro : livrosParaRemover){
                System.out.println(livro);
            }
        }

        int idLivroRemover = leInt("Insira o id do livro que quer remover: ");

        boolean removido = gestor.removerLivro(idLivroRemover);

        if(removido){
            System.out.println("Livro se encontra numa reserva, não foi possível remover!");
            System.out.println(" ");
        }else{
            System.out.println("Livro removido com sucesso!");
            System.out.println(" ");
        }

    }
}
