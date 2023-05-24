package Controller;

import Model.Administrador;
import Model.Utilizador;
import Utilidades.GestorFicheiros;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerAdministrador {
    public static ArrayList<Administrador> administradores = new ArrayList<>();

    public boolean autenticarAdministrador(String email, String password) {
        if (validarEmail(email)) {
            for (Administrador administrador : administradores) {
                if (administrador.getEmail().equalsIgnoreCase(email) && administrador.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void lerAdministradorDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("Administradores.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");

                Administrador aux = new Administrador(value_split[0], value_split[1]);
                administradores.add(aux);
            }
        }
    }


    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
