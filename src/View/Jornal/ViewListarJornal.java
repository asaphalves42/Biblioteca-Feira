package View.Jornal;

import Controller.ControllerProdutos;
import Model.Produto;
import Model.Jornal;

import java.util.ArrayList;

public class ViewListarJornal {
    public void listarTodosAsRevistas(ControllerProdutos gestor) {
        try {
            ArrayList<Jornal> jornaisListados = gestor.listarProdutosJornal();

            if (jornaisListados.isEmpty()) {
                System.out.println("Não existem jornais no stock!");
                System.out.println(" ");
            } else {
                for (Produto jornal : jornaisListados) {
                    System.out.println(jornal);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar os jornais. Por favor, tente novamente.");
        }
    }
}

