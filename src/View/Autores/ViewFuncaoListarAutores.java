package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;

import java.util.ArrayList;

public class ViewFuncaoListarAutores {

    public void listarTodosOsAutores(ControllerAutores gestor) {

        ControllerAutores listarAutores = new ControllerAutores();

        ArrayList <Autor> autoresListados = gestor.listarAutores();

       if (autoresListados.isEmpty()) {
            System.out.println("Não existem autores listados");
            } else {
               for (Autor autor : autoresListados) {
            System.out.println(autoresListados);
                }
        }
    }
}
