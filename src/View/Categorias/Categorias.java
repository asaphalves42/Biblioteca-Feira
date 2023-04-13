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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }
        while(opcao !=5);
        return opcao;


    }
}


