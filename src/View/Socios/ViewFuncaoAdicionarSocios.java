package View.Socios;

import Controller.ControllerSocios;
import Utilidades.ValidacaoData;

import java.time.LocalDate;

import static Utilidades.Leitura.*;

public class ViewFuncaoAdicionarSocios {

    public void adicionarsocios(ControllerSocios gestorSocio) {
        String nome = "";
        while (nome.trim().isEmpty()) {
            nome = LeStr("Introduza o nome: ");
            if (nome.trim().isEmpty()) {
                System.out.println("Por favor, introduza um nome válido!");
            }
        }

        String morada = "";
        while (morada.trim().isEmpty()) {
            morada = LeStr("Introduza morada: ");
            if (morada.trim().isEmpty()) {
                System.out.println("Por favor, introduza uma morada válida!");
            }
        }

        LocalDate dataDeNascimento = null;
        while (dataDeNascimento == null) {

            System.out.println("Insira a data de nascimento do sócio");
            ValidacaoData validarData = new ValidacaoData();
            dataDeNascimento = validarData.LerData2();
        }

        int telefone = 0;
        while (telefone < 100000000 || telefone > 999999999) {
            telefone = LeInt("Introduza o nr de telefone (9 dígitos): ");
            if (telefone < 100000000 || telefone > 999999999) {
                System.out.println("Por favor, introduza um número de telefone com 9 dígitos!");
            }
        }

        System.out.println(" ");
        System.out.println("Sócio adicionado com sucesso!");
        System.out.println(" ");

        gestorSocio.adicionarSocio(nome, morada, dataDeNascimento, telefone);

    }
}