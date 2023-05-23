package View.Login;

import Controller.ControllerLogin;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoRegistarUtilizador {

    private void registarUtilizador() {
        System.out.println("## Registar Utilizador ##");
        System.out.println("------------------------");


        String email = leStr("Email :");

        String password = leStr("Password :");

        ControllerLogin.adicionarUtilizador(email, password);

        System.out.println("Utilizador registado com sucesso!");
        System.out.println();
    }
}
