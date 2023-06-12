package View.Jornal;

import Controller.ControllerProdutos;
import Model.Jornal;

import static Utilidades.Leitura.leStr;

public class ViewRemoverJornal {
    public void eliminarJornalporTitulo(ControllerProdutos gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                for (Jornal jornais : gestor.listarProdutosJornal()) {
                    System.out.println(jornais);
                }

                String input = leStr("Insira o ID do Jornal que deseja remover (digite '0' para sair):");
                if (input.equals("0")) {
                    break;
                }

                int idJornalRemover = Integer.parseInt(input);

                boolean removido = gestor.removerProduto(idJornalRemover);

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