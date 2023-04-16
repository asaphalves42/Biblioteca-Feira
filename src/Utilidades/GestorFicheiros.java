package Utilidades;

import java.io.*;
import java.util.ArrayList;

public class GestorFicheiros {

    public static boolean GravarFicheiro (String nomeFicheiro, String conteudo)
    {
        try {
            String caminhoCompleto = System.getProperty("user.dir") + "\\" + nomeFicheiro;
            FileWriter myWriter = new FileWriter(caminhoCompleto);
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
            String caminhoCompleto = System.getProperty("user.dir") + "\\" + nomeFicheiro;
            File myObj = new File(caminhoCompleto);
            if (myObj.exists()) {
                BufferedReader bf = new BufferedReader(
                        new FileReader(caminhoCompleto));

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



