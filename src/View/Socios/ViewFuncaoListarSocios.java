package View.Socios;


import Controller.ControllerSocios;

import Model.Socio;

import java.util.ArrayList;
public class ViewFuncaoListarSocios {

    public void listarTodosOsSocios(ControllerSocios gestorSocios){
        try {
            ArrayList<Socio> sociosListados = gestorSocios.listarSocio();

            if (sociosListados.isEmpty()) {
                System.out.println("Não existem sócios registados!");
                System.out.println(" ");
            } else {
                for (Socio socio : sociosListados) {
                    System.out.println(socio);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar os sócios: " + e.getMessage());
        }
    }
}