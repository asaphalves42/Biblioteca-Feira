package View;

import java.util.Scanner;

public class ViewLogin {
    private Scanner scanner;

    public ViewLogin() {
        scanner = new Scanner(System.in);
    }

    public String getEmail() {
        System.out.println("Insira o seu email: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.println("Insira a sua password: ");
        return scanner.nextLine();
    }

    public void mostrarMensagemDeLoginComSucesso() {

        System.out.println("Login realizado com sucesso!");
        System.out.println(" ");
    }

    public void mostrarMensagemDeLoginFalhado() {
        System.out.println("Email ou password incorretos. Tente novamente.");
        System.out.println(" ");
    }

    public void mostrarMensagemDeRegistoComSucesso() {
        System.out.println("Registo realizado com sucesso!");
        System.out.println(" ");
    }

    public void mostrarMensagemDeRegistoFalhado() {
        System.out.println("Já existe um utilizador registado com este email. Tente novamente.");
        System.out.println(" ");
    }
}
