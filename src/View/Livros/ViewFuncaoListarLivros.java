package View.Livros;

import Controller.ControllerProdutos;
import Model.Produto;

import java.util.ArrayList;

public class ViewFuncaoListarLivros {
    public void listarTodosOsLivros(ControllerProdutos gestor) {

        ArrayList<Produto> livrosListados = gestor.listarProdutos();

        if(livrosListados.isEmpty()){
            System.out.println("Nao existem livros no stock!");
            System.out.println(" ");
        } else{
            for(Produto livro : livrosListados){
                System.out.println(livro.toString());
            }
        }
    }
}
