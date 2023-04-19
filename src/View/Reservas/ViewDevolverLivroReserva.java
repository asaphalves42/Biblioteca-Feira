package View.Reservas;

import Controller.ControllerReservas;
import Model.Reserva;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewDevolverLivroReserva {
    public void devolverLivro(ControllerReservas controllerReservas) {

        String idDaReserva = leStr("Qual o ID da reserva que deseja devolver?");
        Reserva reserva = controllerReservas.pesquisarReservaPorId(idDaReserva);
        if(reserva != null){
            System.out.println(reserva);
        }else{
            System.out.println("Reserva não encontrada");
            System.out.println(" ");
        }

        int idDoLivro = leInt("Qual o ID do livro que deseja devolver?");


        controllerReservas.devolverLivro(idDaReserva, idDoLivro);

        System.out.println("Livro devolvido com sucesso");
        System.out.println(" ");

    }
}

