package View.Reservas;

import Controller.ControllerReservas;
import Model.Reserva;

import java.util.ArrayList;

public class ViewListarReserva {
    public void listarTodasAsReservas(ControllerReservas gerirReservas) {

        try {
            ArrayList<Reserva> reservasListadas = gerirReservas.listarReservas();

            if(reservasListadas.isEmpty()){
                System.out.println("Nao existem reservas!");
                System.out.println(" ");
            } else{
                for(Reserva reserva : reservasListadas){
                    System.out.println(reserva.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
