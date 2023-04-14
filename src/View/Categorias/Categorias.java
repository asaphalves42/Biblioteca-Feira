package View.Categorias;

import static Utilidades.Leitura.ler;

public class Categorias {
    public int escolherCategorias() {
        int opcao;
        do {
            System.out.println("Categoria: ");
            System.out.println("1 - Artes");
            System.out.println("2 - Ciencia");
            System.out.println("3 - Matematica");
            System.out.println("4 - Psicologia");
            System.out.println("5 - Tecnologia");

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


