package View.Revista;

import Controller.ControllerProdutos;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewRevistas {
    public MenuViewRevistas (ControllerProdutos controllerProdutos) {
        this.gestor=controllerProdutos;
    }
    ControllerProdutos gestor;
    ViewAdicionarRevistas adicionarRevista=new ViewAdicionarRevistas();
    ViewListarRevistas listarRevistas=new ViewListarRevistas();
    ViewEditarRevistas editarRevistas=new ViewEditarRevistas();

    ViewPesquisarRevistas pesquisarRevistas=new ViewPesquisarRevistas();

    ViewRemoverRevistas removerRevistas=new ViewRemoverRevistas();


    public void menuRevistas() {
        int opcao;

        do {
            try {
                System.out.println("## Revistas ##");
                System.out.println("------------------------");
                System.out.println("1 - Adicionar revista");
                System.out.println("2 - Listar revista");
                System.out.println("3 - Editar revista");
                System.out.println("4 - Remover revista");
                System.out.println("5 - Pesquisar revista");
                System.out.println("6 - Gravar");
                System.out.println("7 - Menu anterior");

                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarRevista.MenuAdicionarRevista(gestor);
                        break;
                    case 2:
                        listarRevistas.listarTodasAsRevistas(gestor);
                        break;
                    case 3:
                        editarRevistas();
                        break;
                    case 4:
                        removerRevistas.eliminarRevistaPorTitulo(gestor);
                        break;
                    case 5:
                        pesquisarRevistas();
                    case 6:
                        gestor.gravarBaseDadosProdutos();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 7);
    }

    public void pesquisarRevistas() {
        int opcao;

        do {
            try {
                System.out.println("## Revistas's ##");
                System.out.println("------------------------");
                System.out.println("1 - Pesquisar revistas por título");
                System.out.println("2 - Pesquisar revistas por editora");
                System.out.println("3 - Menu Anterior");


                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1 -> pesquisarRevistas.revistaPorTitulo(gestor);
                    case 2 -> pesquisarRevistas.revistaPorEditora(gestor);
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 3);

    }

    public void editarRevistas() {
        int opcao;

        do {
            try {
                System.out.println("## Revistas Editar por: ##");
                System.out.println("------------------------");
                System.out.println("1 - Editar título");
                System.out.println("2 - Editar subtiulo");
                System.out.println("3 - Editar número de páginas");
                System.out.println("4 - Editar data");
                System.out.println("5 - Editar editora");
                System.out.println("6 - Menu anterior");


                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1 -> editarRevistas.editarRevistaPorTitulo(gestor);
                    case 2 -> editarRevistas.editarRevistaPorSubTitulo(gestor);
                    case 3 -> editarRevistas.editarNumPaginasRevista(gestor);
                    case 4 -> editarRevistas.editarPorDataRevista(gestor);
                    case 5 -> editarRevistas.editarEditoraRevista(gestor);
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 6);

    }
}




