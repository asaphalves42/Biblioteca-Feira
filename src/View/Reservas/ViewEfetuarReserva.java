package View.Reservas;

import Controller.ControllerReservas;
import Model.Livro;
import Model.Socio;
import Utilidades.ValidacaoData;


import java.time.LocalDate;
import java.util.ArrayList;

import static Controller.ControllerLivros.livros;
import static Utilidades.Leitura.leStr;
import static Utilidades.Leitura.leint;

public class ViewEfetuarReserva {

    public void efetuarReserva(ControllerReservas gerirReservas) {
        ArrayList<Socio> socioExistente;
        Socio socioSelecionado = null;

        while (socioSelecionado == null) {
            String nomeSocio = leStr("Insira o nome do sócio:");
            socioExistente = gerirReservas.pesquisarSocioPorNome(nomeSocio);

            if (socioExistente.isEmpty()) {
                System.out.println("Não existem sócios com esse nome!");
            } else {
                for (Socio socio : socioExistente) {
                    System.out.println(socio.toString());
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
            assert socioSelecionado != null;
            if(socioSelecionado.getLivrosReservados() == 3){//data de reserva tambem tem que ser a mesma
                System.out.println("Ja atingiu o número máximo de reservas");
            }
            return;
        }

        ArrayList<Livro> livroExistente;
        Livro livroSelecionado = null;

        while (livroSelecionado == null) {
            String tituloDolivro = leStr("Digite o título do livro:");
            livroExistente = gerirReservas.pesquisarLivroPorTitulo(tituloDolivro);

            if (livroExistente.isEmpty()) {
                System.out.println("Não existem livros com esse nome!");
            } else {
                for (Livro livro : livroExistente) {
                    System.out.println(livro.toString());
                }

                int IdLivro = leint("Insira o id do livro que deseja reservar:");

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
        LocalDate dataDaReserva = validarData.LerData2();

        if(livroSelecionado.getQuantidade() == 0){
            System.out.println("Não existem mais exemplares desse livro no estoque!");
            System.out.println(" ");
        }else{
            System.out.println("Livro reservado com sucesso!");
            System.out.println(" ");
        }
        gerirReservas.efetuarReserva(socioSelecionado, livroSelecionado, dataDaReserva);

    }

}





