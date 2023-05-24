package View.SuperAdministrador;

import Controller.ControllerLogin;
import Controller.ControllerSuperAdministrador;

import static Utilidades.Leitura.leStr;

public class ViewRegistrarAdministrador {


        ControllerSuperAdministrador controllersuperadministrador = new ControllerSuperAdministrador();

        public void registarAdministrador() {
            System.out.println("## Adicionar Administrador ##");
            System.out.println("------------------------");


            String email = leStr("Email :");

            String password = leStr("Password :");
            boolean adicionado = ControllerSuperAdministrador.adicionarAdministrador(email, password);

            if(adicionado){
                System.out.println("Administrador registado com sucesso!");
            } else{
                System.out.println("erro ao sjd");
            }
           // controllersuperadministrador.adicionarAdministrador(email, password);

            System.out.println("Administrador registado com sucesso!");
            controllersuperadministrador.gravarAdministradorParaFicheiro();
            System.out.println();
        }


}
