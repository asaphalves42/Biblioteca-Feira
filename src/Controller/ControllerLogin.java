package Controller;

import Model.Utilizador;
import View.ViewLogin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ControllerLogin {
    private ViewLogin viewLogin;

    public ControllerLogin(ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
    }


    public boolean iniciar() {
        while (true) {
            String email = viewLogin.getEmail();
            String password = viewLogin.getPassword();
            Utilizador user = obterUtilizadorPorEmail(email);

            if (user != null && user.getPassword().equals(password)) {
                viewLogin.mostrarMensagemDeLoginComSucesso();
                return true;
            } else {
                viewLogin.mostrarMensagemDeLoginFalhado();
            }
        }
    }


    public void registar() {
        String email = viewLogin.getEmail();
        String password = viewLogin.getPassword();
        Utilizador user = obterUtilizadorPorEmail(email);

        if (user == null) {
            user = new Utilizador(email, password);
            user.guardarEmFicheiro();
            viewLogin.mostrarMensagemDeRegistoComSucesso();
        } else {
            viewLogin.mostrarMensagemDeRegistoFalhado();
        }
    }

    private Utilizador obterUtilizadorPorEmail(String email) {
        File file = new File("utilizadores.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String emailGuardado = parts[0];
                String passwordGuardada = parts[1];
                if (emailGuardado.equals(email)) {
                    return new Utilizador(emailGuardado, passwordGuardada);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro de utilizadores não encontrado.");
        }
        return null;
    }

    public void apagarFicheiro() {
        File file = new File("utilizadores.txt");
        file.delete();
    }
}
