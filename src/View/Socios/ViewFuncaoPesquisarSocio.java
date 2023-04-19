package View.Socios;


import Controller.ControllerSocios;
import Model.Socio;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoPesquisarSocio {

    public void pesquisarSocioPorNome(ControllerSocios gestor) {

        String nome = leStr("Insira o nome do sócio");

        ArrayList<Socio> socio = gestor.pesquisarSocioPorNome(nome);

        if (socio.isEmpty()) {
            System.out.println("Socio(a) inexistente!");
        } else {
            System.out.println(gestor.pesquisarSocioPorNome(nome));
        }
    }

    public void pesquisarSocioPorNumMecanografico(ControllerSocios gestor) {

        String numMecanografico = leStr("Insira o Id do(a) sócio(a)");

        ArrayList<Socio> socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        if (socio.isEmpty()) {
            System.out.println("Socio(a) inexistente!");
        } else {
            System.out.println(gestor.pesquisarSocioPorNumMecanografico(numMecanografico));
        }

    }
}