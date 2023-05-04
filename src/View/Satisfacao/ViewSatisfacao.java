package View.Satisfacao;

import java.util.Scanner;

public class ViewSatisfacao {
    private Scanner scanner;
    private Scanner scanner2;

    public ViewSatisfacao() {
        scanner = new Scanner(System.in);
        scanner2 = new Scanner(System.in);
    }

    public void mostrarMensagem() {
        System.out.println("Avaliação salva com sucesso!");
    }

    public int obterSatisfacao() {
        System.out.print("Por favor, avalie de 1 a 5 em que : " +"\n");
        System.out.print("                       1 - Nada Satisfeito"+ "\n");
        System.out.print("                       2 - Insatisfeito      "+ "\n");
        System.out.print("                       3 - Razoavel "+ "\n");
        System.out.print("                       4 - Satisfeito      "+ "\n");
        System.out.print("                       5 - Bastante Satisfeito"+ "\n");

        int satisfacao = scanner.nextInt();
        return satisfacao;
    }
    public String obterObservacao() {
        System.out.println("Deixe uma observacao em formatdo de texto:");
        String observacao = scanner2.nextLine();
        return observacao;
    }


}
