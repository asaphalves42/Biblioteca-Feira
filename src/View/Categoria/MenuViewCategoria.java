package View.Categoria;

import Controller.ControllerCategoria;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewCategoria {
    ControllerCategoria gestorCategoria = new ControllerCategoria();
    ViewAdicionarCategoria adicionarCategoria = new ViewAdicionarCategoria();
    ViewRemoverCategoria removerCategoria = new ViewRemoverCategoria();
    ViewListarCategorias listar = new ViewListarCategorias();

    public void menuCategoria() {
        int opcao;

        do {
            try {
                System.out.println("## Categorias: ##");
                System.out.println("---------------");
                System.out.println("1 - Adicionar");
                System.out.println("2 - Remover");
                System.out.println("3 - Listar");
                System.out.println("4 - Menu anterior");


                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1 -> adicionarCategoria.adicionarCategoria(gestorCategoria);
                    case 2 -> removerCategoria.removerCategoria(gestorCategoria);
                    case 3 -> listar.listarCategorias(gestorCategoria);
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 4);
    }
}
