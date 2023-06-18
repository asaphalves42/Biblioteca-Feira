package View.CD;

import Controller.ControllerAutores;
import Controller.ControllerCategoria;
import Controller.ControllerProdutos;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewCD {

    public MenuViewCD (ControllerProdutos controllerProdutos, ControllerCategoria controllerCategorias, ControllerAutores controllerAutores) {
        this.gestor = controllerProdutos;
        this.gestorCategorias = controllerCategorias;
        this.gestorAutores = controllerAutores;
    }
    ControllerProdutos gestor;
    ControllerCategoria gestorCategorias;
    ControllerAutores gestorAutores;
    ViewListarCd listarCDS = new ViewListarCd();
    ViewAdicionarCd adicionarCDS = new ViewAdicionarCd();
    ViewPesquisarCd CDPorTitulo = new ViewPesquisarCd();
    ViewPesquisarCd CDSPorAutor= new ViewPesquisarCd();
    ViewRemoverCd eliminarCDporTitulo = new ViewRemoverCd();
    ViewEditarCd editarCDSPorTitulo = new ViewEditarCd();
    ViewEditarCd editarQuantidadeCD = new ViewEditarCd();
    ViewEditarCd editarCDSPorAutor = new ViewEditarCd();
    ViewEditarCd editarNumFaixas = new ViewEditarCd();
    ViewEditarCd editarPorCategoriaCD =new ViewEditarCd();
    ViewEditarCd editarPorDataCD =new ViewEditarCd();
    ViewEditarCd editarFaixaEtariaCD =new ViewEditarCd() ;
    ViewEditarCd editarEditoraCD = new ViewEditarCd();

    public void menuCds() {
        int opcao;

        do {
            try {
                System.out.println("## CD's ##");
                System.out.println("------------------------");
                System.out.println("1 - Adicionar cd");
                System.out.println("2 - Listar cd's");
                System.out.println("3 - Editar cd");
                System.out.println("4 - Remover cd");
                System.out.println("5 - Pesquisar cd");
                System.out.println("6 - Menu anterior");

                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1 -> adicionarCDS.MenuAdicionarCd(gestor, gestorCategorias, gestorAutores);
                    case 2 -> listarCDS.listarCDS(gestor);
                    case 3 -> //editar cds
                            editarCD();
                    case 4 -> //remover cds
                            eliminarCDporTitulo.eliminarCDporTitulo(gestor);
                    case 5 -> pesquisarCD();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 6);
    }

    public void pesquisarCD() {
        int opcao;

        do {
            try {
                System.out.println("## CD's ##");
                System.out.println("------------------------");
                System.out.println("1 - Pesquisar cds por título");
                System.out.println("2 - Pesquisar cds por autor");
                System.out.println("3 - Menu Anterior");


                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        CDPorTitulo.cdsPorTitulo(gestor);
                        break;
                    case 2:
                        CDSPorAutor.cdsPorAutor(gestor);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 3);

    }

    public void editarCD() {
        int opcao;

        do {
            try {
                System.out.println("## CD's Editar por: ##");
                System.out.println("------------------------");
                System.out.println("1 - Editar título");
                System.out.println("2 - Editar autor");
                System.out.println("3 - Editar quantidade");
                System.out.println("4 - Editar número de faixas");
                System.out.println("5 - Editar categoria");
                System.out.println("6 - Editar data");
                System.out.println("7 - Editar faixa etária");
                System.out.println("8 - Editar produtora");
                System.out.println("9 - Menu anterior");


                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        editarCDSPorTitulo.editarCDSPorTitulo(gestor);
                        break;
                    case 2:
                        editarCDSPorAutor.editarCDSPorAutor(gestor);
                        break;
                    case 3:
                        editarQuantidadeCD.editarQuantidadeCD(gestor);
                        break;
                    case 4:
                        editarNumFaixas.editarNumFaixas(gestor);
                        break;
                    case 5:
                        editarPorCategoriaCD.editarPorCategoriaCD(gestor,gestorCategorias);
                        break;
                    case 6:
                        editarPorDataCD.editarPorDataCD(gestor);
                        break;
                    case 7:
                        editarFaixaEtariaCD.editarFaixaEtaria(gestor);
                        break;
                    case 8:
                        editarEditoraCD.editarEditoraCD(gestor);


                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 9);

    }
}
