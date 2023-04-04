package Controller;

import Model.Livro;


import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;

public class LerFicheirosLivros {
    static String pastaFicheiros = "C:\\aplicacao\\biblioteca";

    public void lerFicheiros() {
        ArrayList<Livro> listaLivros = new ArrayList<>();

            try {

                File myObj = new File(pastaFicheiros + "\\LivrosBiblioteca.txt");
                if (myObj.exists()) {
                    System.out.println("File name: " + myObj.getName());
                    System.out.println("Absolute path: " + myObj.getAbsolutePath());
                    System.out.println("Writeable: " + myObj.canWrite());
                    System.out.println("Readable " + myObj.canRead());
                    System.out.println("File size in bytes " + myObj.length());

                    BufferedReader bf = new BufferedReader(
                            new FileReader(pastaFicheiros + "\\LivrosBiblioteca.txt"));

                    // read entire line as string
                    String line = bf.readLine();
                    System.out.println(line);

                    // checking for end of file
                    while (line != null) {
                        line = bf.readLine();
                        System.out.println(line);
                    }

                } else {
                    System.out.println("The file does not exist.");
                }
                /*
                // 1. Ler o ficheiro equipas que esta na pasta
                Scanner scanner = new Scanner(new FileReader(pastaFicheiros + "\\LivrosBiblioteca.txt"));
                System.out.println("----3----");
                while (scanner.hasNext()) {
                    System.out.println("----4----");
                    // 1.1 Após lido a linha vou dividir o texto pelo separador |
                    String[] linhaLivro = scanner.next().split("\\|");

                    // 1.2 Crio uma novo equipa com os dados lidos
                    Livro novo = new Livro();
                    novo.setTitulo(linhaLivro[0]);
                    novo.setSubtitulo(linhaLivro[1]);
                    novo.setAutor(linhaLivro[2]);
                    novo.setNumDePaginas(Integer.parseInt(linhaLivro[3]));
                    novo.setCategoria(linhaLivro[4]);

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    novo.setDataDePublicacao(formatter.parse(linhaLivro[5]));

                    novo.setFaixaEtaria(linhaLivro[6]);
                    novo.setEditora(linhaLivro[7]);
                    novo.setISBN(linhaLivro[8]);

                    listaLivros.add(novo);

                }
                */
            } catch (Exception ex) {
                System.out.println("Ocorreu um erro a ler ficheiro. \n" + ex.getMessage());
            }
        }

}



