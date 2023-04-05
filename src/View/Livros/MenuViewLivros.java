package View.Livros;

import Controller.ControllerLivros;
import Model.Livro;
import View.Aplicacao;

import java.util.ArrayList;

import static Utilidades.Leitura.ler;

public class MenuViewLivros {
    ViewFuncaoAdicionarLivros adicionar = new ViewFuncaoAdicionarLivros();
    ViewFuncaoListarLivros mostrar = new ViewFuncaoListarLivros();
    ViewFuncaoRemoverLivros eliminar = new ViewFuncaoRemoverLivros();
    ViewFuncaoEditarLivros editar = new ViewFuncaoEditarLivros();
    ControllerLivros gestor = new ControllerLivros();
    ViewFuncaoPesquisarLivros pesquisar = new ViewFuncaoPesquisarLivros();
    Aplicacao app = new Aplicacao();

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
                case 3:pesquisar.livrosPorISBN(gestor);
                    break;
                case 4:pesquisar.livrosPorCategoria(gestor);
                    break;
                case 5:
                    this.menuLivros(gestor.livros);
                    break;
            }

        } while (opcao != 5);


    }

    public void menuLivros(ArrayList<Livro> livros) {

        int opcao;

        do {
            gestor.livros = livros;
            System.out.println("## Livros ##");
            System.out.println("------------------------");
            System.out.println("1 - Adicionar livros");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Editar livros");
            System.out.println("4 - Remover livros");
            System.out.println("5 - Pesquisar livros");
            System.out.println("6 - Menu anterior");

            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    adicionar.menuAdicionarLivros(gestor);
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
                case 6://sair
                    app.menuPrincipal(gestor.livros);
                    break;
            }

        } while (opcao != 6);

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
            System.out.println("12 - Menu anterior");

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
                case 5:editar.editarAutor(gestor);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;

            }
        } while (opcao != 12);


    }
}