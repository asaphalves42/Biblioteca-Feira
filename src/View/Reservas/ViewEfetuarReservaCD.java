package View.Reservas;

import Controller.ControllerProdutos;
import Controller.ControllerReservas;
import Controller.ControllerSocios;
import Model.CD;
import Model.Socio;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewEfetuarReservaCD {

    private Socio selecionarSocioExistente(ControllerSocios gerirSocios) {
        Socio socioSelecionado = null;

        while (socioSelecionado == null) {
            ArrayList<Socio> sociosListados = gerirSocios.listarSocio();

            for (Socio socio : sociosListados) {
                System.out.println(socio.toString());
            }

            int numMecanografico = leInt("Insira o número mecanográfico do sócio (ou 0 se quer sair):");

            if (numMecanografico == 0) {
                break;
            }

            boolean numeroCorreto = false;

            for (Socio socio : sociosListados) {
                if (numMecanografico == socio.getNumMecanografico()) {
                    socioSelecionado = socio;
                    numeroCorreto = true;
                    break;
                }
            }

            if (!numeroCorreto) {
                System.out.println("Número mecanográfico incorreto! Tente novamente.");
                System.out.println();
            }
        }

        return socioSelecionado;
    }
    private CD selecionarProdutoDisponivel(ControllerProdutos gerirProdutos) {
        CD cdSelecionado = null;

        while (cdSelecionado == null) {
            for (CD cd : gerirProdutos.listarProdutosCd()) {
                System.out.println(cd.toString());
            }

            String idCDStr = leStr("Insira o ID do CD que deseja reservar (ou 'sair' se quiser sair):");

            if (idCDStr.equalsIgnoreCase("sair")) {
                break; // Sair do loop while
            }

            try {
                int idCD = Integer.parseInt(idCDStr);

                for (CD cd : gerirProdutos.listarProdutosCd()) {
                    if (cd.getId() == idCD) {
                        cdSelecionado = cd;
                        break;
                    }
                }

                if (cdSelecionado == null) {
                    System.out.println("ID do CD inválido! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido! Tente novamente.");
            }
        }

        return cdSelecionado;
    }


    public void efetuarReserva(ControllerReservas gerirReservas, ControllerProdutos gerirProdutos, ControllerSocios gerirSocios, Socio socio) {

        Socio socioSelecionado = socio;
        if (socio == null) {
            socioSelecionado = selecionarSocioExistente(gerirSocios);
        }

        if (socioSelecionado == null) { // se não selecionou nenhum socio ou não foi passado como parametro, então volta a questionar
            efetuarReserva(gerirReservas, gerirProdutos, gerirSocios,null);
        }

        String input = leStr("Se deseja mostrar todos os CD´s insira um ENTER");
        if (input.equalsIgnoreCase("")) {
            for (CD cd : gerirProdutos.listarProdutosCd()) {
                System.out.println(cd);
            }
        }

        boolean continuarReservando = true;

        while (continuarReservando) {

            CD cdSelecionado = selecionarProdutoDisponivel(gerirProdutos);

            LocalDate dataDaReserva = LocalDate.now();

            if (cdSelecionado.getQuantidade() == 0) {
                System.out.println("Não existem mais exemplares desse cd no stock!");
                System.out.println();
            } else {
                boolean sucesso = gerirReservas.efetuarReservaProduto(socioSelecionado, cdSelecionado, dataDaReserva);

                if (sucesso) {
                    System.out.println("CD reservado com sucesso!");
                    System.out.println();
                } else {
                    System.out.println("Ocorreu um erro ao efetuar reserva, número máximo de produtos reservados!");
                    System.out.println();
                }

                String continuar = leStr("Deseja continuar reservar outro cd? (S/N): ");
                if (!continuar.equalsIgnoreCase("s") && (!continuar.equalsIgnoreCase("sim"))) {
                    continuarReservando = false;
                }
            }
        }
    }
}
