package View.Reservas;

import Controller.ControllerReservas;
import Model.Livro;
import Model.Socio;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewEfetuarReserva {

    private Socio selecionarSocioExistente(ControllerReservas gerirReservas) {
        Socio socioSelecionado = null;

        while (socioSelecionado == null) {
            String nomeSocio = leStr("Insira o nome do sócio:");
            ArrayList<Socio> socioExistente = gerirReservas.pesquisarSocioPorNome(nomeSocio);

            if (socioExistente.isEmpty()) {
                System.out.println("Não existem sócios com esse nome!");
                System.out.println(" ");
            } else {
                for (Socio socio : socioExistente) {
                    System.out.println(socio.toString());//listo o sócio
                }

                int numMecanografico = leInt("Insira o número mecanográfico do sócio:");

                for (Socio idSocio : socioExistente) {
                    if (numMecanografico == idSocio.getNumMecanografico()) {
                        socioSelecionado = idSocio;
                        break;
                    } else {
                        System.out.println("Número mecanográfico incorreto! Tente novamente! ");
                        System.out.println(" ");
                    }
                }
            }
        }
        return socioSelecionado;
    }

    private Livro selecionarProdutoDisponivel(ControllerReservas gerirReservas) {
        Livro livroSelecionado = null;

        while (livroSelecionado == null) {
            String tituloDoLivro = leStr("Digite o título do livro:");


            ArrayList<Livro> livrosDisponiveis = gerirReservas.pesquisarLivroPorTitulo(tituloDoLivro);

            if (livrosDisponiveis.isEmpty()) {
                System.out.println("Não existem exemplares disponíveis desse livro!");
                System.out.println(" ");
            } else {
                for (Livro livro : livrosDisponiveis) {
                    System.out.println(livro.toString());
                }

                String idLivroStr = leStr("Insira o ID do livro que deseja reservar:");

                if (idLivroStr.equalsIgnoreCase("sair")) {
                    break; // Sair do loop while
                }

                try {
                    int idLivro = Integer.parseInt(idLivroStr);

                    for (Livro livro : livrosDisponiveis) {
                        if (livro.getId() == idLivro) {
                            livroSelecionado = livro;
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID do livro inválido! Tente novamente.");
                }
            }
        }

        return livroSelecionado;
    }


    public void efetuarReservaLivros(ControllerReservas gerirReservas ) {
        Socio socioSelecionado = selecionarSocioExistente(gerirReservas);
        String input;
        input = leStr("Se deseja mostrar todos os livros insira um ENTER");
        if (input.equalsIgnoreCase("")) {
            gerirReservas.listaTodosOsLivros();

        }

        boolean continuarReservando = true;

        while (continuarReservando) {
            Livro livroSelecionado = selecionarProdutoDisponivel(gerirReservas);

            LocalDate dataDaReserva = LocalDate.now();


            if (livroSelecionado.getQuantidade() == 0) {
                System.out.println("Não existem mais exemplares desse livro no estoque!");
                System.out.println(" ");

            } else {

                boolean sucesso = gerirReservas.efetuarReserva(socioSelecionado, livroSelecionado, dataDaReserva);

                if (sucesso) {
                    System.out.println("Livro reservado com sucesso!");
                    System.out.println(" ");
                } else {
                    System.out.println("Ocorreu um erro ao efetuar reserva!");
                    System.out.println(" ");
                }

                String continuar = leStr("Deseja continuar reservar outro livro? (S/N): ");
                if (!continuar.equalsIgnoreCase("s") && (!continuar.equalsIgnoreCase("sim"))) {
                    continuarReservando = false;
                }

            }
        }
    }

}



