package Controller;


import Model.Reserva;
import Model.Socio;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerSocios {
    public static ArrayList<Socio> socios = new ArrayList<>();

    public void lerSociosDoFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("socios.txt");
        for (String linha : linhas) {
            if (linha.isEmpty() == false) {
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

    public void verificarNumMecanografico() {
        int max = 0;
        for (Socio id : socios) {
            if (id.getNumMecanografico() > max) {
                max = id.getNumMecanografico();
            }
        }
    }

    public void adicionarSocio(String nome, String morada, LocalDate dataDeNascimento, int telefone) {
        this.verificarNumMecanografico();
        Socio socio = new Socio(nome, morada, dataDeNascimento, telefone);
        socios.add(socio);
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
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorNome(int numMecanografico, String nome) {
        for (Socio socio : socios) {
            if (numMecanografico == (socio.getNumMecanografico())) {
                socio.setNome(nome);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorMorada(int numMecanografico, String novaMorada) {
        for (Socio socio : socios) {
            if (numMecanografico==(socio.getNumMecanografico())) {
                socio.setMorada(novaMorada);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorDataDeNascimento(int numMecanografico, LocalDate novaDataDeNascimento) {
        for (Socio socio : socios) {
            if (numMecanografico==(socio.getNumMecanografico())) {
                socio.setDataDeNascimento(novaDataDeNascimento);
                return true;
            }
        }
        return false;
    }

    public boolean editarSocioPorTelefone(int numMecanografico, int novaTelefone) {
        for (Socio socio : socios) {
            if (numMecanografico == (socio.getNumMecanografico())) {
                socio.setTelefone(novaTelefone);
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
            }
        }
        // não encontrou o sócio a ser removido
        if (!encontrouReserva) {
            // percorrer os sócios para encontrar o sócio a ser removido
            //função sugerida pelo intelij que usa a função lambda "removeIf" para remover os sócios que não possuem reservas
            //expressão lambda "removeIf"
            socios.removeIf(socio -> numMecanografico == (socio.getNumMecanografico()));
        }
        return encontrouReserva;
    }

}