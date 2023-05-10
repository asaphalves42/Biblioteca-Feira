package View.Reservas;

import Controller.ControllerReservas;
import Controller.ControllerSatisfacao;
import Model.Reserva;
import Model.Satisfacao;
import View.Satisfacao.ViewSatisfacao;

import java.time.LocalDate;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewDevolverLivroReserva {
    Satisfacao satisfacao = new Satisfacao();
    ViewSatisfacao view = new ViewSatisfacao();
    ControllerSatisfacao controller = new ControllerSatisfacao(satisfacao,view);

    public void devolverLivro(ControllerReservas controllerReservas) {
        String idDaReserva;
        int idDoLivro;
        boolean continuar = true;

        while (continuar) {
            idDaReserva = leStr("Qual o ID da reserva que deseja devolver (ou digite 'sair' para sair)?");
            if (idDaReserva.equalsIgnoreCase("sair")) {
                continuar = false;
                continue;
            }

            Reserva reserva = controllerReservas.pesquisarReservaPorId(idDaReserva);
            if (reserva != null) {
                System.out.println(reserva);
            } else {
                System.out.println("Reserva não encontrada");
                System.out.println(" ");
                continue;
            }

            idDoLivro = leInt("Qual o ID do livro que deseja devolver?");

            LocalDate dataDeDevolucao = LocalDate.now();

            controllerReservas.devolverLivro(idDaReserva, idDoLivro, dataDeDevolucao);


            String resposta = leStr("Deseja responder a um formulário de devolução do livro? (S/N)");
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                controller.executar(reserva);
            }

        }
            System.out.println("Livro devolvido com sucesso!");
            System.out.println(" ");
        }
    }


