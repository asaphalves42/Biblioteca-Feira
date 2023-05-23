package View.Login;

import Controller.ControllerLogin;

import static Utilidades.Leitura.leStr;
import static Utilidades.Leitura.ler;
import Controller.ControllerLogin;
import View.ViewAplicacao;

public class ViewFuncaoRealizarLogin {
    private ControllerLogin controllerLogin = new ControllerLogin();
    ViewAplicacao viewaplicacao = new ViewAplicacao();

    public void realizarLogin() {
        System.out.println("## Login ##");
        System.out.println("------------------------");

        boolean autenticado = false;

        do {
            String  email = leStr("Password: ");


          String  password = leStr("Password: ");

            autenticado = controllerLogin.autenticarUtilizador(email, password);

            if (!autenticado) {
                System.out.println("Credenciais inválidas.");


                String  opcao = leStr("Deseja inserir novamente o email? (S/N): ");

                if (!opcao.equalsIgnoreCase("S")) {
                    break;
                }
            }
        } while (!autenticado);

        if (autenticado) {
            System.out.println("Login realizado com sucesso!");
            viewaplicacao.menuPrincipal();
        }

        System.out.println();
    }

}
