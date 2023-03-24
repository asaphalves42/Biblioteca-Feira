package Controller;

import Model.Livro;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class LerFicheiros {
    static String pastaFicheiros = "C:\\aplicacao\\biblioteca";
            public static void LerFicheiros() {
            // criar uma pasta -->
            // https://www.guj.com.br/t/criando-arquivos-e-diretorios/42487/2
            File file = new File(pastaFicheiros);
            if (!file.exists()) {
                file.mkdirs();
            }
            // esta dentro de um try porque vai tentar ler o ficheiro, se der erro salta
            // ate
            // o catch mais abaixo
            try {
                // 1. Ler o ficheiro equipas que esta na pasta
                Scanner scanner = new Scanner(new FileReader(pastaFicheiros + "\\LivrosBiblioteca.txt")).useDelimiter("\n");
                while (scanner.hasNext()) {

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


                }
            } catch (Exception ex) {
                System.out.println("Ocorreu um erro a ler ficheiro. \n" + ex.getMessage());
            }
        }
}



