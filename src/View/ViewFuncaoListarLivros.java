package View;

import Controller.ControllerLivros;
import Model.Livro;

import java.util.ArrayList;

public class ViewFuncaoListarLivros {

    public void listarTodosOsLivros() {

        ControllerLivros listarLivros = new ControllerLivros();

        ArrayList<Livro> livrosListados =  listarLivros.listarLivros();

        if(livrosListados.isEmpty()){
            System.out.println("Nao existem livros no stock!");
        } else{
            for(Livro livros : livrosListados){
                System.out.println(livrosListados);
            }
        }
    }
}
