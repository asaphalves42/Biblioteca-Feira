package View.Socios;

import Controller.ControllerSocios;
import Model.Socio;

import static Controller.ControllerSocios.socios;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoRemoverSocios {
    public void removerSocioPorNumMecanografico(ControllerSocios gestor) {

        String numMecanografico = leStr("Insira número mecanográfico do socio");
        Socio socioParaRemover = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        if (socioParaRemover==null) {
            System.out.println("Não existem sócios listados");
            System.out.println(" ");
        } else {
            boolean socioEncontrado = false;
            for (Socio socio : socios) {
                if (socio.getNumMecanografico().equals(numMecanografico)) {
                    System.out.println(socio);
                    socioEncontrado = true;
                    break;
                }
            }
            if (!socioEncontrado) {
                System.out.println("Socio não encontrado(a)");
                System.out.println(" ");
                return;
            }
        }

        String numSocio = leStr("Insira o número mecanografico do sócio que quer remover");

        boolean removido = gestor.removerSocio(numSocio);

        if (removido) {
            System.out.println("Sócio eliminado com sucesso");
            System.out.println(" ");
        } else {
            System.out.println("Sócio não encontrado(a)");
            System.out.println(" ");
        }
    }

}

