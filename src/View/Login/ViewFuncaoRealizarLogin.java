package View.Login;

import Controller.ControllerLogin;

import static Utilidades.Leitura.ler;
import Controller.ControllerLogin;
public class ViewFuncaoRealizarLogin {
    private ControllerLogin controllerLogin = new ControllerLogin();

    private void realizarLogin() {
        System.out.println("## Login ##");
        System.out.println("------------------------");

        System.out.print("Email: ");
        String email = ler.nextLine();

        System.out.print("Password: ");
        String password = ler.nextLine();


        boolean autenticado = controllerLogin.autenticarUtilizador(email, password);

        if (autenticado) {
            System.out.println("Login realizado com sucesso!");
            // Coloque aqui o código que deseja executar após o login bem-sucedido
        } else {
            System.out.println("Credenciais inválidas. Tente novamente.");
        }

        System.out.println();
    }
}
