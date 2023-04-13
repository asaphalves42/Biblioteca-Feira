package View.Livros;

import Controller.ControllerAutores;
import Controller.ControllerLivros;
import Model.Autor;
import Model.Livro;
import Utilidades.ValidacaoData;
import View.Categorias.Categorias;

import java.time.LocalDate;
import java.util.ArrayList;


import static Utilidades.Leitura.*;
import static Utilidades.Leitura.ler;

public class ViewFuncaoAdicionarLivros {
    public void menuAdicionarLivros(ControllerLivros gestor) {

        String titulo = LeStr("Digite o título do livro:");
        String subtitulo = LeStr("Digite o subtitulo do livro:");
        int quantidade = LeInt("Digite a quantidade: ");

        String autor = LeStr("Digite o autor do livro: ");

        /*
        String autorInserido = LeStr("Digite o autor do livro: ");

        ArrayList<Autor> autor = gestorAutor.pesquisarAutorPorNome(autorInserido);

        if(autor.isEmpty()){
            System.out.println("Não existem autores com esse nome!");
            System.out.println(" ");
        }else{
            for(Autor autor : autores){
                System.out.println(autor.toString());
            }
        }

        System.out.println("Insira o ID do autor que quer adicionar:");
        Autor autorParaAdicionar =
        */
        int numPaginas = LeInt("Digite o numero de paginas do livro: ");


        Categorias escolherCat = new Categorias();
        int opcaoCategoria = escolherCat.escolherCategorias();


        String categoria;
        switch (opcaoCategoria) {
            case 1:
                categoria = "Artes";
                break;
            case 2:
                categoria = "Ciencia";
                break;
            case 3:
                categoria = "Matematica";
                break;
            case 4:
                categoria = "Psicologia";
                break;
            case 5:
                categoria = "Tecnologia";
                break;
            default:
                categoria = "";
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

        gestor.adicionarLivros(titulo, subtitulo, quantidade, autor, numPaginas, categoria, dataDePublicacao, faixaEtaria, editora, ISBN);
    }

}
