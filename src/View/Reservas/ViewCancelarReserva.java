package View.Reservas;

import Controller.ControllerReservas;
import Model.Reserva;

import static Utilidades.Leitura.leStr;

public class ViewCancelarReserva {

    public void cancelarReserva(ControllerReservas gestorReserva) {
        try {

            boolean sair = false;
            String idReserva = leStr("Insira o id da reserva a ser cancelada ou sair para sair: ");
            Reserva locReserva = gestorReserva.pesquisarReservaPorId(idReserva);

            if (idReserva.equalsIgnoreCase("sair")) {
                sair = true;
                return;
            }

            if (locReserva == null) {
                System.out.println("Reserva não encontrada!");
                System.out.println(" ");
            } else {

                boolean removido = gestorReserva.cancelarReserva(idReserva);

                if (removido) {
                    System.out.println("Reserva cancelada com sucesso!");
                    System.out.println(" ");

                } else {
                    System.out.println("Erro ao cancelar reserva!");
                    System.out.println(" ");
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
