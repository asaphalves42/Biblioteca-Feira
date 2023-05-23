package View.Reservas;

import Controller.ControllerReservas;
import Model.CD;
import Model.Socio;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewEfetuarReservaCD {
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

    private CD selecionarProdutoDisponivel(ControllerReservas gerirReservas) {
        CD cdSelecionado = null;

        while (cdSelecionado == null) {
            String tituloDoCd = leStr("Digite o título do cd:");


            ArrayList<CD> cdsDisponiveis = gerirReservas.pesquisarCDPorTitulo(tituloDoCd);

            if (cdsDisponiveis.isEmpty()) {
                System.out.println("Não existem cd's disponíveis!");
                System.out.println(" ");
            } else {
                for (CD cd : cdsDisponiveis) {
                    System.out.println(cd.toString());
                }

                String idCDStr = leStr("Insira o ID do cd que deseja reservar:");

                if (idCDStr.equalsIgnoreCase("sair")) {
                    break; // Sair do loop while
                }

                try {
                    int idLivro = Integer.parseInt(idCDStr);

                    for (CD cd : cdsDisponiveis) {
                        if (cd.getId() == idLivro) {
                            cdSelecionado = cd;
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID do cd inválido! Tente novamente.");
                }
            }
        }

        return cdSelecionado;
    }


    public void efetuarReservaCD(ControllerReservas gerirReservas) {
        Socio socioSelecionado = selecionarSocioExistente(gerirReservas);

        String input = leStr("Se deseja mostrar todos os CD´s insira um ENTER");
        if (input.equalsIgnoreCase("")) {
            ArrayList<CD> todosOsCds = gerirReservas.listaTodosOsCDs();
            for (CD cd : todosOsCds) {
                System.out.println(cd);
            }
        }

        boolean continuarReservando = true;

        while (continuarReservando) {

            CD cdSelecionado = selecionarProdutoDisponivel(gerirReservas);

            LocalDate dataDaReserva = LocalDate.now();

            if (cdSelecionado.getQuantidade() == 0) {
                System.out.println("Não existem mais exemplares desse cd no stock!");
                System.out.println();
            } else {
                boolean sucesso = gerirReservas.efetuarReservaCD(socioSelecionado, cdSelecionado, dataDaReserva);

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
