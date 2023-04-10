package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;

import java.util.ArrayList;

import static Utilidades.Leitura.LeStr;
public class ViewFuncaoRemoverAutor {
    public void removerAutorPorNome (ControllerAutores gestor) {

        String nome = LeStr("Insira o nome do(a) autor(a)");
        ArrayList<Autor> autorParaRemover = gestor.pesquisarAutorPorNome(nome);

        if (autorParaRemover.isEmpty()) {
            System.out.println("Não existem autores listados");
            System.out.println("");
        } else {
            for(Autor autor : autorParaRemover){
                System.out.println(autor);
            }
        }
        String nomeAutor = LeStr("Insira o nome do(a) autor(a) que quer remover");

        boolean removido = gestor.removerAutor(nomeAutor);

        if (removido) {
            System.out.println("Autor(a) eliminado com sucesso");
            System.out.println("");
        } else {
            System.out.println("Autor(a) não encontrado(a)");
            System.out.println("");
        }

    }

}
