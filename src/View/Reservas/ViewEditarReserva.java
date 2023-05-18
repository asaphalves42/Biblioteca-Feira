package View.Reservas;

import Controller.ControllerReservas;
import Model.Reserva;

import static Controller.ControllerReservas.reservas;
import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewEditarReserva {
    public void editarReserva(ControllerReservas gestorReserva) {

        System.out.println("Caso pretenda sair, digite 'sair'");
        String idReserva = leStr("Insira o Id da reserva que pretende editar:");
        Reserva editReservas = gestorReserva.pesquisarReservaPorId(idReserva);

        if (editReservas == null) {
            System.out.println("Reserva não encontrada!");
            System.out.println(" ");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }

        int idLivro = leInt("Insira o ID do livro que pretende editar:");

        if (String.valueOf(idLivro).equalsIgnoreCase("sair")) {
            return; // Retorna ao menu anterior
        }

        int novoLivro = leInt("Insira o ID do novo livro:");

        if (String.valueOf(novoLivro).equalsIgnoreCase("sair")) {
            return; // Retorna ao menu anterior
        }
        boolean editado = gestorReserva.editarReservaLivro(idLivro, novoLivro);

        if (editado) {
            System.out.println("Reserva editada com sucesso!");
            System.out.println(" ");
        } else {
            System.out.println("Reserva não editada!");
            System.out.println(" ");
        }
    }

}


