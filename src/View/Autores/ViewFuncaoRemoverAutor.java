package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;

import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;
public class ViewFuncaoRemoverAutor {
    public void removerAutorPorNome(ControllerAutores gestor) {

        String nome = leStr("Insira o nome do(a) autor(a)");
        ArrayList<Autor> autorParaRemover = gestor.pesquisarAutorPorNome(nome);

        if (autorParaRemover.isEmpty()) {
            System.out.println("Não existem autores com esse nome!");
            System.out.println(" ");
        } else {
            boolean autorEncontrado = false;
            for (Autor autor : autorParaRemover) {
                if (autor.getNome().equals(nome)) {
                    System.out.println(autor);
                    autorEncontrado = true;
                }
            }
            if (!autorEncontrado) {
                System.out.println("Autor(a) não encontrado(a)");
                System.out.println(" ");
                return;
            }
        }

        int idAutor = leInt("Insira o Id do(a) autor(a) que quer remover");

        boolean removido = gestor.removerAutor(idAutor);
        //caso o autor esteja ligado a um livro, conforme se pode verificar no Controller Autores, nao permite remover
        if (removido) {
            System.out.println("Autor(a) eliminado com sucesso");
            System.out.println(" ");
        } else {
            System.out.println("Não é possível remover o(a) autor(a), pois está ligado a pelo menos um livro.");
            System.out.println(" ");
        }
    }

}
