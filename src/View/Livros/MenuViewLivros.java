package View.Livros;

import Controller.ControllerLivros;
import Controller.ControllerLivrosEautores;


import static Utilidades.Leitura.ler;

public class MenuViewLivros {
    ControllerLivros gestor = new ControllerLivros();
    ControllerLivrosEautores gestorAutor = new ControllerLivrosEautores();
    ViewAdicionarLivrosEautores adicionar = new ViewAdicionarLivrosEautores();
    ViewFuncaoListarLivros mostrar = new ViewFuncaoListarLivros();
    ViewFuncaoRemoverLivros eliminar = new ViewFuncaoRemoverLivros();
    ViewFuncaoEditarLivros editar = new ViewFuncaoEditarLivros();
    ViewFuncaoPesquisarLivros pesquisar = new ViewFuncaoPesquisarLivros();

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
                case 1:
                    pesquisar.livrosPorAutor(gestor);
                    break;
                case 2:
                    pesquisar.livroPorTitulo(gestor);
                    break;
                case 3:pesquisar.livroPorISBN(gestor);
                    break;
                case 4:pesquisar.livrosPorCategoria(gestor);
                    break;
                case 5:
                    this.menuLivros();
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
            System.out.println("6 - Gravar");
            System.out.println("7 - Menu anterior");

            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    adicionar.menuAdicionarLivros(gestorAutor);
                    break;
                case 2:
                    mostrar.listarTodosOsLivros(gestor);
                    break;
                case 3:
                    this.menuLivros3();
                    break;
                case 4:
                    eliminar.eliminarLivroPorTitulo(gestor);
                    break;
                case 5:
                    this.menuLivros2();
                    break;
                case 6:
                    gestor.gravarLivrosParaFicheiro();
                    break;
            }

        } while (opcao != 7);

    }

    public void menuLivros3() {
        int opcao;

        do {

            System.out.println("## Editar livros por: ##");
            System.out.println("------------------------");
            System.out.println("1 - Todos os campos");
            System.out.println("2 - Titulo");
            System.out.println("3 - Subtitulo");
            System.out.println("4 - Quantidade");
            System.out.println("5 - Autor");
            System.out.println("6 - Numero de páginas");
            System.out.println("7 - Categoria");
            System.out.println("8 - Data de publicacao");
            System.out.println("9 - Faixa etaria");
            System.out.println("10 - Editora");
            System.out.println("11 - ISBN");
            System.out.println("12 - Gravar");
            System.out.println("13 - Menu anterior");

            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:editar.editarLivros(gestor);
                    break;
                case 2:editar.editarLivrosPorTitulo(gestor);
                    break;
                case 3:editar.editarLivrosPorSubTitulo(gestor);
                    break;
                case 4:editar.editarQuantidade(gestor);
                    break;
                case 5:editar.editarLivrosPorAutor(gestor);
                    break;
                case 6:editar.editarNumPaginas(gestor);
                    break;
                case 7:editar.editarPorCategoria(gestor);
                    break;
                case 8:editar.editarPorData(gestor);
                    break;
                case 9:editar.editarFaixaEtaria(gestor);
                    break;
                case 10:editar.editarEditora(gestor);
                    break;
                case 11:editar.editarISBN(gestor);
                    break;
                case 12: gestor.gravarLivrosParaFicheiro();
                    break;
            }
        } while (opcao != 13);


    }
}