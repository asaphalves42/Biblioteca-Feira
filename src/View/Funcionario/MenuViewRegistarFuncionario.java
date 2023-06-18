package View.Funcionario;

import Controller.ControllerLogin;

import static Utilidades.Leitura.leStr;

public class MenuViewRegistarFuncionario {
    public void menuRegistarFunc(ControllerLogin gestor) {
        try {
            String email = leStr("Insira o email do funcionário:");
            String password = leStr("Insira a senha do funcionário:");

            boolean adicionado = gestor.adicionarFuncionario(email, password);

            if (adicionado) {
                System.out.println("Funcionário adicionado com sucesso!\n");
            } else {
                System.out.println("Erro ao adicionar funcionário!\n");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

}
