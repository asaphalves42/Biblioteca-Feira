package View.Reservas;

import Controller.ControllerProdutos;
import Controller.ControllerReservas;
import Controller.ControllerSocios;
import Model.Reserva;

import java.util.InputMismatchException;

import static Utilidades.Leitura.*;

public class ViewEditarReserva {
    public void editarReserva(ControllerReservas gestorReserva, ControllerProdutos gestorProdutos, ControllerSocios gestorSocios) {

        try {

            ViewEfetuarReservaLivro efetuarReservaLivro = new ViewEfetuarReservaLivro();
            ViewEfetuarReservaCD efetuarReservaCD = new ViewEfetuarReservaCD();

            System.out.println("Caso pretenda sair, digite 'sair'.");
            String idReserva = leStr("Insira o ID da reserva que pretende editar:");
            if (idReserva.equalsIgnoreCase("sair")) {
                return;
            }
            Reserva editReserva = gestorReserva.pesquisarReservaPorId(idReserva);

            if (editReserva == null) {
                System.out.println("Reserva não encontrada!");
                System.out.println();
            } else {
                System.out.println(editReserva);
            }

            int idProduto = leInt("Insira o ID do produto que pretende trocar (ou 0 se pretende sair):");

            if (idProduto == 0) {
                return;
            }
            boolean devolvido = gestorReserva.devolverProduto(idReserva, idProduto);

            if (devolvido) {
                System.out.println("Qual o tipo de produto que pretende adicionar:\n");
                int opcao;
                do {
                    try {
                        System.out.println("1 - Livros");
                        System.out.println("2 - CDs");
                        System.out.println("3 - Menu anterior");

                        opcao = ler.nextInt();

                        switch (opcao) {
                            case 1 ->
                                    efetuarReservaLivro.efetuarReserva(gestorReserva, gestorProdutos, gestorSocios, editReserva.getSocio());
                            case 2 ->
                                    efetuarReservaCD.efetuarReserva(gestorReserva, gestorProdutos, gestorSocios, editReserva.getSocio());
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, insira uma opção válida numérica.");
                        opcao = 0;
                        ler.nextLine();
                    }
                } while (opcao != 3);
            } else {
                System.out.println("Problema ao devolver o produto.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
