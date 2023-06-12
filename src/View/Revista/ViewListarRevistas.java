package View.Revista;

import Controller.ControllerProdutos;
import Model.Produto;
import Model.Revista;

import java.util.ArrayList;

public class ViewListarRevistas {
    public void listarTodasAsRevistas(ControllerProdutos gestor) {
        try {
            ArrayList<Revista> revistasListadas = gestor.listarProdutosRevistas();

            if (revistasListadas.isEmpty()) {
                System.out.println("Não existem revistas no stock!");
                System.out.println(" ");
            } else {
                for (Produto revista : revistasListadas) {
                    System.out.println(revista);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar as revistas. Por favor, tente novamente.");
        }
    }
}

