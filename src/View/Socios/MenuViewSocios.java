package View.Socios;


import Controller.ControllerSocios;

import static Utilidades.Leitura.ler;


public class MenuViewSocios {
    ControllerSocios gestorSocio = new ControllerSocios();
    ViewFuncaoAdicionarSocios adSocio=new ViewFuncaoAdicionarSocios();
    ViewFuncaoListarSocios listarSocio= new ViewFuncaoListarSocios();

    public void menuSocios() {
        int opcao;

        do {

            System.out.println("## Sócios ##");
            System.out.println("---------------");
            System.out.println("1 - Adicionar socio");
            System.out.println("2 - Listar socios");
            System.out.println("3 - Editar socios");
            System.out.println("4 - Remover socios");
            System.out.println("5 - Gravar");
            System.out.println("6 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1:adSocio.adicionarSocios(gestorSocio);
                    break;
                case 2:listarSocio.listarTodosOsSocios(gestorSocio);
                    break;
                case 3://Editar socios
                    break;
                case 4://Remover socios
                    break;
                case 5:gestorSocio.gravarSociosParaFicheiro();
                    break;
            }

        } while (opcao != 6);

    }


}


