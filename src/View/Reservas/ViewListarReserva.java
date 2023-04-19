package View.Reservas;

import Controller.ControllerReservas;
import Model.Reserva;

import java.util.ArrayList;

public class ViewListarReserva {
    public void listarTodasAsReservas(ControllerReservas gerirReservas) {

        ArrayList<Reserva> livrosReservadosListados = gerirReservas.listarReservas();

        if(livrosReservadosListados.isEmpty()){
            System.out.println("Nao existem reservas!");
            System.out.println(" ");
        } else{
            for(Reserva livroReservado : livrosReservadosListados){
                System.out.println(livroReservado.toString());
            }
        }
    }
}
