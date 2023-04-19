package View.Socios;


import Controller.ControllerSocios;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;


public class MenuViewSocios {
    ControllerSocios gestorSocio=new ControllerSocios();
    ViewFuncaoAdicionarSocios adSocio=new ViewFuncaoAdicionarSocios();
    ViewFuncaoListarSocios listarSocio= new ViewFuncaoListarSocios();
    ViewFuncaoEditarSocios editarSocios= new ViewFuncaoEditarSocios();
    ViewFuncaoRemoverSocios removerSocios= new ViewFuncaoRemoverSocios();
    ViewFuncaoPesquisarSocio pesquisarSocio= new ViewFuncaoPesquisarSocio();

    public void menuSocios() {
        int opcao;

        do {

            try {
                System.out.println("## Sócios ##");
                System.out.println("---------------");
                System.out.println("1 - Adicionar socio");
                System.out.println("2 - Listar socios");
                System.out.println("3 - Editar socios");
                System.out.println("4 - Remover socios");
                System.out.println("5 - Pesquisar sócios");
                System.out.println("6 - Gravar");
                System.out.println("7 - Menu anterior");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1 -> adSocio.adicionarSocios(gestorSocio);
                    case 2 -> listarSocio.listarTodosOsSocios(gestorSocio);
                    case 3 -> editarSocios.editarSocio(gestorSocio);
                    case 4 -> removerSocios.removerSocioPorNumMecanografico((gestorSocio));
                    case 5 -> this.menuPesquisarSocios();
                    case 6 -> gestorSocio.gravarSociosParaFicheiro();
                }
            } catch (InputMismatchException e) {
                System.out.println("Insira um número válido!");
                opcao = 0;
            }
        } while (opcao != 7);
    }
    public void menuPesquisarSocios() {

        int opcao;

        do {
            try {
                System.out.println("## Pesquisar sócio por: ##");
                System.out.println("-----------------------------");
                System.out.println("1 - Numero mecanográfico");
                System.out.println("2 - Nome");
                System.out.println("3 - Menu anterior");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1 -> pesquisarSocio.pesquisarSocioPorNumMecanografico(gestorSocio);
                    case 2 -> pesquisarSocio.pesquisarSocioPorNome(gestorSocio);
                }
            } catch (InputMismatchException e) {
                System.out.println("Insira uma número válido!");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao !=3);
    }

}


