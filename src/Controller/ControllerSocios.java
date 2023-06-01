package Controller;


import Model.Reserva;
import Model.Socio;
import Utilidades.BaseDados;
import Utilidades.GestorFicheiros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerSocios {
    public static ArrayList<Socio> socios = new ArrayList<>();
    public static ArrayList<Integer> eliminados = new ArrayList<Integer>();

    public void lerSociosDoFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("socios.txt");
        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");
                if (value_split.length != 0) {
                    Socio aux = new Socio(Integer.parseInt(value_split[0]),
                            value_split[1],
                            value_split[2],
                            LocalDate.parse(value_split[3]),
                            Integer.parseInt(value_split[4]));
                    socios.add(aux);
                }
            }
        }
    }

    public void gravarSociosParaFicheiro() {
        String conteudo = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Socio aux : socios) {
            String formated_date = aux.getDataDeNascimento().format(formatter);

            conteudo += aux.getNumMecanografico() + "|";
            conteudo += aux.getNome() + "|";
            conteudo += aux.getMorada() + "|";
            conteudo += formated_date + "|";
            conteudo += aux.getTelefone() + "|" + "\n";
        }
        GestorFicheiros.gravarFicheiro("socios.txt", conteudo);
    }

    public void lerSociosDeBaseDados() {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            ResultSet resultado = basedados.Selecao("select * from socio");

            while(resultado.next()){
                Socio aux = new Socio(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("morada"),
                        resultado.getDate("data_nascimento").toLocalDate(),
                        resultado.getInt("telefone")
                );
                socios.add(aux);
            }
            basedados.Desligar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarSociosParaBaseDados(){
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            //insere ou atualizar os registos
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");;
            for (Socio aux : socios) {
                if (aux.getPendenteGravacao()) {
                    basedados.Executar("DELETE FROM socio where id = " + aux.getNumMecanografico());
                    basedados.Executar("INSERT INTO socio " +
                            "(id, nome, morada, data_nascimento, telefone) values " +
                            "(" + aux.getNumMecanografico() + ", '" + aux.getNome() + "', '" + aux.getMorada() + "', '" + aux.getDataDeNascimento().format(formatter) + "', '" + aux.getTelefone() + "' )");
                }
            }

            //eliminar registos que foram apagados
            if (eliminados.size() > 0){
                for (Integer aux : eliminados) {
                    basedados.Executar("DELETE FROM socio where id = '" + aux + "'");
                }
                eliminados.clear(); //apago o array porque já foi processado
            }

            basedados.Desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public boolean adicionarSocio(String nome, String morada, LocalDate dataDeNascimento, int telefone) {

        Socio socio = new Socio(nome, morada, dataDeNascimento, telefone);
        socio.setPendenteGravacao(true);
        socios.add(socio);
        return true;
    }

    public ArrayList<Socio> listarSocio() {
        return socios;

    }

    public boolean editarSocio(int numMecanografico, String nome, String morada, LocalDate dataDeNascimento, int telefone) {
        for (Socio socio : socios) {
            if (numMecanografico == (socio.getNumMecanografico())) {
                socio.setNome(nome);
                socio.setMorada(morada);
                socio.setDataDeNascimento(dataDeNascimento);
                socio.setTelefone(telefone);
                socio.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorNome(int numMecanografico, String nome) {
        for (Socio socio : socios) {
            if (numMecanografico == (socio.getNumMecanografico())) {
                socio.setNome(nome);
                socio.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorMorada(int numMecanografico, String novaMorada) {
        for (Socio socio : socios) {
            if (numMecanografico==(socio.getNumMecanografico())) {
                socio.setMorada(novaMorada);
                socio.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorDataDeNascimento(int numMecanografico, LocalDate novaDataDeNascimento) {
        for (Socio socio : socios) {
            if (numMecanografico==(socio.getNumMecanografico())) {
                socio.setDataDeNascimento(novaDataDeNascimento);
                socio.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorTelefone(int numMecanografico, int novaTelefone) {
        for (Socio socio : socios) {
            if (numMecanografico == (socio.getNumMecanografico())) {
                socio.setTelefone(novaTelefone);
                socio.setPendenteGravacao(true);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Socio> pesquisarSocioPorNome(String nomeInserido) {
        ArrayList<Socio> nomeSocio = new ArrayList<>();
        for (Socio nome : socios) {
            if (nomeInserido.equalsIgnoreCase(nome.getNome())) {
                nomeSocio.add(nome);
            }
        }
        return nomeSocio;
    }

    public Socio pesquisarSocioPorNumMecanografico(int numMecanografico) {
        for (Socio socio : socios) {
            if (numMecanografico == socio.getNumMecanografico()) {
                return socio;
            }
        }
        return null;
    }

    public boolean removerSocio(int numMecanografico) {
        boolean encontrouReserva = false;
        // percorrer as reservas para ver se encontra alguma reserva associada ao sócio
        for (Reserva reserva : ControllerReservas.reservas) {
            if (numMecanografico == reserva.getSocio().getNumMecanografico()) {
                encontrouReserva = true;
                break;
            }
        }
        // não encontrou o sócio a ser removido
        if (!encontrouReserva) {
            // percorrer os sócios para encontrar o sócio a ser removido
            //função sugerida pelo intelij que usa a função lambda "removeIf" para remover os sócios que não possuem reservas
            //expressão lambda "removeIf"
            eliminados.add(numMecanografico);
            socios.removeIf(socio -> numMecanografico == (socio.getNumMecanografico()));
        }
        return encontrouReserva;
    }

}