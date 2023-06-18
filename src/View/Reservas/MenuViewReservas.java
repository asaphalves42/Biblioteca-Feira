package View.Reservas;

import Controller.ControllerProdutos;
import Controller.ControllerReservas;
import Controller.ControllerSocios;

import java.util.InputMismatchException;

import static Utilidades.Leitura.ler;

public class MenuViewReservas {
    public MenuViewReservas(ControllerReservas controllerReservas, ControllerProdutos controllerProdutos, ControllerSocios controllerSocios) {
        this.gerirReservas = controllerReservas;
        this.gerirProdutos = controllerProdutos;
        this.gerirSocios = controllerSocios;
    }

    ControllerReservas gerirReservas;
    ControllerProdutos gerirProdutos;
    ControllerSocios gerirSocios;
    ViewEfetuarReservaLivro efetuarLivro = new ViewEfetuarReservaLivro();
    ViewEfetuarReservaCD efetuarCD = new ViewEfetuarReservaCD();
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
                System.out.println("7 - Menu anterior");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1 -> this.menuReservas2();
                    case 2 -> devolver.devolverProduto(gerirReservas);
                    case 3 -> listar.listarTodasAsReservas(gerirReservas);
                    case 4 -> cancelar.cancelarReserva(gerirReservas);
                    case 5 -> editar.editarReserva(gerirReservas, gerirProdutos, gerirSocios);
                    case 6 -> pesquisar.pesquisarReservaPorId(gerirReservas);

                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 7);
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
                    case 1 -> efetuarLivro.efetuarReserva(gerirReservas, gerirProdutos, gerirSocios, null);
                    case 2 -> efetuarCD.efetuarReserva(gerirReservas, gerirProdutos, gerirSocios, null);
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma opção válida numérica.");
                opcao = 0;
                ler.nextLine();
            }
        } while (opcao != 3);
    }
}
