package View.Livros;

import Controller.ControllerProdutos;
import Model.Livro;
import Model.Produto;

import java.util.ArrayList;

public class ViewFuncaoListarLivros {
    public void listarTodosOsLivros(ControllerProdutos gestor) {

        ArrayList<Livro> livrosListados = gestor.listarProdutosLivros();

        if (livrosListados.isEmpty()) {
            System.out.println("Nao existem livros no stock!");
            System.out.println(" ");
        } else {

            for (Produto livro : livrosListados) {
                if (livro.getTipo().equals("livro")) {
                    System.out.println(livro);
                }
            }
        }
    }
}
