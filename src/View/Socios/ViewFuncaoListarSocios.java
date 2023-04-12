package View.Socios;


import Controller.ControllerSocios;

import Model.Socio;

import java.util.ArrayList;
public class ViewFuncaoListarSocios {

    public void listarTodosOsSocios(ControllerSocios gestorSocios){

        ArrayList<Socio> sociosListados = gestorSocios.listarSocio();

        if (sociosListados.isEmpty()){
            System.out.println("Não existem sócios registados!");
        }
        else{
            for (Socio socio : sociosListados){
                System.out.println(socio);
            }
        }

    }
}