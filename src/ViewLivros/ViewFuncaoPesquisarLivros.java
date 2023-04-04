package ViewLivros;

import Controller.ControllerLivros;

import static Utilidades.Leitura.leStr;

public class ViewFuncaoPesquisarLivros {
    ControllerLivros gestor = new ControllerLivros();
    public void livroPorTitulo(){

        String tituloInserido = leStr("Insira o título do livro:");

        System.out.println(gestor.pesquisarLivroPorTitulo(tituloInserido));

    }
}
