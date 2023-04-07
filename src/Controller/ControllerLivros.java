package Controller;

import Model.Livro;
import Utilidades.GestorFicheiros;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ControllerLivros {
    public ArrayList<Livro> livros = new ArrayList<>();

    public void lerLivrosDeFicheiro(){
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("livros.txt");
        if (!linhas.isEmpty()) {
            for (String linha : linhas) {
                String[] value_split = linha.split("\\|");
                Livro aux = new Livro(value_split[0],
                        value_split[1],
                        Integer.parseInt(value_split[2]),
                        value_split[3],
                        Integer.parseInt(value_split[4]),
                        value_split[5],
                        new Date(value_split[6]),
                        value_split[7],
                        value_split[8],
                        value_split[9]);
                livros.add(aux);
            }
        }
    }
    public void gravarLivrosParaFicheiro(){

        String conteudo = "";
        for (Livro aux : livros){
            SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String formated_date = DateFormat.format(aux.getDataDePublicacao());

            conteudo += aux.getTitulo() + "|" ;
            conteudo += aux.getSubtitulo() + "|" ;
            conteudo += aux.getQuantidade() + "|" ;
            conteudo += aux.getAutor() + "|" ;
            conteudo += aux.getNumDePaginas() + "|" ;
            conteudo += aux.getCategoria() + "|" ;
            conteudo += formated_date + "|" ;
            conteudo += aux.getFaixaEtaria() + "|" ;
            conteudo += aux.getEditora() + "|" ;
            conteudo += aux.getISBN() +  "\n";
        }
        GestorFicheiros.GravarFicheiro("livros.txt", conteudo);
    }

    public void adicionarLivros(String titulo, String subTitulo, int quantidade, String autor, int numPaginas, String categoria, Date dataDePublicacao, String faixaEtaria, String editora, String ISBN) {
        Livro livro = new Livro(titulo, subTitulo, quantidade, autor, numPaginas, categoria, dataDePublicacao, faixaEtaria, editora, ISBN);
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

    public ArrayList<Livro> pesquisarLivroPorAutor(String autorInserido){
        ArrayList<Livro> livrosDoAutor = new ArrayList<>();
        for (Livro autor : livros) {
            if (autorInserido.equalsIgnoreCase(autor.getAutor())) {
                livrosDoAutor.add(autor);
            }
        }
        return livrosDoAutor;

    }

    public ArrayList<Livro> pesquisarLivroCategoria(String categoriaInserida){
        ArrayList<Livro> categoriaLivros = new ArrayList<>();
        for (Livro categoria : livros) {
            if (categoriaInserida.equalsIgnoreCase(categoria.getCategoria())) {
                categoriaLivros.add(categoria);
            }
        }
        return categoriaLivros;

    }

    public Livro pesquisarLivroISBN(String ISBNinserido){
        for (Livro livro : livros) {
            if (ISBNinserido.equalsIgnoreCase(livro.getISBN())) {
                return livro;
            }
        }
        return null;
    }

    public boolean removerLivro(int idLivroRemover) {
        for (Livro livro : livros) {
            if (idLivroRemover == livro.getId()) {
                if (livro.getQuantidade() - 1 > 0) {
                    livro.setQuantidade(livro.getQuantidade() - 1);
                } else {
                    livros.remove(livro);
                }
                return true;
            }
        }
        return false;
    }

    public boolean editarLivro(int idLivroEditar, String novoTitulo, String subTitulo, int quantidade, String autor, int numPaginas, String categoria, Date dataDePublicacao, String faixaEtaria, String editora, String ISBN) {
        for (Livro livro : livros) {
            if (idLivroEditar == livro.getId()) {
                livro.setTitulo(novoTitulo);
                livro.setSubtitulo(subTitulo);
                livro.setQuantidade(quantidade);
                livro.setAutor(autor);
                livro.setNumDePaginas(numPaginas);
                livro.setCategoria(categoria);
                livro.setDataDePublicacao(dataDePublicacao);
                livro.setFaixaEtaria(faixaEtaria);
                livro.setEditora(editora);
                livro.setISBN(ISBN);

                return true;
            }
        }
        return false;
    }

    public boolean editarTituloDoLivro(int idLivroEditar, String tituloNovo) {
        for (Livro livro : livros) {
            if (idLivroEditar == livro.getId()) {
                livro.setTitulo(tituloNovo);
                return true;
            }
        }
        return false;
    }

    public boolean editarSubTituloDoLivro(int idLivroEditar, String subTituloNovo) {
        for (Livro livro : livros) {
            if (idLivroEditar == livro.getId()) {
                livro.setSubtitulo(subTituloNovo);
                return true;
            }
        }
        return false;
    }

    public boolean editarQuantidade(int idEditarTitulo, int novaQuantidade) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setQuantidade(novaQuantidade);
                return true;
            }
        }
        return false;
    }
    public boolean editarAutor(int idEditarTitulo, String novoAutor) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setAutor(novoAutor);
                return true;
            }
        }
        return false;
    }

}










