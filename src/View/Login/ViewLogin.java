package View.Login;

import Controller.ControllerLogin;
import Model.TipoUtilizador;

import java.sql.SQLException;

import static Utilidades.Leitura.leStr;

public class ViewLogin {
    ControllerLogin controller = new ControllerLogin();

    public TipoUtilizador verificarLogin() throws SQLException {


        String username = leStr("Insira o e-mail:");

        String password = leStr("Insira a palavra-passe:");

        return controller.verificarLogin(username, password);

    }

}
