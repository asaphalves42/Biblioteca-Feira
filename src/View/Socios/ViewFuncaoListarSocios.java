package View.Socios;


import Controller.ControllerSocios;

import Model.Socio;

import java.util.ArrayList;
public class ViewFuncaoListarSocios {

    public void listartodososlivros(){
        ControllerSocios  listarsocios = new ControllerSocios();
        ArrayList<Socio> socioslistados =  listarsocios.listarsocios();

        if (socioslistados.isEmpty()){
            System.out.println("Não existem sócios registados!");
        }
        else{
            for (Socio socios : socioslistados){
                System.out.println();
            }
        }

    }
}