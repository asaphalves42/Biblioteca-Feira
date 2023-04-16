package View.Reservas;

import Controller.ControllerLivros;
import Controller.ControllerReservas;
import Model.Livro;
import Model.LivroReservado;

import java.util.ArrayList;

public class ViewListarReserva {
    public void listarTodosOsLivros(ControllerReservas gerirReservas) {

        ArrayList<LivroReservado> livrosReservadosListados = gerirReservas.listarLivrosReservados();

        if(livrosReservadosListados.isEmpty()){
            System.out.println("Nao existem livros reservados!");
            System.out.println(" ");
        } else{
            for(LivroReservado livroReservado : livrosReservadosListados){
                System.out.println(livroReservado.toString());
            }
        }
    }
}
