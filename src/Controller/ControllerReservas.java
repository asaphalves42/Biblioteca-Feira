package Controller;

import Model.Livro;
import Model.Reserva;
import Model.Socio;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static Controller.ControllerLivros.livros;
import static Controller.ControllerSocios.socios;

public class ControllerReservas {
    public ArrayList<Reserva> reservas = new ArrayList<>();
    public ControllerSocios controllerSocios;
     public ControllerLivros controllerLivros;

    public ControllerReservas(ControllerSocios controllerSocios, ControllerLivros controllerLivros){
        this.controllerSocios = controllerSocios;
        this.controllerLivros = controllerLivros;
    }

    public ControllerReservas() {

    }

    public void lerLivrosDeFicheiroReserva() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("reservas.txt");

        this.reservas = new ArrayList<>();

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");
                if (value_split.length !=0) {
                    Socio socio = controllerSocios.pesquisarSocioPorNumMecanografico(value_split[1]);
                    String[] idLivros = value_split[2].split(",");
                    ArrayList<Livro> livros = new ArrayList<>();
                    for(String idLivro : idLivros){
                        Livro livro = controllerLivros.pesquisarLivroPorId(Integer.parseInt(idLivro));
                        livros.add(livro);
                    }
                    Reserva nova = new Reserva(value_split[0], socio,livros, LocalDate.parse(value_split[3]));
                    this.reservas.add(nova);
                }
            }
        }
    }

    public void gravarReservasParaFicheiro(){
        String conteudo = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Reserva aux : reservas){
            String formated_date = aux.getDataReserva().format(formatter);

            conteudo += aux.getIdDaReserva() + "|";
            conteudo += aux.getSocio().getNumMecanografico() + "|" ;
            String idLivros = "";
            for(Livro livro : aux.getLivros()){
                idLivros += livro.getId() + ",";
            }
            conteudo += idLivros+ "|" ;
            conteudo += formated_date + "|\n" ;
        }
        GestorFicheiros.gravarFicheiro("reservas.txt", conteudo);
    }


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
                } else {
                    reservaEncontrada.getSocio().decrementarQuantidade();

                    editarQuantidadeReserva(IdDoLivro,  1);
                }
                break;
            }
        }
    }

    public boolean editarQuantidadeReserva(int idDoLivro, int novaQuantidade) {
        for (Livro livro : livros) {
            if (idDoLivro == livro.getId()) {
                livro.setQuantidade(livro.getQuantidade() + novaQuantidade);
                return true;
            }
        }
        return false;
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



