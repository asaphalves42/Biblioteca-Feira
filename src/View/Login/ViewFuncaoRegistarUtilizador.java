package View.Login;

import Controller.ControllerLogin;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoRegistarUtilizador {
    ControllerLogin controllerLogin = new ControllerLogin();

    public void registarUtilizador() {
        System.out.println("## Registar Utilizador ##");
        System.out.println("------------------------");


        String email = leStr("Email :");

        String password = leStr("Password :");

        ControllerLogin.adicionarUtilizador(email, password);

        System.out.println("Utilizador registado com sucesso!");
        controllerLogin.gravarUtilizadorParaFicheiro();
        System.out.println();
    }
}
