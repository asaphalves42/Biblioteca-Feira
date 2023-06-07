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

        boolean adicionado = ControllerLogin.adicionarUtilizador(email, password,Integer.toString(1));

        if(adicionado){
            System.out.println("Utilizador registado com sucesso!");
        } else{
            System.out.println("erro ao sjd");
        }

        //deixar a opcao no menu
        controllerLogin.gravarUtilizadorParaFicheiro();

    }
}
