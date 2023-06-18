package View.Jornal;

import Controller.ControllerProdutos;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewJornais {
    public MenuViewJornais (ControllerProdutos controllerProdutos) {
        this.gestor=controllerProdutos;
    }
    ControllerProdutos gestor;
    ViewAdicionarJornal adicionarJornal=new ViewAdicionarJornal();
    ViewListarJornal listarJornal=new ViewListarJornal();
    ViewEditarJornal editarJornal=new ViewEditarJornal();

    ViewPesquisarJornal pesquisarJornal=new ViewPesquisarJornal();

    ViewRemoverJornal removerJornal=new ViewRemoverJornal();


    public void menuJornais() {
        int opcao;

        do {
            try {
                System.out.println("## Jornais ##");
                System.out.println("------------------------");
                System.out.println("1 - Adicionar jornal");
                System.out.println("2 - Listar jornais");
                System.out.println("3 - Editar jornais");
                System.out.println("4 - Remover jornais");
                System.out.println("5 - Pesquisar jornais");
                System.out.println("6 - Menu anterior");

                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarJornal.MenuAdicionarJornal(gestor);
                        break;
                    case 2:
                        listarJornal.listarTodosOsJornais(gestor);
                        break;
                    case 3: //editar Jornais
                        editarJornal();
                        break;
                    case 4: //remover Jornais
                        removerJornal.eliminarJornalporTitulo(gestor);
                        break;
                    case 5:
                        pesquisarJornal();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 6);
    }

    public void pesquisarJornal() {
        int opcao;

        do {
            try {
                System.out.println("## Jornal ##");
                System.out.println("------------------------");
                System.out.println("1 - Pesquisar Jornais por título");
                System.out.println("2 - Pesquisar Jornais por editora");
                System.out.println("3 - Menu Anterior");


                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        pesquisarJornal.JornalPorTitulo(gestor);
                        break;
                    case 2:
                        pesquisarJornal.JornalPorEditora(gestor);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 3);

    }

    public void editarJornal() {
        int opcao;

        do {
            try {
                System.out.println("## Jornal Editar por: ##");
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
                    case 1:
                        editarJornal.editarJornalPorTitulo(gestor);
                        break;
                    case 2:
                        editarJornal.editarJornalPorSubTitulo(gestor);
                        break;
                    case 3:
                        editarJornal.editarNumPaginasJornal(gestor);
                        break;
                    case 4:
                        editarJornal.editarPorDataJornal(gestor);
                        break;
                    case 5:
                        editarJornal.editarEditoraJornal(gestor);


                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 6);

    }
}


