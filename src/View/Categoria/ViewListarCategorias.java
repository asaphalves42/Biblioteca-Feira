package View.Categoria;

import Controller.ControllerCategoria;
import Model.Categoria;

import java.util.ArrayList;

import static Controller.ControllerCategoria.categorias;

public class ViewListarCategorias {
    public void listarCategorias(ControllerCategoria gestor) {

        ArrayList<Categoria> categoriaListada = gestor.listarCategorias();

        if(categoriaListada.isEmpty()) {
            System.out.println("Nao existem categorias!");
            System.out.println(" ");
        } else{
            for(Categoria cat : categorias){
                System.out.println(cat.toString());
            }
        }
    }

}
