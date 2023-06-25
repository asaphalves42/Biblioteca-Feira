package View.CD;

import Controller.ControllerProdutos;
import Model.CD;
import Model.Produto;
import Model.TipoProduto;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;

public class ViewListarCd {

    public void listarCDS(ControllerProdutos gestorProdutos) {

        try {
            ArrayList<CD> cdsListados = gestorProdutos.listarProdutosCd();

            if (cdsListados.isEmpty()) {
                System.out.println("Nao existem cds no stock!");
                System.out.println(" ");

            } else {
                while (true) {

                    for (Produto CD : cdsListados) {
                        if (CD.getTipo() == TipoProduto.CD)
                            System.out.println(CD);
                    }

                    String opcao = leStr("Digite 'sair' para voltar ao menu anterior: ");
                    if (opcao.equalsIgnoreCase("sair")) {
                        break;

                    }
                }
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}





