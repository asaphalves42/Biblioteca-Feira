package View.Reservas;

import Controller.ControllerReservas;
import Model.Livro;
import Model.Socio;
import Utilidades.ValidacaoData;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewEfetuarReserva {

    public void efetuarReserva(ControllerReservas gerirReservas) {
        ArrayList<Socio> socioExistente;
        Socio socioSelecionado = null;

        //enquanto meu socio não estiver selecionado
        while (socioSelecionado == null) {
            String nomeSocio = leStr("Insira o nome do sócio:");
            socioExistente = gerirReservas.pesquisarSocioPorNome(nomeSocio);

            //se nao existir...
            if (socioExistente.isEmpty()) {
                System.out.println("Não existem sócios com esse nome!");
                System.out.println(" ");
            } else {
                //se existir...
                for (Socio socio : socioExistente) {
                    System.out.println(socio.toString());//listo o sócio
                }

                String numMecanografico = leStr("Insira o número mecanográfico do sócio:");

                for (Socio idSocio : socioExistente) {
                    if (numMecanografico.equals(idSocio.getNumMecanografico())) {
                        socioSelecionado = idSocio;
                    } else {
                        System.out.println("Número mecanográfico incorreto! Tente novamente! ");
                        System.out.println(" ");
                    }
                }
            }

        }

        if (socioSelecionado != null && socioSelecionado.getLivrosReservados() == 3) {
            System.out.println("Ja atingiu o número máximo de reservas");
            System.out.println(" ");
        }

        boolean continuarReservando = true;

        while (continuarReservando) {
            ArrayList<Livro> livroExistente;
            Livro livroSelecionado = null;

            while (livroSelecionado == null) {
                String tituloDolivro = leStr("Digite o título do livro:");
                livroExistente = gerirReservas.pesquisarLivroPorTitulo(tituloDolivro);

                if (livroExistente.isEmpty()) {
                    System.out.println("Não existem livros com esse nome!");
                    System.out.println(" ");
                } else {
                    for (Livro livro : livroExistente) {
                        System.out.println(livro.toString());
                    }

                    int IdLivro = leInt("Insira o id do livro que deseja reservar:");

                    for (Livro livro : livroExistente) {
                        if (livro.getId() == IdLivro) {
                            livroSelecionado = livro;
                            break;
                        }
                    }
                }
            }

            System.out.println("Data da reserva: ");

            ValidacaoData validarData = new ValidacaoData();
            LocalDate dataDaReserva = null;
            try {
                dataDaReserva = validarData.LerData2();
            } catch (Exception e) {
                System.out.println("Erro ao ler data da reserva: " + e.getMessage());
            }

            if (livroSelecionado.getQuantidade() == 0) {
                System.out.println("Não existem mais exemplares desse livro no estoque!");
                System.out.println(" ");
            } else {
                System.out.println("Livro reservado com sucesso!");
                System.out.println(" ");
            }

            try {
                gerirReservas.efetuarReserva(socioSelecionado,livroSelecionado, dataDaReserva);

            } catch (Exception e) {
                System.out.println("Erro ao efetuar reserva: " + e.getMessage());

            }
            String continuar = leStr("Deseja continuar reservar outro livro? (S/N): ");
            if (!continuar.equalsIgnoreCase("s") && (!continuar.equalsIgnoreCase("sim"))) {
                continuarReservando = false;
            }
        }
    }
}