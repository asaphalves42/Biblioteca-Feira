package Controller;

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


    public void lerUtilizadorDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("Utilizadores.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");

                Utilizador aux = new Utilizador(value_split[0], value_split[1],value_split[2]);
                utilizadores.add(aux);
            }
        }
    }




    public void gravarUtilizadorParaFicheiro() {
        String conteudo = "";
        for (Utilizador aux : utilizadores) {
            conteudo += aux.getEmail() + "|";
            conteudo += aux.getPassword() + "|";
            conteudo += aux.getId() + "\n";
        }
        GestorFicheiros.gravarFicheiro("Utilizadores.txt", conteudo);
    }



    public static boolean adicionarUtilizador(String email, String password,String id) {
        if (validarEmail(email)) {
            Utilizador utilizador = new Utilizador(email, password,id);
            utilizadores.add(utilizador);
            return true;
        }
        return false;
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
        }
        return false;
    }





}
