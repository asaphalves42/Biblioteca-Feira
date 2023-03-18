package otica.utilizador;

import java.util.Scanner;

public class Aplicacao {
    Scanner ler = new Scanner(System.in);

    public void Iniciar() {
        System.out.println("Bem vindo a biblioteca municipal de Santa Maria da Feira");
        System.out.println(" ");
        mensagemUtilizadorParaRegisto();

    }

    public void mensagemUtilizadorParaRegisto() {
        int opcao;

        do {

            System.out.println("Se ja estas cadastrado no sistema, selecione a opcao 1 para efetuar o login");
            System.out.println("1 - Login");
            System.out.println("Se não, efetue o registo!");
            System.out.println("2 - Efetuar registo");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1://Efetuar login
                    break;
                case 2://efetuar registo
                    break;
                case 3://sair
                    break;
            }

        } while (opcao != 3);
    }

    public void menuPrincipal() {
        int opcao;
        do {
            System.out.println("## Menu principal ##");
            System.out.println("Selecione uma opcao:");
            System.out.println("1 - Livros");
            System.out.println("2 - Autores");
            System.out.println("3 - Reservas");
            System.out.println("4 - Fechar");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1://crud livros
                    break;
                case 2://crud autores
                    break;
                case 3://crud reservas
                    break;
                case 4://fechar/guardar ficheiros
            }

        } while (opcao != 4);
    }

    public void menuLivros() {
        int opcao;

        do {

            System.out.println("## Livros ##");
            System.out.println("---------------");
            System.out.println("1 - Adicionar livros");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Editar livros");
            System.out.println("4 - Remover livros");
            System.out.println("5 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1://Adicionar livros
                    break;
                case 2://listar livros
                    break;
                case 3://Editar livros
                    break;
                case 4://Remover livros
                    break;
                case 5://sair
                    break;
            }

        } while (opcao != 5);

    }

    public void menuAutores() {
        int opcao;

        do {

            System.out.println("## Autores ##");
            System.out.println("---------------");
            System.out.println("1 - Adicionar autores");
            System.out.println("2 - Listar autores");
            System.out.println("3 - Editar autores");
            System.out.println("4 - Remover autores");
            System.out.println("5 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1://Adicionar autores
                    break;
                case 2://listar autores
                    break;
                case 3://Editar autores
                    break;
                case 4://Remover autores
                    break;
                case 5://sair
                    break;
            }

        } while (opcao != 5);

    }

}
