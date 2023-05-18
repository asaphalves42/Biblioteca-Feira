package Controller;

import Model.Livro;
import Model.Produto;
import Model.Reserva;
import Model.Socio;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static Controller.ControllerProdutos.produtos;
import static Controller.ControllerSocios.socios;

public class ControllerReservas {
    public static ArrayList<Reserva> reservas = new ArrayList<>();
    public ControllerSocios controllerSocios;
    public ControllerProdutos controllerLivros;

    public ControllerReservas(ControllerSocios controllerSocios, ControllerProdutos controllerLivros) {
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
                    ArrayList<Produto> livros = new ArrayList<>();
                    for (String idLivro : idLivros) {
                        Produto livro = ControllerProdutos.pesquisarProdutoPorId(Integer.parseInt(idLivro));
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
            for (Produto livro : aux.getLivros()) {
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

    public void devolverLivro(String IdDaReserva,LocalDate dataDeDevolucao) {
        Reserva idDaReserva = pesquisarReservaPorId(IdDaReserva);
        idDaReserva.setDataDeDevolucao(dataDeDevolucao);
        for(Produto produtos: idDaReserva.getLivros()){
            produtos.aumentarQuantidade();
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
        for (Produto livro : produtos) {
            if (tituloDoLivro.equalsIgnoreCase(livro.getTitulo())) {
                livrosTitulo.add((Livro) livro);
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
                for (Produto cancelarLivro : reserva.getLivros()) {
                    cancelarLivro.aumentarQuantidade();
                }
                reservas.remove(reserva);

                return true;
            }
        }
        return false;
    }

    public void listaTodosOsLivros() {
        ArrayList<Produto> todosLivros = new ArrayList<>();
        for (Produto livro: ControllerProdutos.produtos){
            todosLivros.add(livro);
        }
        System.out.println(todosLivros);
    }

    public boolean editarReservaLivro(int idLivro, int novoLivroId) {
        boolean encontrou = false;
        for (Reserva reserva : reservas) {
            for (Produto livro : reserva.getLivros()) {
                if (livro.getId() == idLivro) {
                    reserva.getLivros().remove(livro);
                    livro.aumentarQuantidade();
                    encontrou = true;
                    break;
                }
            }

            if (encontrou) {
                Livro novoLivro = (Livro) ControllerProdutos.pesquisarProdutoPorId(novoLivroId);
                if (novoLivro != null) {
                    if (novoLivro.getQuantidade() > 0)
                        reserva.getLivros().add(novoLivro);
                    novoLivro.decrementarQuantidade();
                }
                break;
            }
        }
        return encontrou;
    }

}




