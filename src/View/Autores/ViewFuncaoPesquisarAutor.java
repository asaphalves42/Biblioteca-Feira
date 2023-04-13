package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;

import java.util.ArrayList;
import static Utilidades.Leitura.LeInt;

import static Utilidades.Leitura.LeStr;

public class ViewFuncaoPesquisarAutor {

    public void pesquisarAutorPorNome (ControllerAutores gestor) {

        String nome = LeStr("Insira o nome do(a) autor(a)");

        ArrayList<Autor> autor = gestor.pesquisarAutorPorNome(nome);

        if (autor.isEmpty()) {
            System.out.println("Autor inexistente!");
        } else {
            System.out.println(gestor.pesquisarAutorPorNome(nome));
        }
    }

    public void pesquisarAutorPorId (ControllerAutores gestor) {

        int id = LeInt("Insira o Id do(a) autor(a)");

        ArrayList <Autor> autor = gestor.pesquisarAutorPorId(id);

        if (autor.isEmpty()) {
            System.out.println("Autor(a) inexistente!");
        } else {
            System.out.println(gestor.pesquisarAutorPorId(id));
        }

    }
}
