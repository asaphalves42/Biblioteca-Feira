package Utilidades;

import java.io.*;
import java.util.ArrayList;

public class GestorFicheiros {


    public static boolean GravarFicheiro (String diretorio, String nomeFicheiro, String conteudo)
    {
        try {
            FileWriter myWriter = new FileWriter(diretorio + "\\" + nomeFicheiro);
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

    public static ArrayList<String> LerFicheiro (String diretorio, String nomeFicheiro)
    {
        ArrayList<String> linhas = new ArrayList<String>();
        try {
            File myObj = new File(diretorio + "\\" +nomeFicheiro);
            if (myObj.exists()) {
                BufferedReader bf = new BufferedReader(
                        new FileReader(diretorio + "\\" +nomeFicheiro));

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


    /*
    static String pastaFicheiros = "C:\\aplicacao\\biblioteca";
    public ArrayList<Livro> LerLivros() {
        ArrayList<Livro> listaLivros = new ArrayList<>();

            try {

                File myObj = new File(pastaFicheiros + "\\LivrosBiblioteca.txt");
                if (myObj.exists()) {

                    BufferedReader bf = new BufferedReader(
                            new FileReader(pastaFicheiros + "\\LivrosBiblioteca.txt"));

                    String st;
                    while ((st = bf.readLine()) != null){

                        String[] value_split = st.split("\\|");

                        Livro aux = new Livro(value_split[0],
                                value_split[1],
                                Integer.parseInt(value_split[2]),
                                value_split[3],
                                Integer.parseInt(value_split[4]),
                                value_split[5],
                                new Date(value_split[6]),
                                value_split[7],
                                value_split[8],
                                value_split[9]);

                        listaLivros.add(aux);
                    }

                } else {
                    System.out.println("O ficheiro nao existe!.");
                }

            } catch (Exception ex) {
                System.out.println("Ocorreu um erro a ler ficheiro. \n" + ex.getMessage());
            }

            return listaLivros;
        }
    public void gravarFicheiroLivros(ArrayList<Livro> livros){


            try {
                File myObj = new File(pastaFicheiros + "\\LivrosBiblioteca.txt");
                if (myObj.createNewFile()) {
                    System.out.println("Ficheiro criado: " + myObj.getName());
                } else {
                    System.out.println("Ficheiro já existente!");
                }

                FileWriter myWriter = new FileWriter(pastaFicheiros + "\\LivrosBiblioteca.txt");
                String conteudo = "";
                for (Livro aux : livros){
                    SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String formated_date = DateFormat.format(aux.getDataDePublicacao());

                    conteudo += aux.getTitulo() + "|" ;
                    conteudo += aux.getSubtitulo() + "|" ;
                    conteudo += aux.getQuantidade() + "|" ;
                    conteudo += aux.getAutor() + "|" ;
                    conteudo += aux.getNumDePaginas() + "|" ;
                    conteudo += aux.getCategoria() + "|" ;
                    conteudo += formated_date + "|" ;
                    conteudo += aux.getFaixaEtaria() + "|" ;
                    conteudo += aux.getEditora() + "|" ;
                    conteudo += aux.getISBN() +  "\n";
                }
                myWriter.write(conteudo);
                myWriter.close();
                System.out.println("Guardado com sucesso.");
            } catch (IOException e) {
                System.out.println("Ocorreu um erro.");
                e.printStackTrace();
            }
    }
    */
}



