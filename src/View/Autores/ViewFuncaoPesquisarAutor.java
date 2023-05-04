package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;

import java.util.ArrayList;
import static Utilidades.Leitura.leInt;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoPesquisarAutor {

    public void pesquisarAutorPorNome (ControllerAutores gestor) {

        String nome = leStr("Insira o nome do(a) autor(a)");

        ArrayList<Autor> autor = gestor.pesquisarAutorPorNome(nome);

        if (autor.isEmpty()) {
            System.out.println("Autor inexistente!");
            System.out.println(" ");
        } else {
            System.out.println(gestor.pesquisarAutorPorNome(nome));
        }
    }

    public void pesquisarAutorPorId (ControllerAutores gestor) {

        int id = leInt("Insira o Id do(a) autor(a)");

        ArrayList <Autor> autor = gestor.pesquisarAutorPorId(id);

        if (autor.isEmpty()) {
            System.out.println("Autor(a) inexistente!");
            System.out.println(" ");
        } else {
            System.out.println(gestor.pesquisarAutorPorId(id));
        }

    }
}
