package View.CD;

import Controller.ControllerProdutos;
import Model.CD;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;

public class ViewPesquisarCd {
    public void cdsPorTitulo(ControllerProdutos gestor){
        while (true) {
            try {
                String tituloCD = leStr("Insira o título do cd (ou 'sair' para voltar ao menu anterior):");

                if (tituloCD.equalsIgnoreCase("sair")) {
                    break;  // Sair do loop e retornar ao menu anterior
                }

                ArrayList<CD> CDs = gestor.pesquisarCDPorTitulo(tituloCD);

                if (CDs.isEmpty()) {
                    System.out.println("CD não encontrado!");
                } else {
                    System.out.println(CDs);
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Por favor, tente novamente.");
            }
        }
    }

    public void cdsPorAutor(ControllerProdutos gestor){
        while (true) {
            try {
                String autorCDInserido = leStr("Insira o autor do CD (ou 'sair' para voltar ao menu anterior):");

                if (autorCDInserido.equalsIgnoreCase("sair")) {
                    break;  // Sair do loop e retornar ao menu anterior
                }

                ArrayList<CD> CDs = gestor.pesquisarCDPorAutor(autorCDInserido);

                if (CDs.isEmpty()) {
                    System.out.println("Autor não encontrado!");
                } else {
                    System.out.println(CDs);
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro. Por favor, tente novamente.");
            }
        }
    }
}