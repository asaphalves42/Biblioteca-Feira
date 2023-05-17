package View.Socios;

import Controller.ControllerSocios;
import Model.Socio;

import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoRemoverSocios {
    public void removerSocioPorNumMecanografico(ControllerSocios gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                String nomeSocio = leStr("Insira o nome do sócio:");
                ArrayList<Socio> socioParaRemover = gestor.pesquisarSocioPorNome(nomeSocio);

                if (socioParaRemover.isEmpty()) {
                    System.out.println("Não existem sócios listados!\n");
                } else {
                    for (Socio socio : socioParaRemover) {
                        System.out.println(socio.toString());
                    }
                    int numSocio = leInt("Insira o número mecanográfico do sócio que deseja remover:");

                    boolean removido = gestor.removerSocio(numSocio);

                    if (removido) {
                        System.out.println("Não foi possível remover o sócio, existe uma reserva associada!\n");
                    } else {
                        System.out.println("Sócio removido com sucesso!\n");
                        sair = true;  // Sócio removido com sucesso, então sair do loop
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao remover o sócio: " + e.getMessage() + "\n");
            }
        }
    }
}


