package Controller;

import Model.Satisfacao;
import View.Satisfacao.ViewSatisfacao;
import Model.Reserva;

import java.io.FileWriter;
import java.io.IOException;

public class ControllerSatisfacao {
    private Satisfacao satisfacao;
    private ViewSatisfacao view;


    public ControllerSatisfacao(Satisfacao satisfacao, ViewSatisfacao view) {
        this.satisfacao = satisfacao;
        this.view = view;
    }

    public void executar(Reserva reserva) {
        int avaliacao = view.obterSatisfacao();
        satisfacao.setSatisfacao(avaliacao);
        String observacao = view.obterObservacao();
        satisfacao.setObservacao(observacao);
        escreverNoFicheiro(reserva);
        view.mostrarMensagem();
    }



    private void escreverNoFicheiro(Reserva reserva) {
        try {
            FileWriter writer = new FileWriter("satisfacao.txt", true);
            //Embelezamento de codigo
            int avaliacao = satisfacao.getSatisfacao();
            String observacao = satisfacao.getObservacao();
            int numMecanografico = reserva.getSocio().getNumMecanografico();

            writer.write("Satisfacao: " + avaliacao +  "  Observação: "+ observacao + "  Num. Mecanográfico: " + numMecanografico + "\n" );
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
