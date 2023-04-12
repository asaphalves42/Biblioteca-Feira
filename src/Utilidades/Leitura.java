package Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Leitura {
        public static Scanner ler = new Scanner(System.in);

        public static int LeInt(String msg) {
            System.out.println(msg);
            return ler.nextInt();
        }

        public static String LeStr(String msg) {
            System.out.println(msg);
            ler = new Scanner(System.in);
            return ler.nextLine();
        }

    public static LocalDate LeData() {
        try {
            LocalDate data;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            data = LocalDate.parse(ler.nextLine(), formatter);
            return data;
        } catch (Exception ex) {
            System.out.println("Data invalida, insira uma data com o formato (dd/MM/aaaa):");
            return LeData();
        }
    }


    }

