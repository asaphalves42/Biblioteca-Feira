package View.Socios;

import Controller.ControllerSocios;
import Model.Socio;

import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoRemoverSocios {
    public void removerSocioPorNumMecanografico(ControllerSocios gestor) {

        String nomeSocio = leStr("Insira o nome do socio:");
        ArrayList<Socio> socioParaRemover = gestor.pesquisarSocioPorNome(nomeSocio);

        if (socioParaRemover.isEmpty()) {
            System.out.println("Não existem sócios listados");
            System.out.println(" ");

        } else {
           for(Socio socio : socioParaRemover){
               System.out.println(socio.toString());
           }
        }

        int numSocio = leInt("Insira o número mecanografico do sócio que quer remover:");

        boolean removido = gestor.removerSocio(numSocio);

        if (removido) {
            System.out.println("Não foi possível remover o socio, existe uma reserva associada!");
            System.out.println(" ");
        } else {
            System.out.println("Sócio removido com sucesso!");
            System.out.println(" ");
        }
    }

}

