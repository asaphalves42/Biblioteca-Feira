package View.Reservas;

import Controller.ControllerProdutos;
import Controller.ControllerReservas;
import Controller.ControllerSocios;
import Model.Livro;
import Model.Socio;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewEfetuarReservaLivro {

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



    private Livro selecionarProdutoDisponivel(ControllerProdutos gerirProdutos) {
        Livro livroSelecionado = null;

        while (livroSelecionado == null) {
            for (Livro livro : gerirProdutos.listarProdutosLivros()) {
                System.out.println(livro.toString());
            }

            String idLivroStr = leStr("Insira o ID do livro que deseja reservar (ou 'sair' para sair):");

            if (idLivroStr.equalsIgnoreCase("sair")) {
                break; // Sair do loop while
            }

            try {
                int idLivro = Integer.parseInt(idLivroStr);

                for (Livro livro : gerirProdutos.listarProdutosLivros()) {
                    if (livro.getId() == idLivro) {
                        livroSelecionado = livro;
                        break;
                    }
                }

                if (livroSelecionado == null) {
                    System.out.println("ID do livro inválido! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido! Tente novamente.");
            }
        }

        return livroSelecionado;
    }

    public void efetuarReserva(ControllerReservas gerirReservas, ControllerProdutos gerirProdutos, ControllerSocios gerirSocios, Socio socio) {

        Socio socioSelecionado = socio;
        if (socio == null) {
            socioSelecionado = selecionarSocioExistente(gerirSocios);
        }

        if (socioSelecionado == null) { // se não selecionou nenhum socio ou não foi passado como parametro, então volta a questionar
            efetuarReserva(gerirReservas, gerirProdutos, gerirSocios,null);
        }

        String input = leStr("Se deseja mostrar todos os livros insira um ENTER");
        if (input.equalsIgnoreCase("")) {
            for (Livro livro : gerirProdutos.listarProdutosLivros()) {
                System.out.println(livro);
            }
        }

        boolean continuarReservando = true;

        while (continuarReservando) {
            Livro livroSelecionado = selecionarProdutoDisponivel(gerirProdutos);

            LocalDate dataDaReserva = LocalDate.now();

            if (livroSelecionado.getQuantidade() == 0) {
                System.out.println("Não existem mais exemplares desse livro no estoque!");
                System.out.println();
            } else {

                boolean sucesso = gerirReservas.efetuarReservaProduto(socioSelecionado, livroSelecionado, dataDaReserva);

                if (sucesso) {
                    System.out.println("Livro reservado com sucesso!");
                    System.out.println();
                } else {
                    System.out.println("Ocorreu um erro ao efetuar reserva, número máximo de produtos reservados!");
                    System.out.println();
                }

                String continuar = leStr("Deseja continuar reservar outro livro? (S/N): ");
                if (!continuar.equalsIgnoreCase("s") && (!continuar.equalsIgnoreCase("sim"))) {
                    continuarReservando = false;
                }
            }
        }
    }

}



