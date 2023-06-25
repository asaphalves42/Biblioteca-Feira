package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;

import java.util.ArrayList;
import static Utilidades.Leitura.leInt;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoPesquisarAutor {

    public void pesquisarAutorPorNome(ControllerAutores gestor) {
        try {
            String nome = leStr("Insira o nome do(a) autor(a):");
            ArrayList<Autor> autores = gestor.pesquisarAutorPorNome(nome);

            if (autores.isEmpty()) {
                System.out.println("Autor inexistente!");
                System.out.println();
            } else {
                for (Autor autor : autores) {
                    System.out.println(autor);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar o autor por nome: " + e.getMessage());
        }
    }

    public void pesquisarAutorPorId(ControllerAutores gestor) {
        try {
            int id = leInt("Insira o ID do(a) autor(a):");
            ArrayList<Autor> autores = gestor.pesquisarAutorPorId(id);

            if (autores.isEmpty()) {
                System.out.println("Autor(a) inexistente!");
                System.out.println();
            } else {
                for (Autor autor : autores) {
                    System.out.println(autor);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar o autor por ID: " + e.getMessage());
        }
    }

}
