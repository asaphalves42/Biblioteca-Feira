package Controller;

import Model.Administrador;
import Model.SuperAdministrador;
import Model.Utilizador;
import Utilidades.GestorFicheiros;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerSuperAdministrador {
    public static ArrayList<Administrador> administradores = new ArrayList<>();
    public static ArrayList<SuperAdministrador> superadministrador = new ArrayList<>();


    public ArrayList<Administrador> listarAdministradores() {

        return administradores;

    }

    public ArrayList<SuperAdministrador> listarSuperAdministradores() {

        return superadministrador;

    }


    public void lerAdministradorDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("Utilizadores.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");

                Administrador aux = new Administrador(value_split[0], value_split[1],value_split[2]);
                administradores.add(aux);
            }
        }
    }

    public void lerSuperAdministradorDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("SuperAdministrador.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");

                SuperAdministrador aux = new SuperAdministrador(value_split[0], value_split[1]);
                superadministrador.add(aux);
            }
        }
    }

    public void gravarAdministradorParaFicheiro() {
        String conteudo = "";
        for (Administrador aux : administradores) {
            conteudo += aux.getEmail() + "|";
            conteudo += aux.getPassword() + "|";
            conteudo+= aux.getId() + "\n";
        }
        GestorFicheiros.gravarFicheiro("Utilizadores.txt", conteudo);
    }

    public static boolean adicionarAdministrador(String email, String password, String id) {
        if (validarEmail(email)) {
            Administrador administrador = new Administrador(email, password,id);
            administradores.add(administrador);
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

    public static boolean removerAdministrador(String email) {
        for (Administrador administrador : administradores) {
            if (administrador.getEmail().equalsIgnoreCase(email)) {
                administradores.remove(administrador);
                return true;
            }
        }
        return false;
    }
    public boolean autenticarSuperAdministrador(String email, String password) {
        if (validarEmail(email)) {
            for (SuperAdministrador superadministrador : superadministrador) {
                if (superadministrador.getEmail().equalsIgnoreCase(email) && superadministrador.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }










    public boolean validarAdministrador(String email, String password){
        boolean validacao=true;
        if((email.equalsIgnoreCase("admin@admin.com")&& password.equalsIgnoreCase("admin"))){

        }else
            validacao=false;

        return validacao;
    }
}
