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

    private Socio selecionarSocioExistente(ControllerSocios gerirReservas) {
        boolean sair=true;
        Socio socioSelecionado = null;

        while (socioSelecionado == null) {
            String nomeSocio = leStr("Insira o nome do sócio (ou sair se quer sair):");
            if (nomeSocio.equalsIgnoreCase("sair")) {
                sair = true;
                break;
            }
            ArrayList<Socio> socioExistente = gerirReservas.pesquisarSocioPorNome(nomeSocio);

            if (socioExistente.isEmpty()) {
                System.out.println("Não existem sócios com esse nome!");
                System.out.println(" ");
            } else {
                for (Socio socio : socioExistente) {
                    System.out.println(socio.toString());//listo o sócio
                }

                int numMecanografico = leInt("Insira o número mecanográfico do sócio (ou 0 se quer sair):");
                if (numMecanografico==0) {
                    sair = true;
                    break;
                }

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

    private CD selecionarProdutoDisponivel(ControllerProdutos gerirProdutos) {
        boolean sair = false;
        CD cdSelecionado = null;

        while (cdSelecionado == null) {
            String tituloDoCd = leStr("Digite o título do cd (ou sair se quer sair):");
            if (tituloDoCd.equalsIgnoreCase("sair")) {
                sair = true;
                break;
            }

            ArrayList<CD> cdsDisponiveis = gerirProdutos.pesquisarCDPorTitulo(tituloDoCd);

            if (cdsDisponiveis.isEmpty()) {
                System.out.println("Não existem cd's disponíveis!");
                System.out.println(" ");
            } else {
                for (CD cd : cdsDisponiveis) {
                    System.out.println(cd.toString());
                }

                String idCDStr = leStr("Insira o ID do cd que deseja reservar (ou sair se quer sair):");

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
