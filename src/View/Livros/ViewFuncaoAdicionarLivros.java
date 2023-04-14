package View.Livros;


import Controller.ControllerAutores;
import Controller.ControllerLivros;
import Model.Autor;
import Utilidades.ValidacaoData;
import View.Categorias.Categorias;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static Utilidades.Leitura.*;

public class ViewFuncaoAdicionarLivros {
    ArrayList<String> categorias = new ArrayList<>();
    public void menuAdicionarLivros(ControllerLivros gestor) {

        String titulo = LeStr("Digite o título do livro:");
        String subtitulo = LeStr("Digite o subtitulo do livro:");
        int quantidade = LeInt("Digite a quantidade: ");

        String autor = LeStr("Digite o nome do autor");
        int numPaginas = LeInt("Digite o numero de paginas do livro: ");

        Categorias escolherCat = new Categorias();
        int opcaoCategoria = escolherCat.escolherCategorias();

        switch (opcaoCategoria) {
            case 1:
                categorias.add("Artes");
                break;
            case 2:
                categorias.add("Ciencias");
                break;
            case 3:
                categorias.add("Matematica");
                break;
            case 4:
                categorias.add("Psicologia");
                break;
            case 5:
                categorias.add("Tecnologia");
                break;
            default:
                break;
        }
        System.out.println("Digite a data de publicação do livro: ");
        ValidacaoData validarData = new ValidacaoData();
        LocalDate dataDePublicacao = validarData.LerData2();

        String faixaEtaria = LeStr("Digite a faixa etária do livro: ");
        String editora = LeStr("Digite a editora do livro: ");
        String ISBN = LeStr("Digite o ISBN do livro: ");

        System.out.println(" ");
        System.out.println("Livro adicionado com sucesso!");
        System.out.println(" ");

        gestor.adicionarLivros(titulo, subtitulo, quantidade, autor, numPaginas, String.valueOf(categorias), dataDePublicacao, faixaEtaria, editora, ISBN);
    }
}
