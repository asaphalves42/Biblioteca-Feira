package View.Socios;


import Controller.ControllerSocios;
import View.ViewAplicacao;

import static Utilidades.Leitura.ler;


public class MenuViewSocios {
    ControllerSocios gestorSocio=new ControllerSocios();
    ViewFuncaoAdicionarSocios adSocio=new ViewFuncaoAdicionarSocios();
    ViewFuncaoListarSocios listarSocio= new ViewFuncaoListarSocios();
    ViewFuncaoEditarSocios editarSocios= new ViewFuncaoEditarSocios();
    ViewFunçãoRemoverSocios removerSocios= new ViewFunçãoRemoverSocios();
    ViewFunçãoPesquisarSocio pesquisarSocio= new ViewFunçãoPesquisarSocio();
    ViewAplicacao app = new ViewAplicacao();

    public void menuSocios() {
        int opcao;

        do {

            System.out.println("## Sócios ##");
            System.out.println("---------------");
            System.out.println("1 - Adicionar socio");
            System.out.println("2 - Listar socios");
            System.out.println("3 - Editar socios");
            System.out.println("4 - Remover socios");
            System.out.println("5 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1:adSocio.adicionarSocios(gestorSocio);
                    break;
                case 2:listarSocio.listarTodosOsSocios(gestorSocio);
                    break;
                case 3:editarSocios.editarSocio(gestorSocio);
                    break;
                case 4:
                    removerSocios.removerSocioPorNumMecanografico((gestorSocio));
                    break;
                case 5:
                    app.menuPrincipal();
                    break;
            }

        } while (opcao != 5);

    }
    public void menuPesquisarSocios() {

        int opcao;

        do {
            System.out.println("## Pesquisar sócio por: ##");
            System.out.println("---------------");
            System.out.println("1 - Numero mecanográfico");
            System.out.println("2 - Nome");
            System.out.println("3 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    pesquisarSocio.pesquisarSocioPorNumMecanografico(gestorSocio);
                    break;
                case 2:
                    pesquisarSocio.pesquisarSocioPorNome(gestorSocio);
                    break;
            }
        } while (opcao !=3);
    }

}


