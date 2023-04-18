package View.Login;

import java.util.Scanner;

public class ViewLogin {
    private Scanner ler;

    public ViewLogin() {
        ler = new Scanner(System.in);
    }

    public String getEmail() {
        System.out.println("Insira o seu email: ");
        return ler.nextLine();
    }
    public String getResposta() {
        return ler.next();
    }

    public String getPassword() {
        System.out.println("Insira a sua password: ");
        return ler.nextLine();
    }

    public static void mostrarMensagemDeLoginComSucesso() {

        System.out.println("Login realizado com sucesso!");
        System.out.println(" ");
    }

    public  static void mostrarMensagemDeLoginFalhado() {
        System.out.println("Login falhou.");
        System.out.println(" ");
    }
    public static void tentativaEmail(){
        System.out.println("Email ou senha inválidos. Deseja tentar novamente? (S/N)");
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
    public void erroFicheiroNaoEncontrado() {
        System.out.println("Ficheiro não encontrado. Tente novamente.");
        System.out.println(" ");
    }
    public void emailOuPasswordInvalida(){
        System.out.println("Email ou senha inválidos. Deseja tentar novamente? (S/N)");
        System.out.println(" ");
    }

}
