package View.Socios;


import Controller.ControllerSocios;
import View.Login.RegistarSocio;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;


public class MenuViewSocios {
    ControllerSocios gestorSocio = new ControllerSocios();
    ViewFuncaoAdicionarSocios adSocio = new ViewFuncaoAdicionarSocios();
    ViewFuncaoListarSocios listarSocio = new ViewFuncaoListarSocios();
    ViewFuncaoEditarSocios editarSocios = new ViewFuncaoEditarSocios();
    ViewFuncaoRemoverSocios removerSocios = new ViewFuncaoRemoverSocios();
    ViewFuncaoPesquisarSocio pesquisarSocio = new ViewFuncaoPesquisarSocio();


    public void menuSocios() {
        int opcao;

        do {
            System.out.println("## Sócios ##");
            System.out.println("---------------");
            System.out.println("1 - Adicionar socio");
            System.out.println("2 - Listar socios");
            System.out.println("3 - Editar socios");
            System.out.println("4 - Remover socios");
            System.out.println("5 - Pesquisar socios");
            System.out.println("6 - Menu anterior");

            try {
                opcao = ler.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira apenas números inteiros.");
                ler.next();
                opcao = 0;
            }

            switch (opcao) {
                case 1 -> adSocio.adicionarSocios(gestorSocio);
                case 2 -> listarSocio.listarTodosOsSocios(gestorSocio);
                case 3 -> this.menuEditarSociosPorNumMecanografico();
                case 4 -> removerSocios.removerSocioPorNumMecanografico((gestorSocio));
                case 5 -> this.menuPesquisarSocios();
            }
        } while (opcao != 6);
    }

    public void menuPesquisarSocios() {

        int opcao;

        do {
            System.out.println("## Pesquisar sócio por: ##");
            System.out.println("---------------");
            System.out.println("1 - Numero mecanográfico");
            System.out.println("2 - Nome");
            System.out.println("3 - Menu anterior");

            try {
                opcao = ler.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira apenas números inteiros.");
                ler.next();
                opcao = 0;
            }

            switch (opcao) {
                case 1 -> pesquisarSocio.pesquisarSocioPorNumMecanografico(gestorSocio);
                case 2 -> pesquisarSocio.pesquisarSocioPorNome(gestorSocio);
            }
        } while (opcao != 3);
    }
    public void menuEditarSociosPorNumMecanografico() {
        int opcao;

        do {
            System.out.println("## Que campos do sócio(a) quer editar através do número Mecanográfico: ##");
            System.out.println("---------------");
            System.out.println("1 - Todos os campos do sócio(a)");
            System.out.println("2 - Nome");
            System.out.println("3 - Morada");
            System.out.println("4 - Data de Nascimento");
            System.out.println("5 - Telefone");
            System.out.println("6 - Menu anterior");

            try {
                opcao = ler.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Por favor selecione um número válido.");
                ler.nextLine();
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    editarSocios.editarSocioPorNumMecTodosOsCampos(gestorSocio);
                    break;
                case 2:
                    editarSocios.editarNomeSocioPorNumMecanografico(gestorSocio);
                    break;
                case 3:
                    editarSocios.editarMoradaSocioPorNumMecanografico(gestorSocio);
                    break;
                case 4:
                    editarSocios.editarDataDeNascimentoSocioPorNumMecanografico(gestorSocio);
                    break;
                case 5:
                    editarSocios.editarTelefoneSocioPorNumMecanografico(gestorSocio);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida. Por favor selecione uma opção válida.");
                    break;
            }
        } while (opcao != 6);
    }
}



