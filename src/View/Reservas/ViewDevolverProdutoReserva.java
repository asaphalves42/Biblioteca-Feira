package View.Reservas;

import Controller.ControllerReservas;
import Model.Reserva;
import View.Satisfacao.ViewSatisfacao;

import java.time.LocalDate;

import static Utilidades.Leitura.leStr;

public class ViewDevolverProdutoReserva {

    ViewSatisfacao view = new ViewSatisfacao();

    public void devolverProduto(ControllerReservas controllerReservas) {

        try {

            String idDaReserva;
            while (true) {
                idDaReserva = leStr("Qual o ID da reserva que deseja devolver (ou digite 'sair' para sair)?");
                if (idDaReserva.equalsIgnoreCase("sair")) {

                    break; // Sai do loop while
                }

                Reserva reserva = controllerReservas.pesquisarReservaPorId(idDaReserva);
                if (reserva != null) {
                    System.out.println(reserva);
                    LocalDate dataDeDevolucao = LocalDate.now();

                    boolean devolvido = controllerReservas.devolverReserva(idDaReserva, dataDeDevolucao);

                    String resposta = leStr("Deseja responder a um formulário de devolução do livro? (S/N)");
                    if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                        view.obterSatisfacao(controllerReservas, idDaReserva);

                    }

                    if (devolvido) {
                        System.out.println("Devolvido com sucesso!");
                        System.out.println(" ");
                    } else {
                        System.out.println("Reserva não encontrada");
                        System.out.println(" ");
                    }
                }
            }


        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}



