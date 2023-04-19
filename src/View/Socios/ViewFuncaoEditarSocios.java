package View.Socios;

import Controller.ControllerSocios;
import Model.Socio;
import Utilidades.ValidacaoData;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.leStr;
import static Utilidades.Leitura.leint;

public class ViewFuncaoEditarSocios {

    public void editarSocioPorNumMecTodosOsCampos(ControllerSocios gestor) {

        String numMecanografico = leStr("Insira o número mecanográfico do sócio que pretende editar");
        ArrayList<Socio> socioEditar = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        if (socioEditar == null) {
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
                novoTelefone = leint("Insira o novo número de telefone");
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
        ArrayList<Socio> socioEditar = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        if (socioEditar == null) {
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
        ArrayList<Socio> socioEditarMorada = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);
        String novaMorada;
        if (socioEditarMorada == null) {
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
        ArrayList<Socio> socioEditarDataDeNascimento = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        LocalDate novaDataDeNascimento;
        if (socioEditarDataDeNascimento == null) {
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
        ArrayList<Socio> socioEditarTelefone = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        int novoTelefone = 0;
        if (socioEditarTelefone == null) {
            System.out.println("Não existem sócios com esse número");
            System.out.println(" ");
        } else {
            novoTelefone = 0;
            while (novoTelefone < 100000000 || novoTelefone > 999999999) {
                novoTelefone = leint("Insira o novo número de telefone");
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