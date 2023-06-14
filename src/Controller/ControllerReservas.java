package Controller;

import Model.Produto;
import Model.Reserva;
import Model.Socio;
import Utilidades.BaseDados;
import Utilidades.GestorFicheiros;

import java.sql.ResultSet;
import java.sql.SQLException;
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
                    } else if (value_split[4].equalsIgnoreCase("null")){
                        date = null;
                    } else{
                        date = LocalDate.parse(value_split[4]);
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

    public void lerReservasDeBaseDados() {

        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            ResultSet resultado = basedados.Selecao("select * from reserva");

            while (resultado.next()){

                ResultSet resultadoProdutosReserva = basedados.Selecao("select * from reserva_produtos where id_reserva = " + resultado.getInt("id"));
                ArrayList<Produto> produtos = new ArrayList<Produto>();

                while (resultadoProdutosReserva.next()) {
                    produtos.add(controllerProdutos.pesquisarProdutoPorId(resultadoProdutosReserva.getInt("id_produto")));
                }

                // enquanto existirem registos, vou ler 1 a 1
                Reserva aux = new Reserva(
                        resultado.getString("id"),
                        controllerSocios.pesquisarSocioPorNumMecanografico(resultado.getInt("id_socio")),
                        produtos,
                        resultado.getDate("data_inicio").toLocalDate(),
                        resultado.getDate("data_fim") == null ? null :  resultado.getDate("data_fim").toLocalDate()); // a data pode ser nula então tem que fazer um if
                reservas.add(aux);
            }
            basedados.Desligar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarReservasParaBaseDados() {

        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            //insere ou atualizar os registos
            for (Reserva aux : reservas) {
                if (aux.getPendenteGravacao()) {
                    //apago a reserva
                    basedados.Executar("DELETE FROM reserva_produtos where id_reserva = '" + aux.getIdDaReserva() +"'");
                    basedados.Executar("DELETE FROM reserva where id = " + aux.getIdDaReserva());

                    String devolucao = "";
                    if (aux.getDataDeDevolucao() == null){
                        devolucao = "null";
                    }else{
                        devolucao = "'"+ aux.getDataDeDevolucao().format(formatter) +"'";
                    }
                    //insiro a reserva
                    basedados.Executar("INSERT INTO reserva (id, id_socio, data_inicio, data_fim) " +
                            " values ('" + aux.getIdDaReserva() + "', '" + aux.getSocio().getNumMecanografico() + "', '"+aux.getDataReserva().format(formatter)+"', "+devolucao+")");

                    for (Produto produto: aux.getProdutos()){
                        basedados.Executar("INSERT INTO reserva_produtos (id_reserva, id_produto) " +
                                " values ('" + aux.getIdDaReserva() + "', '" + produto.getId()+"')");

                    }
                }
            }

            //eliminar registos que foram apagados
            if (eliminados.size() > 0){
                for (String aux : eliminados) {
                    basedados.Executar("DELETE FROM reserva_produtos where id = " + aux);
                    basedados.Executar("DELETE FROM reserva where id = " + aux);
                }
                eliminados.clear(); //apago o array porque já foi processado
            }

            basedados.Desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
                eliminados.add(reserva.getIdDaReserva());
                reservas.remove(reserva);
                return true;
            }
        }
        return false;
    }

}




