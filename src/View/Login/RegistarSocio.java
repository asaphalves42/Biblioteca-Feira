package View.Login;

import Controller.ControllerEmail;
import Controller.ControllerLogin;

import static Utilidades.Leitura.leStr;

public class RegistarSocio {
    ControllerEmail controlleremail = new ControllerEmail();
    public void registarSocio(ControllerLogin gestor){

        String username = leStr("Insira o e-mail:");
        String password = leStr("Insira a palavra passe:");

        boolean adicionado = gestor.adicionarSocio(username, password);

        if(adicionado){
            controlleremail.enviarEmail(username, password);
            System.out.println("Registado com sucesso");
        } else {
            System.out.println("Falha ao registar-se");
        }

    }
}
