package View.Satisfacao;

import java.util.Scanner;

public class ViewSatisfacao {
    private Scanner scanner;

    public ViewSatisfacao() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMensagem() {
        System.out.println("Avaliação salva com sucesso!");
    }

    public int obterSatisfacao() {
        System.out.print("Por favor, avalie de 1 a 5 em que : " +"\n");
        System.out.print("                       1 - Muito Mau"+ "\n");
        System.out.print("                       2 - Mau      "+ "\n");
        System.out.print("                       3 - Razoavel "+ "\n");
        System.out.print("                       4 - Bom      "+ "\n");
        System.out.print("                       5 - Muito Mau"+ "\n");

        int satisfacao = scanner.nextInt();
        return satisfacao;
    }


}
