package Controller;
import Model.Utilizador;
import View.Login.ViewLogin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static Utilidades.Leitura.ler;
public class ControllerLoginSuperAdministrador {
    private ViewLogin viewLogin;
    private ControllerLogin controllerLogin;
    public ControllerLoginSuperAdministrador(ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
        controllerLogin = new ControllerLogin(new ViewLogin());

    }
    public boolean registarAdm(){
        boolean registoAdmBemSucedido = false;

        while (!registoAdmBemSucedido) {
            String email = viewLogin.getEmail();
            String password = viewLogin.getPassword();

            if (!controllerLogin.validarEmail(email)) {
                viewLogin.tentativaEmail();
                String resposta = ler.next();
                if (!resposta.equalsIgnoreCase("S")) {
                    break;
                }
                continue;
            }

            try {
                PrintWriter writer = new PrintWriter(new FileOutputStream(new File("superadministrador.txt"), true));
                writer.println(email + "," + password);
                writer.close();
                registoAdmBemSucedido = true;
            } catch (FileNotFoundException e) {
                registoAdmBemSucedido = false;
            }
        }

        return registoAdmBemSucedido;



    }



}
