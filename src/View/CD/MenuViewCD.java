package View.CD;

import Controller.ControllerAutores;
import Controller.ControllerCategoria;
import Controller.ControllerProdutos;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewCD {
    ControllerAutores gestorAutor = new ControllerAutores();
    ControllerProdutos gestor = new ControllerProdutos(gestorAutor);
    ControllerCategoria gestorCategoria = new ControllerCategoria();
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
                System.out.println("6 - Gravar");
                System.out.println("7 - Menu anterior");

                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarCDS.MenuAdicionarCd(gestor, gestorCategoria);
                        break;
                    case 2:
                        listarCDS.listarCDS(gestor);
                        break;
                    case 3: //editar cds
                        editarCD();
                        break;
                    case 4: //remover cds
                        eliminarCDporTitulo.eliminarCDporTitulo(gestor);
                        break;
                    case 5:
                        pesquisarCD();
                    case 6:
                        gestor.gravarProdutosParaFicheiro();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 7);
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
                System.out.println("## CD's Editar ##");
                System.out.println("------------------------");
                System.out.println("1 - Editar Título");
                System.out.println("2 - Editar Autor");
                System.out.println("3 - Editar Quantidade");
                System.out.println("4 - Editar Número de Faixas");
                System.out.println("5 - Editar Categoria");
                System.out.println("6 - Editar Data");
                System.out.println("7 - Editar Faixa Etária");
                System.out.println("8 - Editar Produtora");
                System.out.println("9 - Menu Anterior");


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
                        editarPorCategoriaCD.editarPorCategoriaCD(gestor);
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
