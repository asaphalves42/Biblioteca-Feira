package Controller;

import Model.Autor;
import Model.Utilizador;
import Utilidades.GestorFicheiros;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerLogin {
    public static ArrayList<Utilizador> utilizadores = new ArrayList<>();


    public ArrayList<Utilizador> listarUtilizadores() {

        return utilizadores;

    }

    public ArrayList<Utilizador> pesquisarUtilizadorPorEmail(String emailinserido) {
        ArrayList<Utilizador> utilizadoresEncontrados = new ArrayList<>();
        for (Utilizador utilizador : utilizadores) {
            if (emailinserido == utilizador.getEmail()) {
                utilizadoresEncontrados.add(utilizador);
            }
        }
        return utilizadoresEncontrados;
    }
    public void lerUtilizadorDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("Utilizadores.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");

                Utilizador aux = new Utilizador(value_split[0], value_split[1]);
                utilizadores.add(aux);
            }
        }
    }




    public void gravarUtilizadorParaFicheiro() {
        String conteudo = "";
        for (Utilizador aux : utilizadores) {
            conteudo += aux.getEmail() + "|";
            conteudo += aux.getPassword() + "\n";
        }
        GestorFicheiros.gravarFicheiro("Utilizadores.txt", conteudo);
    }



    public static void adicionarUtilizador(String email, String password) {
        if (validarEmail(email)) {
            Utilizador utilizador = new Utilizador(email, password);
            utilizadores.add(utilizador);
        } else {
            System.out.println("Email inválido. Por favor, insira um email válido.");
        }
    }

    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean removerUtilizador(String email) {
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getEmail().equalsIgnoreCase(email)) {
                utilizadores.remove(utilizador);
                return true;
            }
        }
        return false;
    }




    public boolean autenticarUtilizador(String email, String password) {
        if (validarEmail(email)) {
            for (Utilizador utilizador : utilizadores) {
                if (utilizador.getEmail().equalsIgnoreCase(email) && utilizador.getPassword().equals(password)) {
                    return true;
                }
            }
        } else {
            System.out.println("Email inválido. Por favor, insira um email válido.");
        }
        return false;
    }
}
