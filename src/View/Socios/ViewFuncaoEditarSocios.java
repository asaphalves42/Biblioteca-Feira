package View.Socios;

import Controller.ControllerSocios;
import Model.Socio;
import Utilidades.ValidacaoData;

import java.time.LocalDate;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoEditarSocios {

   public void editarSocio(ControllerSocios gestor) {

       boolean sair = false;
       do{

        String numMecanografico = leStr("Insira o número mecanográfico do sócio que pretende editar");
        Socio socioEditar = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        if (socioEditar == null) {
            System.out.println("Não existem sócios com esse número");
            System.out.println(" ");
        }else {
            System.out.println("Caso pretenda sair, digite 'sair'");
        }
            String novoNome = "";
            while (novoNome.trim().equals("")) {
                novoNome = leStr("Insira o novo nome do sócio");
            }

            String novaMorada = "";
            while (novaMorada.trim().equals("")) {
                novaMorada = leStr("Insira a nova morada do sócio");
                if(novaMorada.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
            }
            if (sair) {
                break;
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

        }while (!sair);
    }
}