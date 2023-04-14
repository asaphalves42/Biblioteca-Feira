package View.Socios;


import Controller.ControllerSocios;
import Model.Autor;
import Model.Socio;

import java.util.ArrayList;

import static Utilidades.Leitura.LeStr;

public class ViewFunçãoRemoverSocios {
    public void removerSocioPorNumMecanografico(ControllerSocios gestor) {

        String numMecanografico = LeStr("Insira número mecanográfico do socio");
        ArrayList<Socio> socioParaRemover = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

        if (socioParaRemover.isEmpty()) {
            System.out.println("Não existem sócios listados");
            System.out.println(" ");
        } else {
            boolean socioEncontrado = false;
            for (Socio socio : socioParaRemover) {
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

        String nomeSocio= LeStr("Insira o número mecanografico do sócio que quer remover");

        boolean removido = gestor.removerSocio(numMecanografico);

        if (removido) {
            System.out.println("Autor(a) eliminado com sucesso");
            System.out.println("");
        } else {
            System.out.println("Autor(a) não encontrado(a)");
            System.out.println("");
        }
    }

}
