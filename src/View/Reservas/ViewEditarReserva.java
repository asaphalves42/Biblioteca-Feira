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

        int idProduto = leInt("Insira o ID produto que pretende editar:");

        if (String.valueOf(idProduto).equalsIgnoreCase("sair")) {
            return; // Retorna ao menu anterior
        }

        int novoProduto = leInt("Insira o ID do novo produto:");

        if (String.valueOf(novoProduto).equalsIgnoreCase("sair")) {
            return; // Retorna ao menu anterior
        }
        boolean editado = gestorReserva.editarReservaLivro(novoProduto, novoProduto);

        if (editado) {
            System.out.println("Reserva editada com sucesso!");
            System.out.println(" ");
        } else {
            System.out.println("Reserva não editada!");
            System.out.println(" ");
        }
    }

}


