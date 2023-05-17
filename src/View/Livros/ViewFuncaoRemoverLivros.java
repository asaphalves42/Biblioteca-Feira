package View.Livros;

import Controller.ControllerProdutos;
import Model.Produto;

import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoRemoverLivros {
    public void eliminarLivroPorTitulo(ControllerProdutos gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                String tituloLivro = leStr("Insira o título do livro: ");
                ArrayList<Produto> livrosParaRemover = gestor.pesquisarProdutoPorTitulo(tituloLivro);

                if (livrosParaRemover.isEmpty()) {
                    System.out.println("Não existem livros no estoque!\n");
                } else {
                    for (Produto livro : livrosParaRemover) {
                        System.out.println(livro);
                    }
                    int idLivroRemover = leInt("Insira o ID do livro que deseja remover: ");

                    boolean removido = gestor.removerLivro(idLivroRemover);

                    if (removido) {
                        System.out.println("O livro está em uma reserva, não foi possível remover!\n");
                    } else {
                        System.out.println("Livro removido com sucesso!\n");
                        sair = true;  // Livro removido com sucesso, então sair do loop
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao remover o livro: " + e.getMessage() + "\n");
            }
        }
    }
}
