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

    ViewEditarRevistas editarRevistasPorTitulo=new ViewEditarRevistas();
    ViewEditarRevistas editarRevistasPorSubtitulo=new ViewEditarRevistas();

    ViewEditarRevistas editarRevistasEditora=new ViewEditarRevistas();

    ViewEditarRevistas editarNumPaginasRevistas = new ViewEditarRevistas();
    ViewEditarRevistas editarPorDataRevistas=new ViewEditarRevistas();

    ViewEditarRevistas editarEditarRevistas = new ViewEditarRevistas();

    public void menuRevistas() {
        int opcao;

        do {
            try {
                System.out.println("## Revistas ##");
                System.out.println("------------------------");
                System.out.println("1 - Adicionar Revista");
                System.out.println("2 - Listar Revista");
                System.out.println("3 - Editar Revista");
                System.out.println("4 - Remover Revista");
                System.out.println("5 - Pesquisar Revista");
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
                    case 3: //editar Jornais
                        editarRevistas();
                        break;
                    case 4: //remover Jornais
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
                System.out.println("1 - Pesquisar Revistas por título");
                System.out.println("2 - Pesquisar Revistas por editora");
                System.out.println("3 - Menu Anterior");


                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        pesquisarRevistas.RevistaPorTitulo(gestor);
                        break;
                    case 2:
                        pesquisarRevistas.RevistaPorEditora(gestor);
                        break;
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
                System.out.println("1 - Editar Título");
                System.out.println("2 - Editar Subtiulo");
                System.out.println("3 - Editar Numero de paginas");
                System.out.println("4 - Editar Data");
                System.out.println("5 - Editar Editora");
                System.out.println("6 - Menu anterior");


                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        editarRevistas.editarRevistaPorTitulo(gestor);
                        break;
                    case 2:
                        editarRevistas.editarRevistaPorSubTitulo(gestor);
                        break;
                    case 3:
                        editarRevistas.editarNumPaginasRevista(gestor);
                        break;
                    case 4:
                        editarRevistas.editarPorDataRevista(gestor);
                        break;
                    case 5:
                        editarRevistas.editarEditoraRevista(gestor);


                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 6);

    }
}




