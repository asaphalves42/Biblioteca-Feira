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
        escreverNoFicheiro();
        view.mostrarMensagem();
    }

    private void escreverNoFicheiro() {
        try {
            FileWriter writer = new FileWriter("satisfacao.txt", true);
            int avaliacao = satisfacao.getSatisfacao();
            writer.write("Satisfacao: " + avaliacao + "\n" );
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
