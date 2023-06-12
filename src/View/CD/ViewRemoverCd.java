package View.CD;

import Controller.ControllerProdutos;
import Model.CD;

import static Utilidades.Leitura.leStr;

public class ViewRemoverCd {

    public void eliminarCDporTitulo(ControllerProdutos gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                for (CD cds : gestor.listarProdutosCd()) {
                    System.out.println(cds);
                }

                String input = leStr("Insira o ID do CD que deseja remover (digite '0' para sair):");
                if (input.equals("0")) {
                    break;
                }

                int idCDRemover = Integer.parseInt(input);

                boolean removido = gestor.removerProduto(idCDRemover);

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
