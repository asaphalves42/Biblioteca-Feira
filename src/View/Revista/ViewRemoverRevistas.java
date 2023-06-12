package View.Revista;

import Controller.ControllerProdutos;
import Model.Revista;

import static Utilidades.Leitura.leStr;

public class ViewRemoverRevistas {
    public void eliminarRevistaPorTitulo(ControllerProdutos gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                for (Revista revistas : gestor.listarProdutosRevistas()) {
                    System.out.println(revistas);
                }

                String input = leStr("Insira o ID da revista que deseja remover (digite '0' para sair):");
                if (input.equals("0")) {
                    break;
                }

                int idRevistaRemover = Integer.parseInt(input);

                boolean removido = gestor.removerProduto(idRevistaRemover);

                if (removido) {
                    System.out.println("Não foi possível remover!\n");
                } else {
                    System.out.println("CD removido com sucesso!\n");
                    sair = true;  // CD removido com sucesso, então sair do loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Insira um número válido!\n");
                break;
            } catch (Exception e) {
                System.out.println("Ocorreu um erro -> " + e.getMessage() + "\n");
            }
        }
    }
}
