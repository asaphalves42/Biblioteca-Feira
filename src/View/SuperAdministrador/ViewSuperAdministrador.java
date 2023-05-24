package View.SuperAdministrador;

import Controller.ControllerAdministrador;
import Controller.ControllerSuperAdministrador;
import View.Login.ViewFuncaoRegistarUtilizador;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class ViewSuperAdministrador {

    ControllerAdministrador controlleradministrador = new ControllerAdministrador();
    ControllerSuperAdministrador controllersuperadministrador;

    public ViewSuperAdministrador() {
        controllersuperadministrador = new ControllerSuperAdministrador();
        controllersuperadministrador.lerAdministradorDeFicheiro();
    }

    public void menuSuperAdministrador() {
        int opcao;

        do {
            System.out.println("## Super Administrador  ##");
            System.out.println("------------------------");
            System.out.println("1 - Adicionar Administrador");
            System.out.println("2 - Remover Administrador");
            System.out.println("3 - Listar Administrador");
            System.out.println("4 - Gravar e Sair");

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        ViewRegistrarAdministrador registaradministrador = new ViewRegistrarAdministrador();
                        registaradministrador.registarAdministrador();
                        break;
                    case 2:
                        ViewRemoverAdministradores removeradministradores = new ViewRemoverAdministradores();
                        removeradministradores.removerAdministrador();
                        break;
                    case 3:
                        ViewListarAdministradores listaradministradores = new ViewListarAdministradores();
                        listaradministradores.listarTodosOsAdministradores(controllersuperadministrador);
                        break;
                    case 4:
                        controllersuperadministrador.gravarAdministradorParaFicheiro();
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
