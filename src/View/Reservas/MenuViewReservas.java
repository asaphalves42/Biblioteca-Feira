package View.Reservas;

import Controller.ControllerReservas;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewReservas {
    ControllerReservas gerirReservas = new ControllerReservas();
    ViewEfetuarReserva efetuar = new ViewEfetuarReserva();
    ViewEditarReserva editar = new ViewEditarReserva();
    ViewListarReserva listar = new ViewListarReserva();
    ViewCancelarReserva cancelar = new ViewCancelarReserva();
    ViewPesquisarReservaPorId pesquisar = new ViewPesquisarReservaPorId();
    ViewDevolverProdutoReserva devolver = new ViewDevolverProdutoReserva();

    public void menuReservas() {
        int opcao;

        do {
            try {


                System.out.println("## Reservas ##");
                System.out.println("---------------");
                System.out.println("1 - Efetuar reserva");
                System.out.println("2 - Devolução");
                System.out.println("3 - Listar reservas");
                System.out.println("4 - Cancelar reservas");
                System.out.println("5 - Editar reserva");
                System.out.println("6 - Pesquisar reserva");
                System.out.println("7 - Gravar");
                System.out.println("8 - Menu anterior");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1 -> this.menuReservas2();
                    case 2 -> devolver.devolverProduto(gerirReservas);
                    case 3 -> listar.listarTodasAsReservas(gerirReservas);
                    case 4 -> cancelar.cancelarReserva(gerirReservas);
                    case 5 -> editar.editarReserva(gerirReservas);
                    case 6 -> pesquisar.pesquisarReservaPorId(gerirReservas);
                    case 7 -> gerirReservas.gravarReservasParaFicheiro();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 8);
    }

    public void menuReservas2() {
        int opcao;

        do {
            try {


                System.out.println("## Reservas ##");
                System.out.println("---------------");
                System.out.println("1 - Livros");
                System.out.println("2 - CD´s");
                System.out.println("3 - Menu anterior");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1:
                        efetuar.efetuarReservaLivros(gerirReservas);
                        break;
                    case 2:
                        //efetuarReservas CD´s
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
