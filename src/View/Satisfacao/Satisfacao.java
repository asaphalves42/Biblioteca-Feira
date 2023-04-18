package View.Satisfacao;

import static Utilidades.Leitura.ler;

public class Satisfacao {

    public int escolherSatisfacao() {
        int opcao;
        do {
            System.out.println("Sendo 1 muito ruim e 5 muito bom, avalie o rua experiencia! ");
            System.out.println("Escolha: ");
            System.out.println("1 - Muito ruim");
            System.out.println("2 - ruim");
            System.out.println("3 - regular");
            System.out.println("4 - bom");
            System.out.println("5 - Muito Bom");

            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        while(opcao < 1 || opcao > 5);
        return opcao;
    }
}