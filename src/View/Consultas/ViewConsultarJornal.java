package View.Consultas;

import Controller.ControllerConsultas;
import Controller.ControllerProdutos;
import Model.Jornal;

import static Utilidades.Leitura.leStr;

public class ViewConsultarJornal {

    public Jornal consultarJornal(ControllerProdutos gestor) {
        Jornal jornalSelecionado = null;

        while (jornalSelecionado == null) {
            for (Jornal jornal : gestor.listarProdutosJornal()) {
                System.out.println(jornal.toString());
            }

            String idJornalStr = leStr("Insira o ID do jornal que deseja consultar (ou 'sair' se quiser sair):");

            if (idJornalStr.equalsIgnoreCase("sair")) {
                break; // Sair do loop while
            }

            try {
                int idJornal = Integer.parseInt(idJornalStr);

                for (Jornal jornal : gestor.listarProdutosJornal()) {
                    if (jornal.getId() == idJornal) {
                        jornalSelecionado = jornal;
                        break;
                    }
                }

                if (jornalSelecionado == null) {
                    System.out.println("ID do jornal inválido! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido! Tente novamente.");
            }
        }

        return jornalSelecionado;
    }

    public void efetuarConsulta(Jornal jornalSelecionado, ControllerConsultas gerirConsultas) {
        if (jornalSelecionado == null) {
            System.out.println("Nenhum jornal selecionado para consulta.");
        } else {
            // Realize as ações necessárias para a consulta do jornal selecionado

            boolean sucesso = gerirConsultas.consultarProdutos(jornalSelecionado);

            if(sucesso) {
                System.out.println("Consulta do jornal realizada com sucesso!");
            }else {
                System.out.println("Ocorreu um erro ao realizar consulta!");
            }

        }
    }


}
