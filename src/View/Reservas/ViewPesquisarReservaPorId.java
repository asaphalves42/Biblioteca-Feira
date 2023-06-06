package View.Reservas;

import Controller.ControllerReservas;
import Model.Reserva;

import static Utilidades.Leitura.leStr;

public class ViewPesquisarReservaPorId {
    public void pesquisarReservaPorId(ControllerReservas gestorReservas){

        String idInserido = leStr("Introduza o id da reserva (ou sair se quer sair): ");
        if (idInserido.equalsIgnoreCase("sair")) {
            return;
        }

        Reserva reserva = gestorReservas.pesquisarReservaPorId(idInserido);

        if(reserva== null){
            System.out.println("Reserva não encontrada!");
            System.out.println(" ");
        }else{
            System.out.println(reserva);
        }

    }
}
