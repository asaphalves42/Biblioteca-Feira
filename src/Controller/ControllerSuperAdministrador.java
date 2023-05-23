package Controller;

import Model.Administrador;
import Utilidades.GestorFicheiros;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerSuperAdministrador {
    public static ArrayList<Administrador> administradores = new ArrayList<>();


    public ArrayList<Administrador> listarAdministradores() {

        return administradores;

    }

    public ArrayList<Administrador> pesquisarAdministradorPorEmail(String emailinserido) {
        ArrayList<Administrador> administradoresEncontrados = new ArrayList<>();
        for (Administrador administrador : administradores) {
            if (emailinserido == administrador.getEmail()) {
                administradoresEncontrados.add(administrador);
            }
        }
        return administradoresEncontrados;
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




    public void gravarAdministradorParaFicheiro() {
        String conteudo = "";
        for (Administrador aux : administradores) {
            conteudo += aux.getEmail() + "|";
            conteudo += aux.getPassword() + "\n";
        }
        GestorFicheiros.gravarFicheiro("Administradores.txt", conteudo);
    }



    public static void adicionarAdministrador(String email, String password) {
        if (validarEmail(email)) {
            Administrador administrador = new Administrador(email, password);
            administradores.add(administrador);
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

    public static boolean removerAdministrador(String email) {
        for (Administrador administrador : administradores) {
            if (administrador.getEmail().equalsIgnoreCase(email)) {
                administradores.remove(administrador);
                return true;
            }
        }
        return false;
    }




    public boolean autenticarAdministrador(String email, String password) {
        if (validarEmail(email)) {
            for (Administrador administrador : administradores) {
                if (administrador.getEmail().equalsIgnoreCase(email) && administrador.getPassword().equals(password)) {
                    return true;
                }
            }
        } else {
            System.out.println("Email inválido. Por favor, insira um email válido.");
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
