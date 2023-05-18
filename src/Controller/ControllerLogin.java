package Controller;

import Model.Utilizador;
import View.Login.ViewLogin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static Utilidades.Leitura.ler;

public class ControllerLogin {
    private ViewLogin viewLogin;
    private boolean isAdmin;

    public ControllerLogin(ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
        this.isAdmin = false;
    }

    public boolean iniciar() {
        boolean loginSucesso = false;

        while (!loginSucesso) {
            String email = viewLogin.getEmail();
            String password = viewLogin.getPassword();

            if (validarEmail(email) && obterUtilizadorPorEmail(email) != null && obterUtilizadorPorEmail(email).getPassword().equals(password)) {
                loginSucesso = true;
            } else {

               viewLogin.tentativaEmail();
                if (!ler.next().equalsIgnoreCase("S")) {
                    break;
                }
            }
        }
        return loginSucesso;
    }


    public boolean autenticarAdministrador() {
        System.out.println("Por favor, insira as credenciais de administrador:");
        System.out.print("Utilizador: ");
        String utilizador = ler.next();
        System.out.print("Senha: ");
        String senha = ler.next();

        // Verificar se as credenciais estão corretas
        if (utilizador.equals("admin@admin.pt") && senha.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }

    public boolean registar() {
        boolean registoBemSucedido = false;

        while (!registoBemSucedido) {
            String email = viewLogin.getEmail();
            String password = viewLogin.getPassword();

            if (!validarEmail(email)) {

                viewLogin.tentativaEmail();
                String resposta = ler.next();
                if (!resposta.equalsIgnoreCase("S")) {
                    break;
                }
                continue;
            }

            try {
                PrintWriter writer = new PrintWriter(new FileOutputStream(new File("utilizadores.txt"), true));
                writer.println(email + "," + password);
                writer.close();
                registoBemSucedido = true;
            } catch (FileNotFoundException e) {
                registoBemSucedido = false;
            }
        }

        return registoBemSucedido;
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
            viewLogin.erroFicheiroNaoEncontrado();
        }
        return null;
    }
    public void testeAdm(){

        boolean autenticado = autenticarAdministrador();
        if (autenticado) {
            registar();
        } else {
            System.out.println("Credenciais de administrador incorretas. Não é possível realizar o registo.");
        }
    }



}