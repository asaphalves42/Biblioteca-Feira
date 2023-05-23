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
        LocalDate date;

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");

                if (value_split.length != 0) {
                    Socio socio = controllerSocios.pesquisarSocioPorNumMecanografico(Integer.parseInt(value_split[1]));
                    String[] idLivros = value_split[2].split(",");
                    ArrayList<Produto> livros = new ArrayList<>();
                    for (String idLivro : idLivros) {
                        if(idLivro != null && !idLivro.isEmpty()){
                            Produto livro = ControllerProdutos.pesquisarProdutoPorId(Integer.parseInt(idLivro));
                            livros.add(livro);
                        }
                    }

                    String[] idCds= value_split[3].split(",");
                    ArrayList<Produto> cds = new ArrayList<>();
                    for (String idCd : idCds) {
                        if(idCd != null && !idCd.isEmpty()) {
                            Produto cd = ControllerProdutos.pesquisarProdutoPorId(Integer.parseInt(idCd));
                            cds.add(cd);
                        }
                    }

                    if(value_split[5].equalsIgnoreCase("null")){
                         date = null;
                    }else{
                         date = LocalDate.parse(value_split[4]);
                    }
                    Reserva nova = new Reserva(value_split[0], socio, livros, cds, LocalDate.parse(value_split[4]),date);

                    if(date!= null){
                        nova.setDevolvido(true);
                        for (Socio socioLista : ControllerSocios.socios) {//loop na lista de socios, para verificar quantos livros ele tem associado
                            if (socioLista.getNumMecanografico() == socio.getNumMecanografico()) {//igualo o socio
                                socioLista.setProdutosReservados(0);//encontro os livros
                            }
                        }
                    }else{
                        for (Socio socioLista : ControllerSocios.socios) {//loop na lista de socios, para verificar quantos livros ele tem associado
                            if (socioLista.getNumMecanografico() == socio.getNumMecanografico()) {//igualo o socio
                                socioLista.setProdutosReservados(livros.size() + cds.size());//encontro os livros
                            }
                        }
                    }
                    reservas.add(nova);
                }
            }
        }
    }


    public void gravarReservasParaFicheiro() {
        String conteudo = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formated_date1;
        for (Reserva aux : reservas) {
            String formated_date = aux.getDataReserva().format(formatter);

            if(aux.getDataDeDevolucao()!= null){
                formated_date1 = aux.getDataDeDevolucao().format(formatter);
            }else{
                formated_date1 = null;
            }


            conteudo += aux.getIdDaReserva() + "|";
            conteudo += aux.getSocio().getNumMecanografico() + "|";
            String idLivros = "";
            for (Produto livro : aux.getLivros()) {
                idLivros += livro.getId() + ",";
            }
            conteudo += idLivros + "|";
            String idCds = "";
            for (Produto cd : aux.getCds()) {
                idCds += cd.getId() + ",";
            }

            conteudo += idCds + "|";
            conteudo += formated_date + "|";
            conteudo += formated_date1 + "\n";
        }
        GestorFicheiros.gravarFicheiro("reservas.txt", conteudo);
    }

    public boolean efetuarReservaCD(Socio socioSelecionado, CD cdSelecionado, LocalDate dataDaReserva) {

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
            reservaAux.getCds().add(cdSelecionado);
            socioSelecionado.aumentarQuantidade();
            cdSelecionado.decrementarQuantidade();
            if (!reservaExiste) {
                reservas.add(reservaAux);
            }
            return true;
        }
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
            if (res.getSocio().getNumMecanografico() == socioSelecionado.getNumMecanografico() && !res.isDevolvido()) {
                return res;
            }
        }
        return null;
    }

    public boolean devolverProduto(String IdDaReserva, LocalDate dataDeDevolucao, Socio socioDaReserva) {

        Reserva reserva = pesquisarReservaPorId(IdDaReserva);
        reserva.setDataDeDevolucao(dataDeDevolucao);
        reserva.setDevolvido(true);

        for (Produto produto : reserva.getLivros()) {
            produto.aumentarQuantidade();
        }

        if (socioDaReserva != null) {
            socioDaReserva.resetQuantidade();
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

                for (Produto cancelarCD : reserva.getCds()) {
                    cancelarCD.aumentarQuantidade();
                }
                Socio socio = reserva.getSocio();
                socio.resetQuantidade();
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




