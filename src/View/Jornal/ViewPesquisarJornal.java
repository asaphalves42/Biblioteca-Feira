package View.Jornal;

import Controller.ControllerProdutos;
import Model.Jornal;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;

public class ViewPesquisarJornal {
    public void JornalPorTitulo(ControllerProdutos gestor) {
        try {
            String tituloInserido = leStr("Insira o título do jornal (ou 'sair' para encerrar):");
            if (tituloInserido.equalsIgnoreCase("sair")) {
                return;
            }

            ArrayList<Jornal> jornais = gestor.pesquisarJornalPorTitulo(tituloInserido);

            if (jornais.isEmpty()) {
                System.out.println("Jornal não existente!");
            } else {
                System.out.println(gestor.pesquisarLivroPorTitulo(tituloInserido));
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar o jornal. Por favor, tente novamente.");
        }
    }
    public void JornalPorEditora(ControllerProdutos gestor) {
        try {
            String tituloInserido = leStr("Insira a editora do jornal (ou 'sair' para encerrar):");
            if (tituloInserido.equalsIgnoreCase("sair")) {
                return;
            }

            ArrayList<Jornal> jornais = gestor.pesquisarJornalPorEditora(tituloInserido);

            if (jornais.isEmpty()) {
                System.out.println("Jornal não existente!");
            } else {
                System.out.println(gestor.pesquisarJornalPorEditora(tituloInserido));
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar o jornal. Por favor, tente novamente.");
        }
    }

}
