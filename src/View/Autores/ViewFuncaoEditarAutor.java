package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;

import java.util.ArrayList;

import static Utilidades.Leitura.*;
public class ViewFuncaoEditarAutor {

    public void editarAutor(ControllerAutores gestor) {

        String idAutor = LeStr("Insira o Id do(a) autor(a) que quer editar");
        ArrayList<Autor> autorEditar = gestor.pesquisarAutorPorId(idAutor);

        if (autorEditar.isEmpty()) {
            System.out.println("Não existem autores com esse Id");
            System.out.println(" ");
        } else {
            for (Autor autor : autorEditar) {
                System.out.println(autor);
            }
        }

        //int idAutor = LeStr("Insira o Id d")
    }
}