package View;


import Controller.*;
import Utilidades.MensagemBoasVindas;
import View.Autores.MenuViewAutores;
import View.CD.MenuViewCD;
import View.Categoria.MenuViewCategoria;
import View.Livros.MenuViewLivros;


import View.Login.*;
import View.Reservas.MenuViewReservas;
import View.Socios.MenuViewSocios;
import View.SuperAdministrador.ViewSuperAdministrador;

import java.util.InputMismatchException;

import static Utilidades.Leitura.*;
import static Utilidades.Leitura.leStr;

public class ViewAplicacao {
    public ViewAplicacao() {

        controllerLogin = new ControllerLogin();
        realizarLogin = new ViewFuncaoRealizarLogin(controllerLogin);
        controlleradministrador=new ControllerAdministrador();

        controllersuperadministrador = new ControllerSuperAdministrador();
        loginadministrador =new ViewLoginAdministrador(controlleradministrador);
        loginsuperadministrador = new ViewLoginSuperAdministrador(controllersuperadministrador);
    }
    private ControllerLogin controllerLogin;
    private ControllerAdministrador controlleradministrador;
    private ControllerSuperAdministrador controllersuperadministrador;
    private ViewFuncaoRealizarLogin realizarLogin;
    private ViewLoginAdministrador loginadministrador;
    private ViewLoginSuperAdministrador loginsuperadministrador;
    ControllerAutores lerEgravarAutores = new ControllerAutores();
    ControllerProdutos lerEgravarProdutos = new ControllerProdutos(lerEgravarAutores);
    ControllerSocios lerEgravarSocios = new ControllerSocios();
    ControllerCategoria lerEgravarCategoria = new ControllerCategoria();
    ControllerReservas lerEGravarReservas = new ControllerReservas(lerEgravarSocios,lerEgravarProdutos);
    ControllerLogin lerUtilizadorDeFicheiro=new ControllerLogin();
    ControllerAdministrador lerAdministradorDeFicheiro = new ControllerAdministrador();
    ControllerSuperAdministrador lerSuperAdministradorDeFicheiro= new ControllerSuperAdministrador();

    public void Iniciar() {

        /*

        Ler os ficheiros txt...

         */
        lerSuperAdministradorDeFicheiro.lerSuperAdministradorDeFicheiro();
        lerAdministradorDeFicheiro.lerAdministradorDeFicheiro();
        lerEgravarAutores.lerAutorDeFicheiro();
        lerEgravarCategoria.lerFicheiroCategoria();
        lerEgravarProdutos.lerProdutosDeFicheiro();
        lerEgravarSocios.lerSociosDoFicheiro();
        lerEGravarReservas.lerLivrosDeFicheiroReserva();
        lerUtilizadorDeFicheiro.lerUtilizadorDeFicheiro();

        /*
        Ler base de dados

         */


        //lerEgravarAutores.lerAutorDeBaseDados();
        //lerEgravarCategoria.lerBaseDadosCategoria();

        MensagemBoasVindas.textoInicial();
        MensagemBoasVindas.mensagemBoasVindas();


        // Iniciar o sistema

        menuInicialLogin();

    }
    public void menuInicialLogin() {
        int opcao;

        do {
            System.out.println("## Que funções deseja desempenhar? ##");
            System.out.println("------------------------");
            System.out.println("1 - Super Administrador");
            System.out.println("2 - Sub - Administrador");
            System.out.println("3 - Bibliotecário");
            System.out.println("4 - Sair");

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        boolean loginSuperBemSucedido = loginsuperadministrador.realizarLogin();
                        if (loginSuperBemSucedido) {
                            ViewSuperAdministrador superadministrador = new ViewSuperAdministrador();
                            superadministrador.menuSuperAdministrador();
                        }else {
                            System.out.println("Credenciais inválidas. Por favor, tente novamente.");
                        }
                        break;
                    case 2:

                        boolean loginBemSucedido = loginadministrador.realizarLogin();
                        if (loginBemSucedido) {
                            menuAdministracao();
                        } else {
                            System.out.println("Credenciais inválidas. Por favor, tente novamente.");
                        }
                        break;

                    case 3:
                        boolean loginbemsucedidobiliotecario = realizarLogin.realizarLogin();
                        if(loginbemsucedidobiliotecario){
                            menuPrincipal();
                        }else {
                            System.out.println("Credenciais inválidas. Por favor, tente novamente.");
                        }

                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Por favor, insira uma opção válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 5);
    }

    public void menuAdministracao() {

        int opcao;

        do {
            System.out.println("## Sistema de Administração ##");
            System.out.println("------------------------");
            System.out.println("1 - Registar Utilizador");
            System.out.println("2 - Eliminar Utilizador");
            System.out.println("3 - Aceder à Libraria");
            System.out.println("4 - Sair");

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        ViewFuncaoRegistarUtilizador registarutilizador = new ViewFuncaoRegistarUtilizador();
                        registarutilizador.registarUtilizador();
                        break;
                    case 2:
                        ViewFuncaoRemoverUtilizador removerutilizador = new ViewFuncaoRemoverUtilizador();
                        removerutilizador.apagarUtilizador();
                        break;
                    case 3:
                        menuPrincipal();
                    case 4:
                        String resposta = leStr("Deseja guardar os utilizadores registados  ?");
                        if(resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")){
                            controllerLogin.gravarUtilizadorParaFicheiro();
                            menuInicialLogin();

                        }else{
                            menuInicialLogin();
                        }




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
        } while (opcao != 5);
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
