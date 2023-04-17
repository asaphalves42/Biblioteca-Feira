package Controller;

import Model.Livro;
import Model.LivroReservado;
import Model.Socio;

import java.time.LocalDate;
import java.util.ArrayList;

import static Controller.ControllerLivros.livros;
import static Controller.ControllerSocios.socios;

public class ControllerReservas {
    public ArrayList<LivroReservado> livrosReservados = new ArrayList<>();
    public void efetuarReserva(Socio socioSelecionado, Livro livroSelecionado, LocalDate dataDaReserva){
        LivroReservado livroReservado = new LivroReservado(socioSelecionado, livroSelecionado, dataDaReserva);
        this.livrosReservados.add(livroReservado);
        livroSelecionado.decrementarQuantidade();
        socioSelecionado.aumentarQuantidade();

    }
    public ArrayList<LivroReservado> listarLivrosReservados() {
        return this.livrosReservados;
    }

    public ArrayList<Socio> pesquisarSocioPorNome(String nomeInserido) {
            ArrayList<Socio> socioListado = new ArrayList<>();
            for (Socio socio : socios) {
                if (nomeInserido.equalsIgnoreCase(socio.getNome())) {
                    socioListado.add(socio);
                }
            }
            return socioListado;
        }

    public ArrayList<Livro> pesquisarLivroPorTitulo(String tituloDoLivro) {
        ArrayList<Livro> livrosTitulo = new ArrayList<>();
        for (Livro livro : livros) {
            if (tituloDoLivro.equalsIgnoreCase(livro.getTitulo())) {
                livrosTitulo.add(livro);
            }
        }
        return livrosTitulo;
    }


}



