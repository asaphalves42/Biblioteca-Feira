 package View;

import Controller.ControllerLogin;
import Controller.LerEgravarFicheirosLivros;
import View.ViewLogin;
import Model.Livro;
import static Utilidades.Leitura.*;
import ViewLivros.MenuViewLivros;
import java.util.ArrayList;

public class Aplicacao {
    LerEgravarFicheirosLivros lerFicheiros = new LerEgravarFicheirosLivros();

    public Aplicacao() {
        controllerLogin = new ControllerLogin(new ViewLogin());
    }
    private ControllerLogin controllerLogin;


    public void Iniciar() {
        ArrayList<Livro> livros = lerFicheiros.lerFicheiros();
        System.out.println("Bem vindo a biblioteca municipal de Santa Maria da Feira");
        System.out.println(" ");
        // Iniciar o sistema
        mensagemUtilizadorParaRegisto();
        menuPrincipal(livros);

        // Criar instância do ControllerLogin
        controllerLogin = new ControllerLogin(new ViewLogin());

    }

    public void mensagemUtilizadorParaRegisto() {
        int opcao;

        do {

            System.out.println("Se ja estas cadastrado no sistema, selecione a opcao 1 para efetuar o login");
            System.out.println("1 - Login");
            System.out.println("Se não, efetue o registo!");
            System.out.println("2 - Efetuar registo");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1:controllerLogin = new ControllerLogin(new ViewLogin());
                    boolean loginSucesso = controllerLogin.iniciar();
                    if (loginSucesso) {
                        menuPrincipal(lerFicheiros.lerFicheiros());
                    }
                    break;
                case 2:
                    controllerLogin.registar();

                    break;
                case 3://sair
                    break;
            }

        } while (opcao != 3);
    }

    public void menuPrincipal(ArrayList<Livro> livros) {
        int opcao;
        do {
            System.out.println("## Menu principal ##");
            System.out.println("Selecione uma opcao:");
            System.out.println("1 - Livros");
            System.out.println("2 - Autores");
            System.out.println("3 - Reservas");
            System.out.println("4 - Sócios");
            System.out.println("5 - Fechar");

            opcao = ler.nextInt();


            switch (opcao) {
                case 1:
                    MenuViewLivros mostrarMenu = new MenuViewLivros();
                    mostrarMenu.menuLivros(livros);
                    break;
                case 2:
                    //menuAutores();
                    break;
                case 3:
                    //menuReservas();
                    break;
                case 4:
                    //menuSocios();
                    break;
                case 5://fechar/guardar ficheiros
                    lerFicheiros.gravarFicheiroLivros(livros);
                    break;
            }

        } while (opcao != 5);
    }


}
