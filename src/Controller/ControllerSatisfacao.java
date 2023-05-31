package Controller;

import Model.Reserva;
import Model.Satisfacao;
import Utilidades.GestorFicheiros;
import View.Satisfacao.ViewSatisfacao;

import java.util.ArrayList;

public class ControllerSatisfacao {
    private ArrayList<Satisfacao> satisfacoes = new ArrayList<>();

    public ArrayList<Satisfacao> listarSatisfacoes() {
        return satisfacoes;
    }

    public void lerSatisfacaoDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("Satisfacao.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");

                String nota = value_split[0];
                String observacao = value_split[1];
                String idReserva = value_split[2];

                Satisfacao satisfacao = new Satisfacao(nota, observacao, idReserva);
                satisfacoes.add(satisfacao);
            }
        }
    }

    public void gravarSatisfacaoParaFicheiro() {
        StringBuilder conteudo = new StringBuilder();
        for (Satisfacao satisfacao : satisfacoes) {
            conteudo.append(satisfacao.getNota()).append("|");
            conteudo.append(satisfacao.getObservacao()).append("|");
            conteudo.append(satisfacao.getIdReserva()).append("\n");
        }
        GestorFicheiros.gravarFicheiro("Satisfacao.txt", conteudo.toString());
    }

    public boolean adicionarSatisfacao(String nota, String observacao, String idReserva) {
        Satisfacao satisfacao = new Satisfacao(nota, observacao, idReserva);
        satisfacoes.add(satisfacao);
        return true;
    }


}
