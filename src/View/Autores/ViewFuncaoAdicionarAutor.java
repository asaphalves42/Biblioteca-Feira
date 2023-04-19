package View.Autores;

import Controller.ControllerAutores;
import Utilidades.ValidacaoData;

import java.time.LocalDate;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoAdicionarAutor {

    public void menuAdicionarAutores(ControllerAutores gestor) {

        boolean sair = false;
        do {

            System.out.println("Caso pretenda sair, digite 'sair'");
            String nome = "";
            while (nome.trim().isEmpty()) {
                nome = leStr("Insira o nome do(a) autor(a)");
                if (nome.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (nome.trim().isEmpty()) {
                    System.out.println("Por favor, introduza um valor válido para o nome!");
                }
            }
            if (sair) {
                break;
            }

            String morada = "";
            while (morada.trim().isEmpty()) {
                morada = leStr("Insira a morada do(a) autor(a)");
                if (morada.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (morada.trim().isEmpty()) {
                    System.out.println("Por favor, introduza um valor válido para a morada!");
                }
            }
            if (sair) {
                break;
            }

            if (!sair) {
                System.out.println("Insira a data de nascimento do autor: ");
                ValidacaoData validarData = new ValidacaoData();
                LocalDate dataDeNascimento = validarData.LerData2();

                System.out.println("Autor(a) " + nome + " adicionado(a) com sucesso!");
                System.out.println(" ");

                gestor.adicionarAutores(nome, morada, dataDeNascimento);
            }
        } while (!sair);
    }
}
