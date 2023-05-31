package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;

import java.util.ArrayList;

public class ViewFuncaoListarAutores {

    public void listarTodosOsAutores(ControllerAutores gestor) {

        try {

            ArrayList<Autor> autoresListados = gestor.listarAutores();

            if (autoresListados.isEmpty()) {
                System.out.println("Não existem autores registados\n");
            } else {
                for (Autor autor : autoresListados) {
                    System.out.println(autor.toString());
                }
            }
        }catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar autores\n");
        }
    }
}
