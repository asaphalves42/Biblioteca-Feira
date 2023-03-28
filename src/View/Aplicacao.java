package View;

import Controller.ControllerLivros;
import Controller.LerFicheiros;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.jar.JarOutputStream;


public class Aplicacao {
    Scanner ler = new Scanner(System.in);
    ControllerLivros gestor = new ControllerLivros();



    public void Iniciar() {
        System.out.println("Bem vindo a biblioteca municipal de Santa Maria da Feira");
        System.out.println(" ");
        menuPrincipal();
        LerFicheiros.lerFicheiros();

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
            System.out.println("4 - Sócios");
            System.out.println("5 - Fechar");

            opcao = ler.nextInt();


            switch (opcao) {
                case 1:
                    menuLivros();
                    break;
                case 2:
                    menuAutores();
                    break;
                case 3:
                    menuReservas();
                    break;
                case 4:
                    menuSocios();
                    break;
                case 5://fechar/guardar ficheiros
            }

        } while (opcao != 4);
    }

    /*

    Gestor de livros

    */

    public void menuLivros() {
        int opcao;

        do {

            System.out.println("## Livros ##");
            System.out.println("------------------------");
            System.out.println("1 - Adicionar livros");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Editar livros");
            System.out.println("4 - Remover livros");
            System.out.println("5 - Pesquisar livros");
            System.out.println("6 - Menu anterior");

            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    menuAdicionar();
                    break;
                case 2:
                    listarTodosOsLivros();
                    break;
                case 3://Editar livros
                    break;
                case 4:eliminarLivroPorTitulo();
                    break;
                case 5:
                    menuLivros2();
                    break;
                case 6://sair
                    break;
            }

        } while (opcao != 5);

    }

    public void menuLivros2() {

        int opcao;

        do {

            System.out.println("## Pesquisar livros por: ##");
            System.out.println("---------------");
            System.out.println("1 - Autor");
            System.out.println("2 - Título");
            System.out.println("3 - ISBN");
            System.out.println("4 - Categoria");
            System.out.println("5 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1://autor
                    break;
                case 2:livroPorTitulo();
                    break;
                case 3://isbn
                    break;
                case 4://categoria
                    break;
                case 5://sair
                    break;
            }

        } while (opcao != 5);


    }

    public void menuAdicionar() {

        String titulo;
        System.out.println("Digite o título do livro: ");
        titulo = ler.nextLine();

        String subtitulo;
        System.out.println("Digite o subtítulo do livro: ");
        subtitulo = ler.nextLine();

        String autor;
        System.out.println("Digite o autor do livro: ");
        autor = ler.nextLine();

        int numPaginas;
        System.out.println("Digite o numero de paginas do livro: ");
        numPaginas = ler.nextInt();
        ler.nextLine();

        String categoria;
        System.out.println("Digite a categoria do livro: ");
        categoria = ler.nextLine();

        System.out.println("Digite a data de publicação do livro: ");
        Date dataPublicacao = LerData();

        String faixaEtaria;
        System.out.println("Digite a faixa etária do livro: ");
        faixaEtaria = ler.nextLine();

        String editora;
        System.out.println("Digite a editora do livro: ");
        editora = ler.nextLine();

        String ISBN;
        System.out.println("Digite o ISBN do livro: ");
        ISBN = ler.nextLine();

        System.out.println("Livro adicionado com sucesso!");
        System.out.println(" ");

        gestor.adicionarLivros(titulo, subtitulo, autor, numPaginas, categoria, dataPublicacao, faixaEtaria, editora, ISBN);

    }

    public void listarTodosOsLivros() {
        gestor.listarLivros();
    }

    public void eliminarLivroPorTitulo(){
        
        String tituloLivro;
        System.out.println("Insira o título do livro: ");
        tituloLivro = ler.nextLine();

        gestor.removerLivros(tituloLivro);

    }

    public void livroPorTitulo(){
        String tituloInserido;
        System.out.println("Insira o titulo do livro que queres pesquisar: ");
        tituloInserido = ler.next();


        System.out.println(gestor.pesquisarLivroPorTitulo(tituloInserido));

    }


    public void menuAutores() {
        int opcao;

        do {

            System.out.println("## Autores ##");
            System.out.println("------------------------");
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

    public void menuReservas() {
        int opcao;

        do {

            System.out.println("## Reservas ##");
            System.out.println("---------------");
            System.out.println("1 - Fazer reserva");
            System.out.println("2 - Devolucao");
            System.out.println("3 - Listar reservas");
            System.out.println("4 - Cancelar reservas");
            System.out.println("5 - Editar reserva");
            System.out.println("6 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1://fazer reserva
                    break;
                case 2://devolver
                    break;
                case 3://listar reservas
                    break;
                case 4://cancelar
                    break;
                case 5://editar reserva
                    break;
                case 6://sair
                    break;
            }

        } while (opcao != 5);

    }

    public void menuSocios() {
        int opcao;

        do {

            System.out.println("## Sócios ##");
            System.out.println("---------------");
            System.out.println("1 - Adicionar socio");
            System.out.println("2 - Listar socios");
            System.out.println("3 - Editar socios");
            System.out.println("4 - Remover socios");
            System.out.println("5 - Menu anterior");

            opcao = ler.nextInt();

            switch (opcao) {
                case 1://Adicionar socio
                    break;
                case 2://Listar socios * mostrar livros reservados pelo sócio
                    break;
                case 3://Editar socios
                    break;
                case 4://Remover socios
                    break;
                case 5://sair
                    break;
            }

        } while (opcao != 5);

    }

    //Metodo retirado da internet para ler datas https://stackoverflow.com/questions/27580655/how-to-set-a-date-as-input-in-java
    private Date LerData() {
        String date = ler.next();
        ler.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (date2);

    }
}
