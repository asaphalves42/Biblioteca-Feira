package View.Login;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewLogin {

    public void menuUtilizadores() {
        int opcao;

        do {
            System.out.println("## Sistema de Login ##");
            System.out.println("------------------------");
            System.out.println("1 - Login");
            System.out.println("2 - Registar");
            System.out.println("3 - Sair");

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        //realizarLogin();
                        break;
                    case 2:
                        //registarUtilizador();
                        break;
                    case 3:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Por favor, insira uma opção válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 3);
    }
}
