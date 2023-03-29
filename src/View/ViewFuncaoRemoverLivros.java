package View;

import Controller.ControllerLivros;

import static Utilidades.Leitura.ler;

public class ViewFuncaoRemoverLivros {
    ControllerLivros gestor = new ControllerLivros();
    public void eliminarLivroPorTitulo(){

        String tituloLivro;
        System.out.println("Insira o título do livro: ");
        tituloLivro = ler.nextLine();

        System.out.println("Foram encontrados esses livros com esse título:");

        gestor.removerLivros(tituloLivro);

    }
}
