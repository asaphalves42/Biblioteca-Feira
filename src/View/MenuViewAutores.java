package View;

import static Utilidades.Leitura.ler;

public class MenuViewAutores {
    public void menuAutores() {
        int opcao;

        do {

            System.out.println("## Autores ##");
            System.out.println("------------------------");
            System.out.println("1 - Adicionar autores");
            System.out.println("2 - Listar autores");
            System.out.println("3 - Editar autores");
            System.out.println("4 - Remover autores");
            System.out.println("5 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1://Adicionar autores
                    break;
                case 2://listar autores
                    break;
                case 3://Editar autores
                    break;
                case 4://Remover autores
                    break;
                case 5://sair
                    break;
            }

        } while (opcao != 5);

    }
}
