package View.Login;

import Controller.ControllerCategoria;
import Controller.ControllerLogin;

import java.util.InputMismatchException;

import static Utilidades.Leitura.leStr;
import static Utilidades.Leitura.ler;

public class MenuViewLogin {
    //private ControllerLogin controllerLogin = new ControllerLogin();
    ControllerLogin controllerLogin = new ControllerLogin();
    MenuViewAdministrarUtilizadores administrarUtilizadores = new MenuViewAdministrarUtilizadores();
    ViewFuncaoRealizarLogin realizarLogin = new ViewFuncaoRealizarLogin();


    public void menuPrincipal(){


        int opcao;

        do {
            System.out.println("## Que funções deseja desempenhar ? ##");
            System.out.println("------------------------");

            System.out.println("1 - Super Administrador");
            System.out.println("2 - Sub - Administrador");
            System.out.println("3 - Bibliotecário ");
            System.out.println("4 - Sócio ");

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:

                        break;
                    case 2:
                        administrarUtilizadores.menuAdministracao();
                        break;
                    case 3: realizarLogin.realizarLogin();
                        break;
                    case 4: System.exit(0);
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
        } while (opcao != 3);
    }

    }



