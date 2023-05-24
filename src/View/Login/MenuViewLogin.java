package View.Login;

import Controller.ControllerCategoria;
import Controller.ControllerLogin;
import View.ViewAplicacao;

import java.sql.SQLOutput;
import java.util.InputMismatchException;

import static Utilidades.Leitura.leStr;
import static Utilidades.Leitura.ler;

public class MenuViewLogin {
    //private ControllerLogin controllerLogin = new ControllerLogin();
    ControllerLogin controllerLogin = new ControllerLogin();

    ViewFuncaoRealizarLogin realizarLogin = new ViewFuncaoRealizarLogin(controllerLogin);








    public void menuUtilizadores() {

        int opcao;

        do {
            System.out.println("## Painel Administracao ##");
            System.out.println("------------------------");

            System.out.println("1 - Zona de Administração");
            System.out.println("2 - Login");
            System.out.println("3 - Sair ");

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:



                        break;
                    case 2:
                        realizarLogin.realizarLogin();
                        break;
                    case 3:System.exit(0);
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
        } while (opcao != 4);
    }

    }



