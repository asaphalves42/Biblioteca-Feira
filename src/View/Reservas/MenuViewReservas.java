package View.Reservas;

import Controller.ControllerReservas;

import static Utilidades.Leitura.ler;

public class MenuViewReservas {
    ControllerReservas gerirReservas = new ControllerReservas();
    ViewEfetuarReserva efetuar = new ViewEfetuarReserva();
    ViewListarReserva listar = new ViewListarReserva();
    ViewPesquisarReservaPorId pesquisar = new ViewPesquisarReservaPorId();
    ViewDevolverLivroReserva devolver = new ViewDevolverLivroReserva();
    public void menuReservas() {
        int opcao;

        do {

            System.out.println("## Reservas ##");
            System.out.println("---------------");
            System.out.println("1 - Efetuar reserva");
            System.out.println("2 - Devolucao");
            System.out.println("3 - Listar reservas");
            System.out.println("4 - Cancelar reservas");
            System.out.println("5 - Editar reserva");
            System.out.println("6 - Pesquisar reserva");
            System.out.println("7 - Gravar");
            System.out.println("8 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    efetuar.efetuarReserva(gerirReservas);
                    break;
                case 2:
                    devolver.devolverLivro(gerirReservas);
                    break;
                case 3:listar.listarTodosOsLivros(gerirReservas);
                    break;
                case 4://cancelar
                    break;
                case 5://editar reserva
                    break;
                case 6:pesquisar.pesquisarReservaPorId(gerirReservas);
                    break;
                case 7:gerirReservas.gravarReservasParaFicheiro();
                    break;
            }

        } while (opcao != 8);

    }
}
