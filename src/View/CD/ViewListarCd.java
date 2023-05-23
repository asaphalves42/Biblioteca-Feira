package View.CD;

import Controller.ControllerProdutos;
import Model.CD;
import Model.Produto;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;

public class ViewListarCd {

    public void listarCDS(ControllerProdutos gestorCds) {

        ArrayList<CD> cdsListados = gestorCds.listarProdutosCd();

        if (cdsListados.isEmpty()) {
            System.out.println("Nao existem cds no stock!");
            System.out.println(" ");

        } else {
            while (true) {

                for (Produto CD : cdsListados) {
                    if (CD.getTipo().equals("CD"))
                        System.out.println(CD);
                }

                String opcao = leStr("Digite 'sair' para voltar ao menu anterior: ");
                if (opcao.equalsIgnoreCase("sair")) {
                    break;

                }
            }
        }
    }
}





