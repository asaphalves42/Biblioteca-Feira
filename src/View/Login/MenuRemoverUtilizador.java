package View.Login;

import Controller.ControllerLogin;

import static Utilidades.Leitura.leStr;

public class MenuRemoverUtilizador {
    private void apagarUtilizador() {
        System.out.println("## Apagar Utilizador ##");
        System.out.println("----------------------");

        String email = leStr("Email do utilizador a apagar:");

        boolean removido = ControllerLogin.removerUtilizador(email);

        if (removido) {
            System.out.println("Utilizador removido com sucesso!");
        } else {
            System.out.println("Utilizador não encontrado.");
        }

        System.out.println();
    }

}
