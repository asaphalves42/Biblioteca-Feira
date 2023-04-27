package Controller;

import Model.Livro;
import Model.Reserva;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class ControllerLivros {
    public static ArrayList<Livro> livros = new ArrayList<>();

    public void lerLivrosDeFicheiro(){
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("livros.txt");

            for (String linha : linhas) {
                if(linha.isEmpty() == false){
                String[] value_split = linha.split("\\|");
                if(value_split.length != 0) {
                    Livro aux = new Livro(Integer.parseInt(value_split[0]),
                            value_split[1],
                            value_split[2],
                            Integer.parseInt(value_split[3]),
                            value_split[4],
                            Integer.parseInt(value_split[5]),
                            value_split[6],
                            LocalDate.parse(value_split[7]),
                            value_split[8],
                            value_split[9],
                            value_split[10]);
                    livros.add(aux);
                }
                }

        }

    }
    public void gravarLivrosParaFicheiro(){
        String conteudo = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Livro aux : livros){
            String formated_date = aux.getDataDePublicacao().format(formatter);

            conteudo += aux.getId() + "|";
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
        GestorFicheiros.gravarFicheiro("livros.txt", conteudo);
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
        boolean encontrou = false;
                //percorrer as reservas para ver se encontra
                for (Reserva reserva : ControllerReservas.reservas) {
                    for (Livro livrosEscolhido : reserva.getLivros()) {
                        if (idLivroRemover == livrosEscolhido.getId()) {
                            encontrou = true;
                        }
                    }
                }
            //se encontrar remove
            if (!encontrou) {
               for(Livro livro: livros){
                   if(idLivroRemover == livro.getId()){
                       livros.remove(livro);
                   }
               }
            }

        return encontrou;
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

    public boolean editarQuantidade(int idEditarQuantidade, int novaQuantidade) {
        for (Livro livro : livros) {
            if (idEditarQuantidade == livro.getId()) {
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

    public boolean editarNumPaginas(int idEditarTitulo, int numPaginas) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setNumDePaginas(numPaginas);
                return true;
            }
        }
        return false;
    }

    public boolean editarCategoria(int idEditarTitulo, String novaCategoria) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setCategoria(novaCategoria);
                return true;
            }
        }
        return false;
    }

    public boolean editarDataDePubli(int idEditarTitulo, LocalDate novaData) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setDataDePublicacao(novaData);
                return true;
            }
        }
        return false;
    }
    public boolean editarFaixaEtaria(int idEditarTitulo, String novaFaixaEtaria) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setFaixaEtaria(novaFaixaEtaria);
                return true;
            }
        }
        return false;
    }
    public boolean editarEditora(int idEditarTitulo, String novaEditora) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setEditora(novaEditora);
                return true;
            }
        }
        return false;
    }

    public boolean editarISBN(int idEditarTitulo, String novoISBN) {
        for (Livro livro : livros) {
            if (idEditarTitulo == livro.getId()) {
                livro.setISBN(novoISBN);
                return true;
            }
        }
        return false;
    }

    public Livro pesquisarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

}










