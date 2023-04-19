package View.Autores;

import Controller.ControllerAutores;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewAutores {
    ControllerAutores gestor = new ControllerAutores();
    ViewFuncaoAdicionarAutor adicionar = new ViewFuncaoAdicionarAutor();
    ViewFuncaoListarAutores listar = new ViewFuncaoListarAutores();
    ViewFuncaoEditarAutor editar = new ViewFuncaoEditarAutor();
    ViewFuncaoRemoverAutor remover = new ViewFuncaoRemoverAutor();
    ViewFuncaoPesquisarAutor pesquisar = new ViewFuncaoPesquisarAutor();
    public void menuAutores() {

        int opcao;

        do {

            try {

                System.out.println("## Autores ##");
                System.out.println("------------------------");
                System.out.println("1 - Adicionar autores");
                System.out.println("2 - Listar autores");
                System.out.println("3 - Pesquisar autor");
                System.out.println("4 - Editar autores");
                System.out.println("5 - Remover autores");
                System.out.println("6 - Gravar");
                System.out.println("7 - Menu anterior");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1 -> adicionar.menuAdicionarAutores(gestor);
                    case 2 -> listar.listarTodosOsAutores(gestor);
                    case 3 -> menuPesquisarAutores();
                    case 4 -> editar.editarAutor(gestor);
                    case 5 -> remover.removerAutorPorNome(gestor);
                    case 6 -> gestor.gravarAutorParaFicheiro();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 8);
    }

    public void menuPesquisarAutores() {

        int opcao;

        do {
            try {
                System.out.println("## Pesquisar autor por: ##");
                System.out.println("---------------");
                System.out.println("1 - Id");
                System.out.println("2 - Nome");
                System.out.println("3 - Menu anterior");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1 -> pesquisar.pesquisarAutorPorId(gestor);
                    case 2 -> pesquisar.pesquisarAutorPorNome(gestor);
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 3);

    }

}