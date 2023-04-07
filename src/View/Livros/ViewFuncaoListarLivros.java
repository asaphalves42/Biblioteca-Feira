package View.Livros;

import Controller.ControllerLivros;
import Model.Livro;

import java.util.ArrayList;

public class ViewFuncaoListarLivros {

    public void listarTodosOsLivros(ControllerLivros gestor) {

        ArrayList<Livro> livrosListados = gestor.listarLivros();

        if(livrosListados.isEmpty()){
            System.out.println("Nao existem livros no stock!");
            System.out.println(" ");
        } else{
            for(Livro livro : livrosListados){
                System.out.println(livro);
            }
        }
    }
}
