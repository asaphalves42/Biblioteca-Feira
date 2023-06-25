package View.Categoria;

import Controller.ControllerCategoria;
import Model.Categoria;

import java.util.ArrayList;

import static Controller.ControllerCategoria.categorias;

public class ViewListarCategorias {
    public void listarCategorias(ControllerCategoria gestor) {
        try {
            ArrayList<Categoria> categoriaListada = gestor.listarCategorias();

            if (categoriaListada.isEmpty()) {
                System.out.println("Nao existem categorias!\n");

            } else {
                for (Categoria cat : categorias) {
                    System.out.println(cat.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
