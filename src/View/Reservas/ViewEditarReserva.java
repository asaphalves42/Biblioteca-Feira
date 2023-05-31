package View.Reservas;

import Controller.ControllerProdutos;
import Controller.ControllerReservas;
import Controller.ControllerSocios;
import Model.Reserva;

import java.util.InputMismatchException;

import static Controller.ControllerReservas.reservas;
import static Utilidades.Leitura.*;

public class ViewEditarReserva {
    public void editarReserva(ControllerReservas gestorReserva, ControllerProdutos gestorProdutos, ControllerSocios gestorSocios) {

        ViewEfetuarReservaLivro efetuarReservaLivro = new ViewEfetuarReservaLivro();
        ViewEfetuarReservaCD efetuarReservaCD = new ViewEfetuarReservaCD();

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

        int idProduto = leInt("Insira o ID produto que pretende trocar:");
        boolean devolvido = gestorReserva.devolverProduto(idReserva, idProduto);

        if (devolvido)
        {
            System.out.println("Qual o tipo de produto que pretende adicionar:\n");
            int opcao;
            do {
                try {

                    System.out.println("1 - Livros");
                    System.out.println("2 - CD´s");
                    System.out.println("3 - Menu anterior");

                    opcao = ler.nextInt();

                    switch (opcao) {
                        case 1 -> efetuarReservaLivro.efetuarReserva(gestorReserva, gestorProdutos, gestorSocios, editReservas.getSocio());
                        case 2 -> efetuarReservaCD.efetuarReserva(gestorReserva, gestorProdutos, gestorSocios, editReservas.getSocio());
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira uma opção válida numérica.");
                    opcao = 0;
                    ler.nextLine();
                }
            } while (opcao != 3);
        } else {
            System.out.println("Problema ao devolver produto.");
        }

        if (String.valueOf(idProduto).equalsIgnoreCase("sair")) {
            return; // Retorna ao menu anterior
        }


    }

}
