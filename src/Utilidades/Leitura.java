package Utilidades;
import java.util.Scanner;

public class Leitura {
        public static Scanner ler = new Scanner(System.in);

        public static int LeInt(String msg) {
            System.out.print(msg);
            return ler.nextInt();
        }

        public static String leStr(String msg) {
            System.out.print(msg);
            ler = new Scanner(System.in);
            return ler.nextLine();
        }

    }

