package View.Revista;

import Controller.ControllerProdutos;
import Model.Revista;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;

public class ViewPesquisarRevistas {
    public void RevistaPorTitulo(ControllerProdutos gestor) {
        try {
            String tituloInserido = leStr("Insira o título da revista (ou 'sair' para encerrar):");
            if (tituloInserido.equalsIgnoreCase("sair")) {
                return;
            }

            ArrayList<Revista> revistas = gestor.pesquisarRevistaPorTitulo(tituloInserido);

            if (revistas.isEmpty()) {
                System.out.println("Revista não existente!");
            } else {
                System.out.println(gestor.pesquisarRevistaPorTitulo(tituloInserido));
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar a revista. Por favor, tente novamente.");
        }
    }
    public void RevistaPorEditora(ControllerProdutos gestor) {
        try {
            String tituloInserido = leStr("Insira a editora da revista (ou 'sair' para encerrar):");
            if (tituloInserido.equalsIgnoreCase("sair")) {
                return;
            }

            ArrayList<Revista> revistas = gestor.pesquisarRevistaPorEditora(tituloInserido);

            if (revistas.isEmpty()) {
                System.out.println("Revista não existente!");
            } else {
                System.out.println(gestor.pesquisarRevistaPorEditora(tituloInserido));
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar a revista. Por favor, tente novamente.");
        }
    }

}
