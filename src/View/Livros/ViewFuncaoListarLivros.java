package View.Livros;

import Controller.ControllerProdutos;
import Model.Livro;
import Model.Produto;

import java.util.ArrayList;

public class ViewFuncaoListarLivros {
    public void listarTodosOsLivros(ControllerProdutos gestor) {
        try {
            ArrayList<Livro> livrosListados = gestor.listarProdutosLivros();

            if (livrosListados.isEmpty()) {
                System.out.println("Não existem livros no stock!");
                System.out.println(" ");
            } else {
                for (Produto livro : livrosListados) {
                    System.out.println(livro);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar os livros. Por favor, tente novamente.");
        }
    }
}

