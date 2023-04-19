package View.Socios;

import Controller.ControllerSocios;
import Model.Socio;
import Utilidades.ValidacaoData;

import java.time.LocalDate;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoEditarSocios {

    public void editarSocioPorNumMecTodosOsCampos(ControllerSocios gestor) {

        String numMecanografico = leStr("Insira o número mecanográfico do sócio que pretende editar");
        Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        if (socio == null) {
            System.out.println("Não existem sócios com esse número");
            System.out.println(" ");
        } else {
            String novoNome = "";
            while (novoNome.trim().equals("")) {
                novoNome = leStr("Insira o novo nome do sócio");
            }

            String novaMorada = "";
            while (novaMorada.trim().equals("")) {
                novaMorada = leStr("Insira a nova morada do sócio");
            }

            System.out.println("Digite a data de nascimento do sócio: ");
            ValidacaoData validarData = new ValidacaoData();
            LocalDate novaDataDeNascimento = validarData.LerData2();

            int novoTelefone = 0;
            while (novoTelefone < 100000000 || novoTelefone > 999999999) {
                novoTelefone = leInt("Insira o novo número de telefone");
            }


            boolean editado = gestor.editarSocio(numMecanografico, novoNome, novaMorada, novaDataDeNascimento, novoTelefone);

            if (editado) {
                System.out.println("Sócio editado com sucesso");
                System.out.println(" ");
            } else {
                System.out.println("Sócio não editado");
                System.out.println(" ");

            }

        }
    }

    public void editarNomeSocioPorNumMecanografico(ControllerSocios gestor) {
        String numMecanografico = leStr("Insira o número mecanográfico do sócio que pretende editar");
        Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        if (socio == null) {
            System.out.println("Não existem sócios com esse número");
            System.out.println(" ");
        } else {
            String novoNome = "";
            while (novoNome.trim().equals("")) {
                novoNome = leStr("Insira o novo nome do sócio");
            }
            boolean editado = gestor.editarSocioPorNome(numMecanografico, novoNome);
            if (editado) {
                System.out.println("Sócio editado com sucesso");
                System.out.println(" ");
            } else {
                System.out.println("Sócio não editado");
                System.out.println(" ");

            }
        }
    }

    public void editarMoradaSocioPorNumMecanografico(ControllerSocios gestor) {
        String numMecanografico = leStr("Insira o número mecanográfico do sócio que pretende editar");
        Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);
        String novaMorada;
        if (socio == null) {
            System.out.println("Não existem sócios com esse número");
            System.out.println(" ");
            return;
        } else {
            novaMorada = "";
            while (novaMorada.trim().equals("")) {
                novaMorada = leStr("Insira a nova morada do sócio");
            }
        }
        boolean editado = gestor.editarSocioPorMorada(numMecanografico, novaMorada);
        if (editado) {
            System.out.println("Sócio editado com sucesso");
            System.out.println(" ");
        } else {
            System.out.println("Sócio não editado");
            System.out.println(" ");
        }
    }

    public void editarDataDeNascimentoSocioPorNumMecanografico(ControllerSocios gestor) {
        String numMecanografico = leStr("Insira o número mecanográfico do sócio que pretende editar");
        Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        LocalDate novaDataDeNascimento;
        if (socio == null) {
            System.out.println("Não existem sócios com esse número");
            System.out.println(" ");
            return;
        } else {
            System.out.println("Digite a data de nascimento do sócio: ");
            ValidacaoData validarData = new ValidacaoData();
            novaDataDeNascimento = validarData.LerData2();
        }
        boolean editado = gestor.editarSocioPorDataDeNascimento(numMecanografico, novaDataDeNascimento);
        if (editado) {
            System.out.println("Sócio editado com sucesso");
            System.out.println(" ");

        } else {
            System.out.println("Sócio não editado");
            System.out.println(" ");
        }
    }

    public void editarTelefoneSocioPorNumMecanografico(ControllerSocios gestor) {
        String numMecanografico = leStr("Insira o número mecanográfico do sócio que pretende editar");
        Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        int novoTelefone = 0;
        if (socio == null) {
            System.out.println("Não existem sócios com esse número");
            System.out.println(" ");
        } else {
            novoTelefone = 0;
            while (novoTelefone < 100000000 || novoTelefone > 999999999) {
                novoTelefone = leInt("Insira o novo número de telefone");
            }
        }
        boolean editado = gestor.editarSocioPorTelefone(numMecanografico, novoTelefone);
        if (editado) {
            System.out.println("Sócio editado com sucesso");
            System.out.println(" ");
        } else {
            System.out.println("Sócio não editado");
            System.out.println(" ");
        }


    }
}