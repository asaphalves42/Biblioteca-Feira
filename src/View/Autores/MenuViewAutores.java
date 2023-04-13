package View.Autores;

import Controller.ControllerAutores;
import View.ViewAplicacao;

import static Utilidades.Leitura.ler;

public class MenuViewAutores {
    ControllerAutores gestor = new ControllerAutores();
    ViewFuncaoAdicionarAutor adicionar = new ViewFuncaoAdicionarAutor();
    ViewFuncaoListarAutores listar = new ViewFuncaoListarAutores();
    ViewFuncaoEditarAutor editar = new ViewFuncaoEditarAutor();
    ViewFuncaoRemoverAutor remover = new ViewFuncaoRemoverAutor();
    ViewFuncaoPesquisarAutor pesquisar = new ViewFuncaoPesquisarAutor();
    ViewAplicacao app = new ViewAplicacao();
    public void menuAutores() {
        gestor.lerAutorDeFicheiro();
        int opcao;

        do {

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
                case 1:
                    adicionar.menuAdicionarAutores(gestor);
                    break;
                case 2:
                    listar.listarTodosOsAutores(gestor);
                    break;
                case 3:
                    menuPesquisarAutores();
                    break;
                case 4:
                    editar.editarAutor(gestor);
                    break;
                case 5:
                    remover.removerAutorPorNome(gestor);
                    break;
                case 6:
                    gestor.gravarAutorParaFicheiro();
                    break;
                case 7:
                    app.menuPrincipal();
                    break;
            }

        } while (opcao != 5);

    }

    public void menuPesquisarAutores() {

        int opcao;

        do {
            System.out.println("## Pesquisar autor por: ##");
            System.out.println("---------------");
            System.out.println("1 - Id");
            System.out.println("2 - Nome");
            System.out.println("3 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    pesquisar.pesquisarAutorPorId(gestor);
                    break;
                case 2:
                    pesquisar.pesquisarAutorPorNome(gestor);
                    break;
                case 3:
                    this.menuAutores();
                    break;
            }
        } while (opcao !=3);
    }

}
