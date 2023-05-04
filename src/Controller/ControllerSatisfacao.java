package Controller;

import Model.Satisfacao;
import View.Satisfacao.ViewSatisfacao;

import java.io.FileWriter;
import java.io.IOException;

public class ControllerSatisfacao {
    private Satisfacao satisfacao;
    private ViewSatisfacao view;

    public ControllerSatisfacao(Satisfacao satisfacao, ViewSatisfacao view) {
        this.satisfacao = satisfacao;
        this.view = view;
    }

    public void executar() {
        int avaliacao = view.obterSatisfacao();
        satisfacao.setSatisfacao(avaliacao);
        String observacao = view.obterObservacao();
        satisfacao.setObservacao(observacao);
        escreverNoFicheiro();
        view.mostrarMensagem();
    }

    private void escreverNoFicheiro() {
        try {
            FileWriter writer = new FileWriter("satisfacao.txt", true);
            int avaliacao = satisfacao.getSatisfacao();
            String observacao = satisfacao.getObservacao();
            writer.write("Satisfacao: " + avaliacao +  "  Observação: "+ observacao +"\n" );
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
