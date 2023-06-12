package View.Livros;

import Controller.ControllerProdutos;
import Model.Produto;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoRemoverLivros {
    public void eliminarLivroPorTitulo(ControllerProdutos gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                for (Produto livro : gestor.listarProdutosLivros()) {
                    System.out.println(livro);
                }

                String input = leStr("Insira o ID do livro que deseja remover (digite '0' para sair): ");
                if (input.equals("0")) {
                    break;
                }

                int idLivroRemover = Integer.parseInt(input);

                boolean removido = gestor.removerProduto(idLivroRemover);

                if (removido) {
                    System.out.println("O livro está numa reserva, não foi possível remover!\n");
                } else {
                    System.out.println("Livro removido com sucesso!\n");
                    sair = true;  // Livro removido com sucesso, então sair do loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Insiras um número válido!\n");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro -> " + e.getMessage() + "\n");
            }
        }
    }

}

