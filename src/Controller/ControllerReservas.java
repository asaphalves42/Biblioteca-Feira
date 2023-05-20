package Controller;

import Model.*;
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
                            socioLista.setProdutosReservados(livros.size());//encontro os livros
                        }
                    }
                    Reserva nova = new Reserva(value_split[0], socio, livros, LocalDate.parse(value_split[3]),LocalDate.parse(value_split[4]));
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
            String formated_date1 = aux.getDataDeDevolucao().format(formatter);

            conteudo += aux.getIdDaReserva() + "|";
            conteudo += aux.getSocio().getNumMecanografico() + "|";
            String idLivros = "";
            for (Produto livro : aux.getLivros()) {
                idLivros += livro.getId() + ",";
            }
            conteudo += idLivros + "|";
            conteudo += formated_date + "|";
            conteudo += formated_date1 + "\n";
        }
        GestorFicheiros.gravarFicheiro("reservas.txt", conteudo);
    }

    public boolean efetuarReservaCD(Socio socioSelecionado, CD cdSelecionado, LocalDate dataDaReserva) {

        // efetuar reserva do cd

        //habilitar para reservar cd e livro na mesma reserva

        // alterar no ficheiro

        return true;
    }

    public boolean efetuarReserva(Socio socioSelecionado, Livro livroSelecionado, LocalDate dataDaReserva) {
        boolean reservaExiste = false;
        Reserva reservaAux = getReserva(socioSelecionado);

        if (reservaAux != null) {
            reservaExiste = true;
        }

        if (!reservaExiste) {//cria uma reserva
            Reserva reserva = new Reserva();
            reserva.setSocio(socioSelecionado);
            reserva.setDataReserva(dataDaReserva);
            reservaAux = reserva;
        }
        if (socioSelecionado.getProdutosReservados() >= 3) {//se ja estiver 3, não deixa reservar
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

    public boolean devolverLivro(String IdDaReserva, LocalDate dataDeDevolucao, Socio socioDaReserva) {

        Reserva reserva = pesquisarReservaPorId(IdDaReserva);
        reserva.setDataDeDevolucao(dataDeDevolucao);

        for (Produto produto : reserva.getLivros()) {
            produto.aumentarQuantidade();
        }

        if (socioDaReserva != null) {
            socioDaReserva.decrementarQuantidade();
        }
        return true;
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
        for (Produto produto : produtos) {
            if (produto instanceof Livro livro) {
                if (tituloDoLivro.equalsIgnoreCase(livro.getTitulo())) {
                    livrosTitulo.add(livro);
                }
            }
        }
        return livrosTitulo;
    }
    public ArrayList<CD> pesquisarCDPorTitulo(String tituloDoCd) {
        ArrayList<CD> cdsTitulo = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto instanceof CD cd) {
                if (tituloDoCd.equalsIgnoreCase(cd.getTitulo())) {
                    cdsTitulo.add(cd);
                }
            }
        }
        return cdsTitulo;
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
                Socio socio = reserva.getSocio();
                socio.decrementarQuantidade();
                reservas.remove(reserva);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Livro> listaTodosOsLivros() {
        ArrayList<Livro> livros = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto instanceof Livro) {
                livros.add((Livro) produto);
            }
        }
        return livros;
    }
    public ArrayList<CD> listaTodosOsCDs() {
        ArrayList<CD> cds = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto instanceof CD) {
                cds.add((CD) produto);
            }
        }
        return cds;
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




