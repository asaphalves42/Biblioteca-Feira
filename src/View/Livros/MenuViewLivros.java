package View.Livros;

import Controller.ControllerAutores;
import Controller.ControllerCategoria;
import Controller.ControllerProdutos;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewLivros {

    public MenuViewLivros (ControllerProdutos controllerProdutos, ControllerCategoria controllerCategorias, ControllerAutores controllerAutores) {
        this.gestor = controllerProdutos;
        this.gestorCategorias = controllerCategorias;
        this.gestorAutores = controllerAutores;
    }
    ControllerProdutos gestor;
    ControllerCategoria gestorCategorias;
    ControllerAutores gestorAutores;
    ViewAdicionarLivros adicionar = new ViewAdicionarLivros();
    ViewFuncaoListarLivros mostrar = new ViewFuncaoListarLivros();
    ViewFuncaoRemoverLivros eliminar = new ViewFuncaoRemoverLivros();
    ViewFuncaoEditarLivros editar = new ViewFuncaoEditarLivros();
    ViewFuncaoPesquisarLivros pesquisar = new ViewFuncaoPesquisarLivros();

    public void menuLivros2() {
        int opcao;

        do {
            try {
                System.out.println("## Pesquisar livros por: ##");
                System.out.println("---------------");
                System.out.println("1 - Autor");
                System.out.println("2 - Título");
                System.out.println("3 - ISBN");
                System.out.println("4 - Categoria");
                System.out.println("5 - Menu anterior");

                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1 -> pesquisar.livrosPorAutor(gestor);
                    case 2 -> pesquisar.livroPorTitulo(gestor);
                    case 3 -> pesquisar.livroPorISBN(gestor);
                    case 4 -> pesquisar.livrosPorCategoria(gestor);
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 5);
    }

    public void menuLivros() {
        int opcao;

        do {
            try {
                System.out.println("## Livros ##");
                System.out.println("------------------------");
                System.out.println("1 - Adicionar livros");
                System.out.println("2 - Listar livros");
                System.out.println("3 - Editar livros");
                System.out.println("4 - Remover livros");
                System.out.println("5 - Pesquisar livros");
                System.out.println("6 - Gravar");
                System.out.println("7 - Menu anterior");

                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1 -> adicionar.menuAdicionarLivros(gestor, gestorCategorias, gestorAutores);
                    case 2 -> mostrar.listarTodosOsLivros(gestor);
                    case 3 -> this.menuLivros3();
                    case 4 -> eliminar.eliminarLivroPorTitulo(gestor);
                    case 5 -> this.menuLivros2();
                    case 6 -> gestor.gravarBaseDadosProdutos();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 7);
    }

    public void menuLivros3() {
        int opcao;

        do {

            try {

                System.out.println("## Editar livros por: ##");
                System.out.println("------------------------");
                System.out.println("1 - Titulo");
                System.out.println("2 - Subtitulo");
                System.out.println("3 - Quantidade");
                System.out.println("4 - Autor");
                System.out.println("5 - Numero de páginas");
                System.out.println("6 - Categoria");
                System.out.println("7 - Data de publicacao");
                System.out.println("8 - Faixa etaria");
                System.out.println("9 - Editora");
                System.out.println("10 - Gravar");
                System.out.println("11 - Menu anterior");

                opcao = ler.nextInt();
                ler.nextLine();

                switch (opcao) {
                    case 1 -> editar.editarLivrosPorTitulo(gestor);
                    case 2 -> editar.editarLivrosPorSubTitulo(gestor);
                    case 3 -> editar.editarQuantidade(gestor);
                    case 4 -> editar.editarLivrosPorAutor(gestor);
                    case 5 -> editar.editarNumPaginas(gestor);
                    case 6 -> editar.editarPorCategoria(gestor,gestorCategorias);
                    case 7 -> editar.editarPorData(gestor);
                    case 8 -> editar.editarFaixaEtaria(gestor);
                    case 9 -> editar.editarEditora(gestor);
                    case 10 -> gestor.gravarBaseDadosProdutos();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 11);
    }
}