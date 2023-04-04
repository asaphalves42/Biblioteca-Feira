package Controller;

import Model.Livro;

import java.util.ArrayList;
import java.util.Date;

public class ControllerLivros {
    ArrayList<Livro> livros = new ArrayList<>();

    public void adicionarLivros(String titulo, String subTitulo, int quantidade, String autor, int numPaginas, String categoria, Date dataDePublicacao, String faixaEtaria, String editora, String ISBN) {

        Livro livro = new Livro(titulo,subTitulo,quantidade,autor,numPaginas,categoria,dataDePublicacao,faixaEtaria,editora,ISBN);

        livro.setTitulo(titulo);
        livro.setSubtitulo(subTitulo);
        livro.setQuantidade(quantidade);
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
    public ArrayList<Livro> pesquisarLivroPorTitulo(String tituloInserido) {
        ArrayList<Livro> livrosTitulo = new ArrayList<>();
        for (Livro livro : livros) {
            if (tituloInserido.equalsIgnoreCase(livro.getTitulo())) {
                livrosTitulo.add(livro);
            }
        }
        return livrosTitulo;
    }

    public boolean removerLivros(int idLivroRemover) {

        for (Livro livro : livros) {
            if (idLivroRemover == livro.getId()) {
                if(livro.getQuantidade() - 1 > 0 ){
                    livro.setQuantidade(livro.getQuantidade() - 1);
                }else{
                    livros.remove(livro);
                }
                return true;
            }
        }
        return false;

    }


}







