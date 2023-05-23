package View.CD;

import Controller.ControllerProdutos;
import Model.CD;
import Model.Produto;

import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewEditarCd {
    public void editarCDSPorTitulo(ControllerProdutos gestor){
        ArrayList<CD> cdsParaEditar;

        while (true) {
            String tituloCD = leStr("Insira o título do CD que quer editar:");
          cdsParaEditar = gestor.pesquisarCDPorTitulo(tituloCD);

            if (cdsParaEditar.isEmpty()) {
                System.out.println("Não existem livros com este título!");
                System.out.println(" ");
            } else {
                for (Produto CD : cdsParaEditar) {
                    System.out.println(CD);
                }
                break;
            }
        }

        int idEditarTitulo = leInt("Insira o id do CD que quer editar: ");
        String tituloNovo = leStr("Insira o novo título:");

        boolean tituloEditado = gestor.editarTituloDoLivro(idEditarTitulo, tituloNovo);

        if(tituloEditado){
            System.out.println("CD editado com sucesso!");
            System.out.println(" ");
        } else{
            System.out.println("CD não encontrado!");
            System.out.println(" ");
        }
    }
}
