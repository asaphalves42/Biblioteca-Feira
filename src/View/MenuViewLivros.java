package View;

import static Utilidades.Leitura.ler;

public class MenuViewLivros {
    public void menuLivros2() {

        int opcao;

        do {

            System.out.println("## Pesquisar livros por: ##");
            System.out.println("---------------");
            System.out.println("1 - Autor");
            System.out.println("2 - Título");
            System.out.println("3 - ISBN");
            System.out.println("4 - Categoria");
            System.out.println("5 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1://autor
                    break;
                case 2://livroPorTitulo();
                    break;
                case 3://isbn
                    break;
                case 4://categoria
                    break;
                case 5://sair
                    break;
            }

        } while (opcao != 5);


    }

    public void menuLivros() {
        int opcao;

        do {

            System.out.println("## Livros ##");
            System.out.println("------------------------");
            System.out.println("1 - Adicionar livros");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Editar livros");
            System.out.println("4 - Remover livros");
            System.out.println("5 - Pesquisar livros");
            System.out.println("6 - Menu anterior");

            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    //menuAdicionarLivros();
                    break;
                case 2:
                    //listarTodosOsLivros();
                    break;
                case 3://Editar livros
                    break;
                case 4://eliminarLivroPorTitulo();
                    break;
                case 5:
                    //menuLivros2();
                    break;
                case 6://sair
                    break;
            }

        } while (opcao != 5);

    }



}
