package View.Login;

import Controller.ControllerEmail;
import Controller.ControllerLogin;

import static Utilidades.Leitura.leStr;

public class RegistarSocio {
    ControllerEmail controlleremail = new ControllerEmail();
    public boolean registarSocio(ControllerLogin gestor) {
        try {
            String username = leStr("Insira o e-mail (ou digite 'sair' para sair):");
            if (username.equalsIgnoreCase("sair")) {
                return false;
            }

            String password = leStr("Insira a palavra-passe:");

            boolean adicionado = gestor.adicionarSocio(username, password);

            if (adicionado) {
                controlleremail.enviarEmail(username, password);
                System.out.println("Registado com sucesso!\n");
            } else {
                System.out.println("Falha ao registar-se\n");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
        return true;
    }


}
