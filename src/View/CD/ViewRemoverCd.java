package View.CD;

import Controller.ControllerProdutos;
import Model.CD;
import Model.Produto;

import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewRemoverCd {

    public void eliminarCDporTitulo(ControllerProdutos gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                String tituloCD = leStr("Insira o título do CD (ou 'sair' para voltar ao menu anterior): ");
                if (tituloCD.equalsIgnoreCase("sair")) {
                    sair = true;  // Exit the loop and go back to the previous menu
                } else {
                    ArrayList<CD> cdsParaRemover = gestor.pesquisarCDPorTitulo(tituloCD);

                    if (cdsParaRemover.isEmpty()) {
                        System.out.println("Não existem CDs no stock!\n");
                    } else {
                        for (Produto CD : cdsParaRemover) {
                            System.out.println(CD);
                        }
                        int idCDRemover = leInt("Insira o ID do CD que deseja remover: ");

                        boolean removido = gestor.removerProduto(idCDRemover);

                        if (removido) {
                            System.out.println("Não foi possível remover!\n");
                        } else {
                            System.out.println("CD removido com sucesso!\n");
                            sair = true;  // CD removido com sucesso, então sair do loop
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao remover o CD: " + e.getMessage() + "\n");
            }
        }
    }
}