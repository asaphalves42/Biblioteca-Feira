package View;

import Controller.ControllerLivros;
import Utilidades.ValidacaoData;

import java.util.Date;

import static Utilidades.Leitura.*;
import static Utilidades.Leitura.ler;

public class ViewFuncaoAdicionarLivros {
    public void menuAdicionarLivros(ControllerLivros gestor) {

        String titulo = leStr("Digite o título do livro:");

        String subtitulo = leStr("Digite o subtitulo do livro:");

        int quantidade = LeInt("Digite a quantidade: ");

        String autor = leStr("Digite o autor do livro: ");

        int numPaginas = LeInt("Digite o numero de paginas do livro: ");

        String categoria = leStr("Digite a categoria do livro: ");

        System.out.println("Digite a data de publicação do livro: ");
        String date = ler.next();
        ler.nextLine();
        ValidacaoData validarData = new ValidacaoData();
        Date dataDePublicacao = validarData.LerData(date);

        String faixaEtaria = leStr("Digite a faixa etária do livro: ");

        String editora = leStr("Digite a editora do livro: ");

        String ISBN = leStr("Digite o ISBN do livro: ");

        System.out.println(" ");
        System.out.println("Livro adicionado com sucesso!");
        System.out.println(" ");

        gestor.adicionarLivros(titulo, subtitulo, quantidade, autor, numPaginas, categoria, dataDePublicacao, faixaEtaria, editora, ISBN);

    }
}
