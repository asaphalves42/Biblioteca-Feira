package View.Login;

import View.ViewAplicacao;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewAdministrarUtilizadores {
    ViewFuncaoRegistarUtilizador registarutilizador = new ViewFuncaoRegistarUtilizador();
    ViewFuncaoRealizarLogin realizarLogin = new ViewFuncaoRealizarLogin();
    ViewFuncaoRemoverUtilizador removerutilizador = new ViewFuncaoRemoverUtilizador();
    ViewAplicacao viewaplicacao = new ViewAplicacao();

    public void menuAdministracao() {
        int opcao;

        do {
            System.out.println("## Sistema de Administração ##");
            System.out.println("------------------------");
            System.out.println("1 - Registar Utilizador");
            System.out.println("2 - Eliminar Utilizador");
            System.out.println("3 - Aceder à Libraria");
            System.out.println("3 - Sair");

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        registarutilizador.registarUtilizador();
                        break;
                    case 2:
                        removerutilizador.apagarUtilizador();
                        break;
                    case 3:
                        viewaplicacao.menuPrincipal();

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