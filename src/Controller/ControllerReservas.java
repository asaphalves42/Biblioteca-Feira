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
    public static ArrayList<Reserva> reservas = new ArrayList<>();
    public ControllerSocios controllerSocios;
    public ControllerLivros controllerLivros;

    public ControllerReservas(ControllerSocios controllerSocios, ControllerLivros controllerLivros) {
        this.controllerSocios = controllerSocios;
        this.controllerLivros = controllerLivros;
    }

    public ControllerReservas() {

    }

    public void lerLivrosDeFicheiroReserva() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("reservas.txt");

        reservas = new ArrayList<>();

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");
                if (value_split.length != 0) {
                    Socio socio = controllerSocios.pesquisarSocioPorNumMecanografico(Integer.parseInt(value_split[1]));
                    String[] idLivros = value_split[2].split(",");
                    ArrayList<Livro> livros = new ArrayList<>();
                    for (String idLivro : idLivros) {
                        Livro livro = controllerLivros.pesquisarLivroPorId(Integer.parseInt(idLivro));
                        livros.add(livro);
                    }
                    for (Socio socioLista : ControllerSocios.socios) {//loop na lista de socios, para verificar quantos livros ele tem associado
                        if (socioLista.getNumMecanografico() == socio.getNumMecanografico()) {//igualo o socio
                            socioLista.setLivrosReservados(livros.size());//encontro os livros
                        }
                    }
                    Reserva nova = new Reserva(value_split[0], socio, livros, LocalDate.parse(value_split[3]));
                    reservas.add(nova);
                }
            }
        }
    }

    public void gravarReservasParaFicheiro() {
        String conteudo = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Reserva aux : reservas) {
            String formated_date = aux.getDataReserva().format(formatter);

            conteudo += aux.getIdDaReserva() + "|";
            conteudo += aux.getSocio().getNumMecanografico() + "|";
            String idLivros = "";
            for (Livro livro : aux.getLivros()) {
                idLivros += livro.getId() + ",";
            }
            conteudo += idLivros + "|";
            conteudo += formated_date + "|\n";
        }
        GestorFicheiros.gravarFicheiro("reservas.txt", conteudo);
    }


    public boolean efetuarReserva(Socio socioSelecionado, Livro livroSelecionado, LocalDate dataDaReserva) {
        boolean reservaExiste = false;
        Reserva reservaAux = getReserva(socioSelecionado);

        if (reservaAux != null) {
            reservaExiste = true;
        }

        if (!reservaExiste) {//cria uma nova reserva
            Reserva reserva = new Reserva();
            reserva.setSocio(socioSelecionado);
            reserva.setDataReserva(dataDaReserva);
            reservaAux = reserva;
        }
        if (socioSelecionado.getLivrosReservados() >= 3) {//se ja estiver 3, não deixa reservar
            return false;

        } else { //adicionar a uma reserva que ja existe
            reservaAux.getLivros().add(livroSelecionado);
            socioSelecionado.aumentarQuantidade();
            livroSelecionado.decrementarQuantidade();
            if (!reservaExiste) {
                reservas.add(reservaAux);
            }
            return true;
        }
    }


    public Reserva getReserva(Socio socioSelecionado) {
        //igualo o meu socio selecionado com o numero mecanografico
        for (Reserva res : reservas) {
            if (res.getSocio().getNumMecanografico() == socioSelecionado.getNumMecanografico()) {
                return res;
            }
        }
        return null;
    }

    public void devolverLivro(String IdDaReserva, int IdDoLivro, LocalDate dataDeDevolucao) {
        Reserva reservaEncontrada = null;

        for (Reserva reserva : reservas) { // Percorre a lista de reservas para encontrar a reserva correspondente ao ID informado.
            if (IdDaReserva.equalsIgnoreCase(reserva.getIdDaReserva())) { // Compara o ID da reserva informado com o ID da reserva atual no loop.
                for (Livro livro : reserva.getLivros()) { // Percorre a lista de livros da reserva para encontrar o livro correspondente ao ID informado.
                    if (IdDoLivro == livro.getId()) { // Compara o ID do livro informado com o ID do livro atual no loop.
                        reservaEncontrada = reserva; // Armazena a reserva encontrada na variável `reservaEncontrada`.
                        break;
                    }
                }
            }

            if (reservaEncontrada != null) {
                reservaEncontrada.getLivros().removeIf(livro -> IdDoLivro == livro.getId()); // Remove o livro da lista de livros da reserva.
                //lambda sugerida pelo intellij


                //adicionar uma data de devolução, desvincular o remover livros da lista de reservas pra criar um histórico de livros devolvidos.

                //Livro ... devolvido em dataDeDevolucao...

                //reserva pode ter um estado, aberta ou fechada

                // não pode existir pois preciso de um historico de reservas
                if (reservaEncontrada.getLivros().isEmpty()) { //Se a reserva encontrada nao houver livros ele remove a reserva.
                    reservas.remove(reservaEncontrada);
                }

                editarQuantidadeReserva(IdDoLivro, 1);
                reservaEncontrada.getSocio().decrementarQuantidade(); // Atualiza a quantidade de livros reservados pelo sócio, decrementando em 1.
                break;
            }
        }

    }

    public void editarQuantidadeReserva(int idDoLivro, int novaQuantidade) {
        for (Livro livro : livros) {
            if (idDoLivro == livro.getId()) {
                livro.setQuantidade(livro.getQuantidade() + novaQuantidade);
                return;
            }
        }
    }

    public ArrayList<Reserva> listarReservas() {
        return reservas;
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

    public boolean cancelarReserva(String idReserva) {
        for (Reserva reserva : reservas) {
            if (idReserva.equalsIgnoreCase(reserva.getIdDaReserva())) {
                reservas.remove(reserva);
                return true;
            }
        }
        return false;
    }

    public boolean editarReservaLivro(int idLivro, int novoLivro) {
        for (Reserva reserva : reservas) {
            if (reserva.getLivros().contains(idLivro)) {
                reserva.getLivros().remove(idLivro);
                //aumenta quantidade no stock

                for (Livro livroParaEditar : ControllerLivros.livros) {
                    if (livroParaEditar.getId() == novoLivro) {
                        novoLivro = livroParaEditar.getId();
                        //reserva.getLivros().add(novoLivro);
                        //decrementa o novo livro no stock
                    }
                }

            }
        }
        return false;

    }

}




