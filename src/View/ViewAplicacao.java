package View;


import Controller.*;
import Model.TipoUtilizador;
import Utilidades.MensagemBoasVindas;
import View.Autores.MenuViewAutores;
import View.CD.MenuViewCD;
import View.Categoria.MenuViewCategoria;
import View.Consultas.ViewConsultarJornal;
import View.Funcionario.MenuViewRegistarFuncionario;
import View.Jornal.MenuViewJornais;
import View.Livros.MenuViewLivros;
import View.Login.ViewLogin;
import View.Reservas.MenuViewReservas;
import View.Revista.MenuViewRevistas;
import View.Socios.MenuViewSocios;

import java.sql.SQLException;
import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class ViewAplicacao {
    public ViewAplicacao() {
    }

    ControllerAutores lerEgravarAutores;
    ControllerProdutos lerEgravarProdutos;
    ControllerSocios lerEgravarSocios;
    ControllerCategoria lerEgravarCategoria;
    ControllerReservas lerEGravarReservas;
    ControllerLogin lerUtilizadorDaBaseDados;
    ViewLogin viewLogin = new ViewLogin();

    public void Iniciar() {

        //iniciar controllers
        lerUtilizadorDaBaseDados = new ControllerLogin();
        lerEgravarAutores = new ControllerAutores();
        lerEgravarSocios = new ControllerSocios();
        lerEgravarCategoria = new ControllerCategoria();
        lerEgravarProdutos = new ControllerProdutos(lerEgravarAutores, lerEgravarCategoria);
        lerEGravarReservas = new ControllerReservas(lerEgravarSocios, lerEgravarProdutos);

        /*
        Leitura base de dados ficheiros

        lerSuperAdministradorDeFicheiro.lerSuperAdministradorDeFicheiro();
        lerAdministradorDeFicheiro.lerAdministradorDeFicheiro();
        lerUtilizadorDeFicheiro.lerUtilizadorDeFicheiro();
        lerEgravarCategoria.lerFicheiroCategoria();
        lerEgravarAutores.lerAutorDeFicheiro();
        lerEgravarProdutos.lerProdutosDeFicheiro();
        lerEgravarSocios.lerSociosDoFicheiro();
        lerEGravarReservas.lerReservaFicheiro();

       /*

        /*
        Leitura base de dados SQL
         */

        lerEgravarCategoria.lerBaseDadosCategoria();
        lerEgravarAutores.lerAutorDeBaseDados();
        lerEgravarProdutos.lerBaseDadosProdutos();
        lerEgravarSocios.lerSociosDeBaseDados();
        lerEGravarReservas.lerReservasDeBaseDados();
        lerUtilizadorDaBaseDados.lerUtilizadoresDaBaseDeDados();


        MensagemBoasVindas.textoInicial();
        MensagemBoasVindas.mensagemBoasVindas();


        // Iniciar o sistema

        menuLogin();

    }

    public void menuLogin() {

        int opcao;

        do {
            System.out.println("## Login ##");
            System.out.println("------------------------");

            System.out.println("1 - Login");
            System.out.println("2 - Sair ");

            try {

                opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1 -> {
                        TipoUtilizador tipoUtilizador = viewLogin.verificarLogin();

                        if (tipoUtilizador == TipoUtilizador.Administrador) {
                            menuAdm();
                        } else if (tipoUtilizador == TipoUtilizador.Bibliotecario) {
                            menuPrincipal();
                        } else if (tipoUtilizador == TipoUtilizador.Socio) {
                            menuSocio();
                        } else if (tipoUtilizador == TipoUtilizador.Default) {
                            System.out.println("Erro ao realizar login!\n");
                        }
                    }
                    case 2 -> System.exit(0);
                    default -> System.out.println("Por favor, insira uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } while (opcao != 3);
    }

    public void menuSocio() {

        int opcao;

        do {
            System.out.println("## Sócios ##");
            System.out.println("------------------------");

            System.out.println("1 - Consultar reservas");
            System.out.println("2 - Consultar produtos");
            System.out.println("3 - Sair ");

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:// Consultar reservas
                        break;
                    case 2:
                        menuSocio2();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Por favor, insira uma opção válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 4);
    }

    public void menuSocio2() {

        int opcao;

        do {
            System.out.println("## Consultar ##");
            System.out.println("------------------------");

            System.out.println("1 - Jornal");
            System.out.println("2 - Revistas");
            System.out.println("4 - Sair ");

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        ViewConsultarJornal consultarJornal = new ViewConsultarJornal();
                        consultarJornal.consultarJornal(lerEgravarProdutos);
                        break;
                    case 2:
                        //consultar revistas
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Por favor, insira uma opção válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 4);
    }


    public void menuAdm() {

        int opcao;

        do {
            try {
                System.out.println("## Menu principal ##");
                System.out.println("Selecione uma opcao:");
                System.out.println("1 - Livros");
                System.out.println("2 - CD'S");
                System.out.println("3 - Jornais");
                System.out.println("4 - Revistas");
                System.out.println("5 - Categorias");
                System.out.println("6 - Autores");
                System.out.println("7 - Reservas");
                System.out.println("8 - Sócios");
                System.out.println("9 - Registar funcionários");
                System.out.println("10 - Sair");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1 -> {
                        MenuViewLivros mostrarMenu = new MenuViewLivros(lerEgravarProdutos, lerEgravarCategoria, lerEgravarAutores);
                        mostrarMenu.menuLivros();
                    }
                    case 2 -> {
                        MenuViewCD mostrarMenu = new MenuViewCD(lerEgravarProdutos, lerEgravarCategoria, lerEgravarAutores);
                        mostrarMenu.menuCds();
                    }
                    case 3 -> {
                        MenuViewJornais mostrarMenu = new MenuViewJornais(lerEgravarProdutos);
                        mostrarMenu.menuJornais();
                    }
                    case 4 -> {
                        MenuViewRevistas mostrarMenu = new MenuViewRevistas(lerEgravarProdutos);
                        mostrarMenu.menuRevistas();
                    }
                    case 5 -> {
                        MenuViewCategoria mostrarMenu = new MenuViewCategoria();
                        mostrarMenu.menuCategoria();
                    }
                    case 6 -> {
                        MenuViewAutores mostraMenu = new MenuViewAutores();
                        mostraMenu.menuAutores();
                    }
                    case 7 -> {
                        MenuViewReservas mostrarMenuReservas = new MenuViewReservas(lerEGravarReservas, lerEgravarProdutos, lerEgravarSocios);
                        mostrarMenuReservas.menuReservas();
                    }
                    case 8 -> {
                        MenuViewSocios menuSocios = new MenuViewSocios();
                        menuSocios.menuSocios();
                    }
                    case 9 -> {
                        MenuViewRegistarFuncionario menuFunc = new MenuViewRegistarFuncionario();
                        menuFunc.menuRegistarFunc(lerUtilizadorDaBaseDados);
                    }

                    case 10 -> {
                        System.exit(0);
                    }

                    default -> System.out.println("Por favor, insira uma opção válida numérica.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }

        } while (opcao != 11);
    }

    public void menuPrincipal() {

        int opcao;

        do {
            try {
                System.out.println("## Menu principal ##");
                System.out.println("Selecione uma opcao:");
                System.out.println("1 - Livros");
                System.out.println("2 - CD'S");
                System.out.println("3 - Jornais");
                System.out.println("4 - Revistas");
                System.out.println("5 - Categorias");
                System.out.println("6 - Autores");
                System.out.println("7 - Reservas");
                System.out.println("8 - Sócios");
                System.out.println("9 - Sair");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1 -> {
                        MenuViewLivros mostrarMenu = new MenuViewLivros(lerEgravarProdutos, lerEgravarCategoria, lerEgravarAutores);
                        mostrarMenu.menuLivros();
                    }
                    case 2 -> {
                        MenuViewCD mostrarMenu = new MenuViewCD(lerEgravarProdutos, lerEgravarCategoria, lerEgravarAutores);
                        mostrarMenu.menuCds();
                    }
                    case 3 -> {
                        MenuViewJornais mostrarMenu = new MenuViewJornais(lerEgravarProdutos);
                        mostrarMenu.menuJornais();
                    }
                    case 4 -> {
                        MenuViewRevistas mostrarMenu = new MenuViewRevistas(lerEgravarProdutos);
                        mostrarMenu.menuRevistas();
                    }
                    case 5 -> {
                        MenuViewCategoria mostrarMenu = new MenuViewCategoria();
                        mostrarMenu.menuCategoria();
                    }
                    case 6 -> {
                        MenuViewAutores mostraMenu = new MenuViewAutores();
                        mostraMenu.menuAutores();
                    }
                    case 7 -> {
                        MenuViewReservas mostrarMenuReservas = new MenuViewReservas(lerEGravarReservas, lerEgravarProdutos, lerEgravarSocios);
                        mostrarMenuReservas.menuReservas();
                    }
                    case 8 -> {
                        MenuViewSocios menuSocios = new MenuViewSocios();
                        menuSocios.menuSocios();
                    }
                    case 9 -> {
                        System.exit(0);
                    }

                    default -> System.out.println("Por favor, insira uma opção válida numérica.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }

        } while (opcao != 10);
    }


}
