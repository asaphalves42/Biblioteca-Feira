package View.Login;

import Controller.ControllerAdministrador;
import Controller.ControllerSuperAdministrador;

import static Utilidades.Leitura.leStr;

public class ViewLoginSuperAdministrador {
    private ControllerSuperAdministrador controllersuperadministrador;

    public ViewLoginSuperAdministrador(ControllerSuperAdministrador controllersuperadministrador) {
        this.controllersuperadministrador = controllersuperadministrador;
    }

    public boolean realizarLogin() {
        System.out.println("## Login ##");
        System.out.println("------------------------");

        boolean autenticado = false;

        do {
            String email = leStr("Email: ");
            String password = leStr("Password: ");

            autenticado = controllersuperadministrador.autenticarSuperAdministrador(email, password);

            if (!autenticado) {
                System.out.println("Credenciais inválidas.");

                String opcao = leStr("Deseja inserir novamente o email? (S/N): ");

                if (!opcao.equalsIgnoreCase("S")) {
                    break;
                }
            }
        } while (!autenticado);

        if (autenticado) {
            System.out.println("Login realizado com sucesso!");
        }

        System.out.println();

        return autenticado;
    }
}
