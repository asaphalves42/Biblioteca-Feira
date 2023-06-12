package View.Funcionario;

import Controller.ControllerLogin;

import static Utilidades.Leitura.leStr;

public class MenuViewRegistarFuncionario {
    public void menuRegistarFunc( ControllerLogin gestor) {

        String email = leStr("Insira o email do funcionario:");
        String password = leStr("Insira a password do funcionario:");

        boolean adicionado = gestor.adicionarFuncionario(email, password);

        if (adicionado){
            System.out.println("Funcionário adicionado com sucesso");
        }else{
            System.out.println("Erro ao adicionar funcinário");
        }

    }
}
