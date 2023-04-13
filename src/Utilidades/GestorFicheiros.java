package Utilidades;

import java.io.*;
import java.util.ArrayList;

public class GestorFicheiros {
    public static final String diretorioBase = "C:\\aplicacao\\biblioteca\\";

    public static boolean GravarFicheiro (String nomeFicheiro, String conteudo)
    {
        try {
            FileWriter myWriter = new FileWriter(diretorioBase + "\\" + nomeFicheiro);
            myWriter.write(conteudo);
            myWriter.close();
            System.out.println("Guardado com sucesso.");
            return true;
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<String> LerFicheiro (String nomeFicheiro)
    {
        ArrayList<String> linhas = new ArrayList<>();
        try {
            File myObj = new File(diretorioBase + "\\" +nomeFicheiro);
            if (myObj.exists()) {
                BufferedReader bf = new BufferedReader(
                        new FileReader(diretorioBase + "\\" +nomeFicheiro));

                String st;
                while ((st = bf.readLine()) != null){
                    linhas.add(st);
                }

            } else {
                System.out.println("O ficheiro nao existe!.");
            }

        } catch (Exception ex) {
            System.out.println("Ocorreu um erro a ler ficheiro. \n" + ex.getMessage());
        }
        return linhas;
    }

}



