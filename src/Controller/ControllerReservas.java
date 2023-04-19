package Controller;

import Model.Livro;
import Model.Reserva;
import Model.Socio;

import java.time.LocalDate;
import java.util.ArrayList;

import static Controller.ControllerLivros.livros;
import static Controller.ControllerSocios.socios;

public class ControllerReservas {
    public ArrayList<Reserva> reservas = new ArrayList<>();


    public void efetuarReserva(Socio socioSelecionado, Livro livroSelecionado, LocalDate dataDaReserva){
        boolean reservaExiste = false;

        Reserva reservaAux = getReserva(socioSelecionado);
        if(reservaAux!= null){
            reservaExiste = true;
        }

        if(reservaExiste == false){
            Reserva reserva = new Reserva();
            reserva.setSocio(socioSelecionado);
            reserva.setDataReserva(dataDaReserva);
            reserva.getLivros().add(livroSelecionado);

            reservas.add(reserva);
        }else{
            reservaAux.getLivros().add(livroSelecionado);
        }

        livroSelecionado.decrementarQuantidade();
        socioSelecionado.aumentarQuantidade();

    }

    public Reserva getReserva(Socio socioSelecionado){
        for(Reserva res  : reservas){
            if(res.getSocio().getNumMecanografico() == socioSelecionado.getNumMecanografico()){
                return res;
            }
        }
        return null;
    }

    public void devolverLivro(String IdDaReserva, int IdDoLivro) {
        Reserva reservaEncontrada = null;
        for (Reserva reserva : reservas) {
            if (IdDaReserva.equalsIgnoreCase(reserva.getIdDaReserva())) {
                for (Livro livro : reserva.getLivros()) {
                    if (IdDoLivro == livro.getId()) {
                        reservaEncontrada = reserva;
                        break;
                    }
                }
            }

            if (reservaEncontrada != null) {
                reservaEncontrada.getLivros().removeIf(livro -> IdDoLivro == livro.getId());
                if (reservaEncontrada.getLivros().isEmpty()) {
                    reservas.remove(reservaEncontrada);
                }else{
                    reservaEncontrada.getSocio().decrementarQuantidade();
                    reservaEncontrada.getLivros().forEach(livro -> livro.incrementarQuantidade());

                    //usar o metodo dos controller dos livros para atualizar a quantidade de livros
                }
                break;
            }
        }
    }
    public ArrayList<Reserva> listarReservas() {
        return this.reservas;
    }

    public ArrayList<Socio> pesquisarSocioPorNome(String nomeInserido) {
            ArrayList<Socio> socioListado = new ArrayList<>();
            for (Socio socio : socios) {
                if (nomeInserido.equalsIgnoreCase(socio.getNome())) {
                    socioListado.add(socio);
                }
            }
            return socioListado;
        }

    public ArrayList<Livro> pesquisarLivroPorTitulo(String tituloDoLivro) {
        ArrayList<Livro> livrosTitulo = new ArrayList<>();
        for (Livro livro : livros) {
            if (tituloDoLivro.equalsIgnoreCase(livro.getTitulo())) {
                livrosTitulo.add(livro);
            }
        }
        return livrosTitulo;
    }

    public Reserva pesquisarReservaPorId(String idReserva) {
        for (Reserva reserva : reservas) {
            if (idReserva.equalsIgnoreCase(reserva.getIdDaReserva())) {
                return reserva;
            }
        }
        return null;
    }

}



