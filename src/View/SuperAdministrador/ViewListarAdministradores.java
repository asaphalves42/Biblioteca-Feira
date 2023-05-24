package View.SuperAdministrador;

import Controller.ControllerLogin;
import Controller.ControllerSuperAdministrador;
import Model.Administrador;
import Model.Utilizador;

import java.util.ArrayList;

public class ViewListarAdministradores {



        public void listarTodosOsAdministradores(ControllerSuperAdministrador gestor) {

            ArrayList<Administrador> administradoreslistados = gestor.listarAdministradores();

            if (administradoreslistados.isEmpty()) {
                System.out.println("Não existem administradores registados");
            } else {
                for (Administrador administrador : administradoreslistados) {
                    System.out.println(administrador.toString());
                }
            }
        }
}
