package View;


import Controller.ControllerSocios;
import View.ViewFuncaoAdicionarSocios;

import java.util.Date;

import static Utilidades.Leitura.ler;


public class MenuViewSocios {

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
                case 1://Adicionar socio
                    //MenuAdicionarSocios();
                    break;
                case 2://Listar socios * mostrar livros reservados pelo sócio
                    break;
                case 3://Editar socios
                    break;
                case 4://Remover socios
                    break;
                case 5://sair
                    break;
            }

        } while (opcao != 5);

    }


}


