package View.Livros;

import Controller.ControllerProdutos;
import Model.Livro;
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
                ArrayList<Livro> livrosParaRemover = gestor.pesquisarLivroPorTitulo(tituloLivro);

                if (livrosParaRemover.isEmpty()) {
                    System.out.println("Não existem livros no stock!\n");
                } else {
                    for (Produto livro : livrosParaRemover) {
                        System.out.println(livro);
                    }
                    int idLivroRemover = leInt("Insira o ID do livro que deseja remover: ");

                    boolean removido = gestor.removerProduto(idLivroRemover);

                    if (removido) {
                        System.out.println("O livro está numa reserva, não foi possível remover!\n");
                    } else if (livrosParaRemover.stream().noneMatch(livro -> livro.getId() == idLivroRemover)) {
                        System.out.println("Não existe um livro com o ID inserido!");
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
