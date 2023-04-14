package View.Socios;


import Controller.ControllerSocios;
import Model.Socio;

import java.util.ArrayList;

import static Utilidades.Leitura.LeStr;

public class ViewFunçãoPesquisarSocio {


    public void pesquisarSocioPorNome(ControllerSocios gestor) {

        String nome = LeStr("Insira o nome do sócio");

        ArrayList<Socio> socio = gestor.pesquisarSocioPorNome(nome);

        if (socio.isEmpty()) {
            System.out.println("Socio inexistente!");
        } else {
            System.out.println(gestor.pesquisarSocioPorNome(nome));
        }
    }

    public void pesquisarSocioPorNumMecanografico(ControllerSocios gestor) {

        String numMecanografico = LeStr("Insira o Id do(a) autor(a)");

        ArrayList<Socio> socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        if (socio.isEmpty()) {
            System.out.println("Autor(a) inexistente!");
        } else {
            System.out.println(gestor.pesquisarSocioPorNumMecanografico(numMecanografico));
        }

    }
}