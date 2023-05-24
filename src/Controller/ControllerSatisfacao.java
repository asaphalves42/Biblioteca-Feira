package Controller;

import Model.Satisfacao;
import Model.Utilizador;
import Utilidades.GestorFicheiros;
import View.Satisfacao.ViewSatisfacao;
import Model.Reserva;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerSatisfacao {
    public static ArrayList<Satisfacao> satisfacoes = new ArrayList<>();


    public ArrayList<Satisfacao> listarUtilizadores() {

        return satisfacoes;

    }


    public void lerSatisfacaoDeFicheiro() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("Satisfacoes.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");

                Satisfacao aux = new Satisfacao(value_split[0], value_split[1]);
                satisfacoes.add(aux);
            }
        }
    }




    public void gravarSatisfacaoParaFicheiro() {
        String conteudo = "";
        for (Satisfacao aux : satisfacoes) {
            conteudo += aux.getNota() + "|";
            conteudo += aux.getObservacao() + "\n";
        }
        GestorFicheiros.gravarFicheiro("Satisfacao.txt", conteudo);
    }



    public static boolean adicionarSatisfacao(String nota, String observacao) {

            Satisfacao satisfacao = new Satisfacao(nota, observacao);
            satisfacoes.add(satisfacao);
            return true;


    }











}
