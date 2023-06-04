package View.Socios;


import Controller.ControllerSocios;
import Model.Socio;

import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoPesquisarSocio {

    public void pesquisarSocioPorNome(ControllerSocios gestor) {
        try {
            boolean sair = false;
            do {
                String nome = leStr("Insira o nome do sócio (Digite 'sair' para sair): ");

                if (nome.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }

                ArrayList<Socio> socios = gestor.pesquisarSocioPorNome(nome);

                if (socios.isEmpty()) {
                    System.out.println("Sócio(a) inexistente!");
                } else {
                    for (Socio socio : socios) {
                        System.out.println(socio);
                    }
                }
            } while (!sair);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar o sócio por nome: " + e.getMessage());
        }
    }

    public void pesquisarSocioPorNumMecanografico(ControllerSocios gestor) {

        try {
            boolean sair = false;
            do {
                int numMecanografico = leInt("Insira o Id do(a) sócio(a) (Digite '0' para sair): ");

                if (numMecanografico == 0) {
                    sair = true;
                    break;
                }

                Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

                if (socio == null) {
                    System.out.println("Sócio(a) inexistente!");
                } else {
                    System.out.println(socio);
                }
            } while (!sair);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao pesquisar o sócio por número mecanográfico: " + e.getMessage());
        }
    }
}

