package View.Livros;


import Controller.ControllerLivros;

import Utilidades.ValidacaoData;
import View.Categorias.Categorias;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.*;

public class ViewFuncaoAdicionarLivros {
    ArrayList<String> categorias = new ArrayList<>();
    public void menuAdicionarLivros(ControllerLivros gestor) {

        String titulo = "";
        while (titulo.trim().isEmpty()) {
            titulo = LeStr("Introduza o titulo: ");
            if (titulo.trim().isEmpty()) {
                System.out.println("Por favor, introduza um titulo válido!");
            }
        }

        String subtitulo = "";
        while (subtitulo.trim().isEmpty()) {
            subtitulo = LeStr("Introduza o subtitulo: ");
            if (subtitulo.trim().isEmpty()) {
                System.out.println("Por favor, introduza um subtitulo válido!");
            }
        }

        int quantidade = 0;
        while (quantidade < 1000000000 || quantidade > 999999999) {
            quantidade = LeInt("Introduza a quantidade: ");
            if (quantidade < 1000000000 || quantidade > 999999999) {
                System.out.println("Por favor, introduza um número de quantidade com 9 dígitos!");
            }
        }

        String autor = "";
        while (autor.trim().isEmpty()) {
            autor = LeStr("Introduza o autor: ");
            if (autor.trim().isEmpty()) {
                System.out.println("Por favor, introduza um autor válido!");
            }
        }

        int numPaginas = 0;
        while (numPaginas < 1000000000 || numPaginas > 999999999) {
            numPaginas = LeInt("Introduza o número de páginas: ");
            if (numPaginas < 1000000000 || numPaginas > 999999999) {
                System.out.println("Por favor, introduza um número de quantidade com 9 dígitos!");
            }
        }
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

        String faixaEtaria = "";
        while (faixaEtaria.trim().isEmpty()) {
            faixaEtaria = LeStr("Introduza a faixa etaria: ");
            if (faixaEtaria.trim().isEmpty()) {
                System.out.println("Por favor, introduza uma faixa etaria válida");
            }
        }

        String editora = "";
        while (editora.trim().isEmpty()) {
            editora = LeStr("Introduza a editora: ");
            if (editora.trim().isEmpty()) {
                System.out.println("Por favor, introduza uma editora válido!");
            }
        }

        String ISBN = "";
        while (ISBN.trim().isEmpty()) {
            ISBN = LeStr("Introduza o ISBN: ");
            if (ISBN.trim().isEmpty()) {
                System.out.println("Por favor, introduza um ISBN válido!");
            }
        }


        System.out.println(" ");
        System.out.println("Livro adicionado com sucesso!");
        System.out.println(" ");

        gestor.adicionarLivros(titulo, faixaEtaria, numPaginas, faixaEtaria, numPaginas, String.valueOf(categorias), dataDePublicacao, faixaEtaria, editora, ISBN);
    }
}
