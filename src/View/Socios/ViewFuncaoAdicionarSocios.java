package View.Socios;

import Controller.ControllerLogin;
import Controller.ControllerSocios;
import Utilidades.ValidacaoData;
import View.Login.RegistarSocio;

import java.time.LocalDate;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoAdicionarSocios {
    RegistarSocio registarSocio = new RegistarSocio();
    public ControllerLogin gestorLogin = new ControllerLogin();

    public void adicionarSocios(ControllerSocios gestorSocio) {
        boolean sair = false;
        do {
            try {
                System.out.println("Caso pretenda sair, digite 'sair'");
                String nome = "";
                while (nome.trim().isEmpty()) {
                    nome = leStr("Introduza o nome: ");
                    if (nome.equalsIgnoreCase("sair")) {
                        sair = true;
                        break;
                    }
                    if (nome.trim().isEmpty()) {
                        System.out.println("Por favor, introduza um nome válido!");
                    }
                }
                if (sair) {
                    break;
                }

                String morada = "";
                while (morada.trim().isEmpty()) {
                    morada = leStr("Introduza morada (Caso pretenda sair, digite 'sair')");
                    if (morada.equalsIgnoreCase("sair")) {
                        sair = true;
                        break;
                    }
                    if (morada.trim().isEmpty()) {
                        System.out.println("Por favor, introduza uma morada válida!");
                    }
                }

                if (sair) {
                    break;
                }

                System.out.println("Insira a data de nascimento do sócio (dd/MM/yyyy):");
                ValidacaoData validarData = new ValidacaoData();
                LocalDate dataDeNascimento = validarData.LerData2();

                int telefone = 0;
                while (telefone < 100000000 || telefone > 999999999) {
                    telefone = leInt("Introduza o nr de telefone (9 dígitos) (Caso pretenda sair, digite 'sair') : ");
                    String telefone2 = String.valueOf(telefone);
                    if (telefone2.equalsIgnoreCase("Sair")) {
                        sair = true;
                        break;
                    }
                    if (telefone < 100000000 || telefone > 999999999) {
                        System.out.println("Por favor, introduza um número de telefone com 9 dígitos!");
                    }
                }

                boolean registado = registarSocio.registarSocio(gestorLogin);

                if (registado) {
                    boolean adicionado = gestorSocio.adicionarSocio(nome, morada, dataDeNascimento, telefone);

                    if (adicionado) {
                        System.out.println("Sócio " + nome + " adicionado com sucesso!");
                        System.out.println(" ");
                    } else {
                        System.out.println("Ocorreu um erro ao adicionar o sócio!\n");
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao adicionar o sócio: " + e.getMessage());

            }

        } while (!sair);
    }
}