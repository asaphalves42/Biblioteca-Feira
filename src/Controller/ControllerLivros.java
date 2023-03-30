package Controller;

import Model.Livro;

import java.util.ArrayList;
import java.util.Date;

public class ControllerLivros {
    ArrayList<Livro> livros = new ArrayList<>();
    Livro livro = new Livro();

    public void adicionarLivros(String titulo, String subTitulo, String autor, int numPaginas, String categoria, Date dataDePublicacao, String faixaEtaria, String editora, String ISBN) {

        livro.setTitulo(titulo);
        livro.setSubtitulo(subTitulo);
        livro.setAutor(autor);
        livro.setNumDePaginas(numPaginas);
        livro.setCategoria(categoria);
        livro.setDataDePublicacao(dataDePublicacao);
        livro.setFaixaEtaria(faixaEtaria);
        livro.setEditora(editora);
        livro.setISBN(ISBN);

        this.livros.add(livro);

    }

    public ArrayList<Livro> listarLivros() {

        return this.livros;

    }


    public int ContagemLivros(String numero) {
        int contagem = 0;
        for (Livro livro : livros) {
            if (numero.equals(livro.getTitulo())) {
                contagem = contagem + 1;
            }
        }
        return contagem;
    }

    public ArrayList<Livro> pesquisarLivroPorTitulo(String tituloInserido) {
        ArrayList<Livro> livrosTitulo = new ArrayList<>();
        for (Livro livro : livros) {
            if (tituloInserido.equalsIgnoreCase(livro.getTitulo())) {
                livrosTitulo.add(livro);
            }
        }
        return livrosTitulo;
    }

    public boolean removerLivros(String tituloLivro) {

        ArrayList<Livro> encontrado = pesquisarLivroPorTitulo(tituloLivro);

       



        return false;

    }


}







