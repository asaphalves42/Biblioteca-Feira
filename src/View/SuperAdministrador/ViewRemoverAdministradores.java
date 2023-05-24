package View.SuperAdministrador;

import Controller.ControllerLogin;
import Controller.ControllerSuperAdministrador;

import static Utilidades.Leitura.leStr;

public class ViewRemoverAdministradores {

    public void removerAdministrador() {
        System.out.println("## Apagar Administrador ##");
        System.out.println("----------------------");

        String email = leStr("Email do administrador a apagar:");

        boolean removido = ControllerSuperAdministrador.removerAdministrador(email);

        if (removido) {
            System.out.println("Administrador removido com sucesso!");
        } else {
            System.out.println("Administrador não encontrado.");
        }



    }
}
