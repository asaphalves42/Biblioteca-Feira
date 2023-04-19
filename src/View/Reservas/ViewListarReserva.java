package View.Reservas;

import Controller.ControllerReservas;
import Model.Reserva;

import java.util.ArrayList;

public class ViewListarReserva {
    public void listarTodosOsLivros(ControllerReservas gerirReservas) {

        ArrayList<Reserva> livrosReservadosListados = gerirReservas.listarReservas();

        if(livrosReservadosListados.isEmpty()){
            System.out.println("Nao existem livros reservados!");
            System.out.println(" ");
        } else{
            for(Reserva livroReservado : livrosReservadosListados){
                System.out.println(livroReservado.toString());
            }
        }
    }
}
