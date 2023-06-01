package Controller;

import Model.Produto;
import Model.Reserva;
import Model.Socio;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerReservas {
    public static ArrayList<Reserva> reservas = new ArrayList<>();
    public static ArrayList<String> eliminados = new ArrayList<String>();
    public ControllerSocios controllerSocios;
    public ControllerProdutos controllerProdutos;

    public ControllerReservas(ControllerSocios controllerSocios, ControllerProdutos controllerProdutos) {
        this.controllerSocios = controllerSocios;
        this.controllerProdutos = controllerProdutos;
    }

    public void lerReservaFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("reservas.txt");

        reservas = new ArrayList<>();
        LocalDate date;

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");

                if (value_split.length != 0) {
                    Socio socio = controllerSocios.pesquisarSocioPorNumMecanografico(Integer.parseInt(value_split[1]));
                    String[] idProdutos = value_split[2].split(",");
                    ArrayList<Produto> produtos = new ArrayList<>();
                    for (String idProduto : idProdutos) {
                        if(idProduto != null && !idProduto.isEmpty()){
                            Produto produto = controllerProdutos.pesquisarProdutoPorId(Integer.parseInt(idProduto));
                            produtos.add(produto);
                        }
                    }
                    
                    if(value_split[3].equalsIgnoreCase("null")){
                        date = null;
                    }else{
                        date = LocalDate.parse(value_split[3]);
                    }
                    Reserva nova = new Reserva(value_split[0], socio, produtos, LocalDate.parse(value_split[3]),date);

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
                                socioLista.setProdutosReservados(produtos.size());//encontro os livros
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
            String idProdutos = "";
            for (Produto produto : aux.getProdutos()) {
                idProdutos += produto.getId() + ",";
            }
            conteudo += idProdutos + "|";
            conteudo += formated_date + "|";
            conteudo += formated_date1 + "\n";
        }
        GestorFicheiros.gravarFicheiro("reservas.txt", conteudo);
    }


    public boolean efetuarReservaProduto(Socio socioSelecionado, Produto produtoSelecionado, LocalDate dataDaReserva) {

        boolean reservaExiste = false;
        Reserva reservaAux = getReserva(socioSelecionado);

        if (reservaAux != null) {
            reservaExiste = true;
        }

        if (!reservaExiste) {//cria uma reserva
            Reserva reserva = new Reserva();
            reserva.setSocio(socioSelecionado);
            reserva.setDataReserva(dataDaReserva);
            reserva.setPendenteGravacao(true);
            reservaAux = reserva;
        }
        if (socioSelecionado.getProdutosReservados() >= 3) {//se ja estiver 3, não deixa reservar
            return false;
        } else { //adicionar a uma reserva que ja existe
            reservaAux.getProdutos().add(produtoSelecionado);
            socioSelecionado.aumentarQuantidade();
            produtoSelecionado.decrementarQuantidade();
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

    public boolean devolverReserva(String idDaReserva, LocalDate dataDeDevolucao) {

        Reserva reserva = pesquisarReservaPorId(idDaReserva);
        reserva.setDataDeDevolucao(dataDeDevolucao);
        reserva.setDevolvido(true);
        reserva.setPendenteGravacao(true);
        for (Produto produto : reserva.getProdutos()) {
            produto.aumentarQuantidade();
        }

        if (reserva.getSocio() != null) {
            reserva.getSocio().resetQuantidade();
        }
        return true;
    }

    public boolean devolverProduto(String IdDaReserva, Integer IdProduto) {
        Reserva reserva = pesquisarReservaPorId(IdDaReserva);
        if (reserva != null) {
            for (Produto produto : reserva.getProdutos()) {
                if (produto.getId() == IdProduto) {
                    produto.aumentarQuantidade();
                    reserva.getProdutos().remove(produto);
                    reserva.setPendenteGravacao(true);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Reserva> listarReservas() {
        return reservas;
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
                for (Produto produtoReserva : reserva.getProdutos()) {
                    produtoReserva.aumentarQuantidade();
                }
                Socio socio = reserva.getSocio();
                socio.resetQuantidade();
                reservas.remove(reserva);
                eliminados.add(reserva.getIdDaReserva());
                return true;
            }
        }
        return false;
    }

    public boolean editarReservaAlterarProduto(String idReserva, int idProduto, int idNovoProduto) {
        boolean encontrou = false;
        Reserva reserva = this.pesquisarReservaPorId(idReserva);
        if (reserva != null) {
            for (Produto produto : reserva.getProdutos()) {
                if (produto.getId() == idProduto) {
                    reserva.getProdutos().remove(produto);
                    reserva.setPendenteGravacao(true);
                    produto.aumentarQuantidade();
                    encontrou = true;
                    break;
                }
            }
            if (encontrou) {
                Produto novoProduto = controllerProdutos.pesquisarProdutoPorId(idNovoProduto);
                if (novoProduto != null) {
                    if (novoProduto.getQuantidade() > 0){
                        reserva.getProdutos().add(novoProduto);
                        novoProduto.decrementarQuantidade();
                        reserva.setPendenteGravacao(true);
                    }
                }
            }
        }
        return encontrou;
    }
}




