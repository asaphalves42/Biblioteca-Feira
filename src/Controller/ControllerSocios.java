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


    public void gravarSociosParaBaseDados(Socio socio, boolean atualizacao){
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();

            String script = "";
            if (atualizacao) {
                script = "UPDATE socio set nome = '@02', morada = '@03', data_nascimento = '@04', telefone = @05 where id = @01";
            }
            else
            {
                script = "INSERT INTO socio (id, nome, morada, data_nascimento, telefone)" +
                        " VALUES (@01, '@02', '@03', '@04', @05)";
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");;

            script = script.replace("@01", String.valueOf(socio.getNumMecanografico()));
            script = script.replace("@02", socio.getNome());
            script = script.replace("@03",  socio.getMorada());
            script = script.replace("@04",  socio.getDataDeNascimento().format(formatter));
            script = script.replace("@05",  String.valueOf(socio.getTelefone()));

            for (int i = 30; i > 0; i--) {
                script = script.replace("'@"+String.format("%02d", i)+"'", "NULL");
                script = script.replace("@"+String.format("%02d", i), "NULL");
            }

            // executar o SCRIPT na base de dados
            basedados.Executar(script);
            basedados.Desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removerSocioBaseDados(int idSocio){
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();

            basedados.Executar("DELETE FROM socio where id = '" +idSocio + "'");

            basedados.Desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public boolean adicionarSocio(String nome, String morada, LocalDate dataDeNascimento, int telefone) {

        Socio socio = new Socio(nome, morada, dataDeNascimento, telefone);
        socios.add(socio);
        gravarSociosParaBaseDados(socio, false);
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
                gravarSociosParaBaseDados(socio, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorNome(int numMecanografico, String nome) {
        for (Socio socio : socios) {
            if (numMecanografico == (socio.getNumMecanografico())) {
                socio.setNome(nome);
                gravarSociosParaBaseDados(socio, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorMorada(int numMecanografico, String novaMorada) {
        for (Socio socio : socios) {
            if (numMecanografico==(socio.getNumMecanografico())) {
                socio.setMorada(novaMorada);
                gravarSociosParaBaseDados(socio, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorDataDeNascimento(int numMecanografico, LocalDate novaDataDeNascimento) {
        for (Socio socio : socios) {
            if (numMecanografico==(socio.getNumMecanografico())) {
                socio.setDataDeNascimento(novaDataDeNascimento);
                gravarSociosParaBaseDados(socio, true);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorTelefone(int numMecanografico, int novaTelefone) {
        for (Socio socio : socios) {
            if (numMecanografico == (socio.getNumMecanografico())) {
                socio.setTelefone(novaTelefone);
                gravarSociosParaBaseDados(socio, true);
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
            socios.removeIf(socio -> numMecanografico == (socio.getNumMecanografico()));
            removerSocioBaseDados(numMecanografico);
        }
        return encontrouReserva;
    }

}