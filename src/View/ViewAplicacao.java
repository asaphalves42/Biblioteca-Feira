package View;


import Controller.*;
import Utilidades.MensagemBoasVindas;
import View.Autores.MenuViewAutores;
import View.CD.MenuViewCD;
import View.Categoria.MenuViewCategoria;
import View.Livros.MenuViewLivros;

import View.Login.MenuViewLogin;
import View.Reservas.MenuViewReservas;
import View.Socios.MenuViewSocios;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class ViewAplicacao {
    public ViewAplicacao() {
        //controllerLogin = new ControllerLogin(new ViewLogin());
    }
    private ControllerLogin controllerLogin;
    ControllerAutores lerEgravarAutores = new ControllerAutores();
    ControllerProdutos lerEgravarProdutos = new ControllerProdutos(lerEgravarAutores);
    ControllerSocios lerEgravarSocios = new ControllerSocios();
    ControllerCategoria lerEgravarCategoria = new ControllerCategoria();
    ControllerReservas lerEGravarReservas = new ControllerReservas(lerEgravarSocios,lerEgravarProdutos);
    ControllerLogin lerEgravarUtilizadores = new ControllerLogin();
    MenuViewLogin menulogin = new MenuViewLogin();

    public void Iniciar() {
        //Ler os ficheiros
       // lerEgravarUtilizadores.lerUtilizadorDeFicheiro();
        lerEgravarAutores.lerAutorDeFicheiro();
        lerEgravarProdutos.lerProdutosDeFicheiro();
        lerEgravarSocios.lerSociosDoFicheiro();
        lerEgravarCategoria.lerFicheiroCategoria();
        lerEGravarReservas.lerLivrosDeFicheiroReserva();
        MensagemBoasVindas.textoInicial();
        MensagemBoasVindas.mensagemBoasVindas();


        // Iniciar o sistema

        menulogin.menuUtilizadores();
       // mensagemUtilizadorParaRegisto();
       // menuPrincipal();

        // Criar instância do ControllerLogin
      //  controllerLogin = new ControllerLogin(new ViewLogin());

    }



    public void menuPrincipal() {

        int opcao;

        do {
            try {
                System.out.println("## Menu principal ##");
                System.out.println("Selecione uma opcao:");
                System.out.println("1 - Livros");
                System.out.println("2 - CD'S");
                System.out.println("3 - Categorias");
                System.out.println("4 - Autores");
                System.out.println("5 - Reservas");
                System.out.println("6 - Sócios");
                System.out.println("7 - Fechar e gravar");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1 -> {
                        MenuViewLivros mostrarMenu = new MenuViewLivros();
                        mostrarMenu.menuLivros();
                    }
                    case 2 -> {
                        MenuViewCD mostrarMenu = new MenuViewCD();
                        mostrarMenu.menuCds();
                    }
                    case 3 -> {
                        MenuViewCategoria mostrarMenu = new MenuViewCategoria();
                        mostrarMenu.menuCategoria();
                    }
                    case 4 -> {
                        MenuViewAutores mostraMenu = new MenuViewAutores();
                        mostraMenu.menuAutores();
                    }
                    case 5 -> {
                        MenuViewReservas mostrarMenuReservas = new MenuViewReservas();
                        mostrarMenuReservas.menuReservas();
                    }
                    case 6 -> {
                        MenuViewSocios menuSocios = new MenuViewSocios();
                        menuSocios.menuSocios();
                    }
                    case 7 -> {
                        lerEgravarProdutos.gravarProdutosParaFicheiro();
                        lerEgravarAutores.gravarAutorParaFicheiro();
                        lerEgravarSocios.gravarSociosParaFicheiro();
                        lerEgravarCategoria.gravarFicheiroCategoria();
                        lerEGravarReservas.gravarReservasParaFicheiro();
                        System.exit(0);
                        }

                    default -> System.out.println("Por favor, insira uma opção válida numérica.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }

        } while (opcao != 8);
    }



}
