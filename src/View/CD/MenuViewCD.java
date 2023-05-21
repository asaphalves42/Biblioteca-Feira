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
                        break;
                    case 4: //remover cds
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


                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1:
                        CDPorTitulo.CDPorTitulo(gestor);
                        break;
                    case 2:
                        CDSPorAutor.CDSPorAutor(gestor);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 3);

    }
}
