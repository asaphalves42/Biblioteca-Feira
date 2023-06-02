package View.Socios;

import Controller.ControllerSocios;
import Model.Socio;

import static Controller.ControllerSocios.socios;
import static Utilidades.Leitura.leInt;

public class ViewFuncaoRemoverSocios {
    public void removerSocioPorNumMecanografico(ControllerSocios gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                for (Socio sociosListados : socios) {
                    System.out.println(sociosListados);
                }
                int numSocio = leInt("Insira o número mecanográfico do sócio que deseja remover (ou digite '0' para sair):");
                if (numSocio == 0) {
                    break;
                }
                    boolean removido = gestor.removerSocio(numSocio);

                    if (removido) {
                        System.out.println("Não foi possível remover o sócio, existe uma reserva associada!\n");
                    } else {
                        System.out.println("Sócio removido com sucesso!\n");
                        sair = true;  // Sócio removido com sucesso, então sair do loop
                    }
                }catch (Exception e) {
                System.out.println("Ocorreu um erro ao remover o sócio: " + e.getMessage() + "\n");
            }
            }
        }
    }



