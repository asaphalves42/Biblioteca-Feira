package Controller;
import Model.Autor;
import Model.Livro;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerLivrosEautores {
    ArrayList<Livro> livros = ControllerLivros.livros;
    ArrayList<Autor> autores = ControllerAutores.autores;

    public int verificarId(){
        int max = 0;
        for(Livro id : livros){
            if(id.getId() > max){
                max = id.getId();
            }
        }
        return max;

    }
    public void adicionarAutor(String autorAdicionado){
        this.verificarId();
        Livro livro = new Livro(autorAdicionado);
        livro.setAutor(autorAdicionado);
    }

    public ArrayList<Autor> pesquisarAutorPorNome(String nomeInserido) {
        ArrayList<Autor> nomeAutor = new ArrayList<>();
        for (Autor nome : autores) {
            if (nomeInserido.equalsIgnoreCase(nome.getNome())){
                nomeAutor.add(nome);
            }
        }
        return nomeAutor;
    }

    public void adicionarLivrosComAutores(String titulo, String subtitulo, int quantidade, int numDePaginas, Autor autorAdicionado, ArrayList<String> categorias, LocalDate dataDePublicacao, String faixaEtaria, String editora, String ISBN) {
        this.verificarId();
        Livro livro = new Livro(titulo, subtitulo, quantidade, numDePaginas, autorAdicionado, categorias, dataDePublicacao,faixaEtaria, editora, ISBN);

        this.livros.add(livro);


    }
}
