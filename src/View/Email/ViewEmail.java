package View.Email;

import Controller.ControllerEmail;
import java.util.Scanner;

public class ViewEmail {
    private ControllerEmail controle;

    public ViewEmail(ControllerEmail controle) {
        this.controle = controle;
    }

    public void exibirMenu() {
        System.out.println("1. Gerar código");
        System.out.println("2. Inserir código");
        System.out.println("3. Realizar ação");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }





    public void inserirCodigo() {
        // Lê o código inserido pelo usuário
        System.out.print("Digite o código: ");
        Scanner scanner = new Scanner(System.in);
        String codigoInserido = scanner.nextLine();

        // Verifica se o código está correto
        if (controle.verificarCodigo(codigoInserido)) {
            System.out.println("Código correto! Agora você pode realizar a ação.");
        } else {
            System.out.println("Código incorreto! Ação não permitida.");
        }
    }


}
