package View.Login;

import Controller.ControllerAutores;
import Controller.ControllerLogin;
import Model.Autor;
import Model.Utilizador;

import java.util.ArrayList;

public class ViewFuncaoListarUtilizadores {

    public void listarTodosOsUtilizadores(ControllerLogin gestor) {

        ArrayList<Utilizador> utilizadoreslistados = gestor.listarUtilizadores();

        if (utilizadoreslistados.isEmpty()) {
            System.out.println("Não existem utilizadores registados");
        } else {
            for (Utilizador utilizador : utilizadoreslistados) {
                System.out.println(utilizador.toString());
            }
        }
    }
}
