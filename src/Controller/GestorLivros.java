package Controller;

import Model.Livro;

import java.util.ArrayList;
import java.util.Date;

public class GestorLivros {
    ArrayList<Livro> livros = new ArrayList<>();
    Livro livro = new Livro();
    public void adicionarLivros(String titulo, String subTitulo, String autor, int numPaginas, String categoria, Date dataDePublicacao, String faixaEtaria, String editora, String ISBN){

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

    public void listarLivros(){
        if(livros.isEmpty()){
            System.out.println("Não existem livros registados");
        } else {
            for(Livro livro : livros){
                System.out.println(livro);
            }
        }

    }

    public Livro obterLivroPorTitulo(String tituloLivro) {
        for (Livro livro : livros) {
            if (tituloLivro.equals(livro.getTitulo())){
                return livro;
            }
        }
        return null;
    }

    public void removerLivros(String tituloLivro) {
        try {
            Livro encontrado = obterLivroPorTitulo(tituloLivro);

            if (encontrado != null) {
                livros.remove(encontrado);
                System.out.println("Livro removido com sucesso!");
                System.out.println(" ");
            } else {
                System.out.println("Nao foram encontrados livros");
                System.out.println(" ");
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao eliminar o livro!" + e.getMessage());
    }
    }
}




