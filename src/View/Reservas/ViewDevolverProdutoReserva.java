package View.Reservas;

import Controller.ControllerReservas;
import Controller.ControllerSatisfacao;
import Model.Reserva;
import Model.Satisfacao;
import Model.Socio;
import View.Satisfacao.ViewSatisfacao;

import java.time.LocalDate;

import static Utilidades.Leitura.leStr;

public class ViewDevolverProdutoReserva {
    Satisfacao satisfacao = new Satisfacao();
    ViewSatisfacao view = new ViewSatisfacao();
    ControllerSatisfacao controller = new ControllerSatisfacao(satisfacao, view);

    public void devolverProduto(ControllerReservas controllerReservas) {
        String idDaReserva;
        while (true) {
            idDaReserva = leStr("Qual o ID da reserva que deseja devolver (ou digite 'sair' para sair)?");
            if (idDaReserva.equalsIgnoreCase("sair")) {

                break; // Sai do loop while
            }

            Reserva reserva = controllerReservas.pesquisarReservaPorId(idDaReserva);
            if (reserva != null) {
                System.out.println(reserva);
                Socio socioDaReserva = reserva.getSocio(); // Obtém o sócio associado à reserva
                LocalDate dataDeDevolucao = LocalDate.now();

                boolean devolvido = controllerReservas.devolverLivro(idDaReserva, dataDeDevolucao, socioDaReserva);

                String resposta = leStr("Deseja responder a um formulário de devolução do livro? (S/N)");
                if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                    controller.executar(reserva);
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
    }
}



