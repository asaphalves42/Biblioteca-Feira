package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Reserva {
    private Socio socio;
    private ArrayList<Produto> livros = new ArrayList<>();

    private LocalDate dataReserva;
    private final String idDaReserva;

    private LocalDate dataDeDevolucao;


    public String getIdDaReserva() {
        return idDaReserva;
    }

    public Reserva(){
        //Gerar id da reserva
        Random aleatorio = new Random();
        int id = aleatorio.nextInt(99999999);
        this.idDaReserva = String.format("%08d", id);
    }
    public Reserva(String idReserva, Socio socio, ArrayList<Produto> livros, LocalDate dataReserva, LocalDate dataDeDevolucao) {
        this.idDaReserva = idReserva;
        this.socio = socio;
        this.livros = livros;
        this.dataReserva = dataReserva;
        this.dataDeDevolucao = dataDeDevolucao;
    }

    public LocalDate getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public void setDataDeDevolucao(LocalDate dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public ArrayList<Produto> getLivros() {
        return livros;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }


    public String getNomes(ArrayList<Produto> livros) {
        String nomes = "";
        for (Produto livro : livros) {
            nomes += livro.getTitulo().toLowerCase()+ " | " + "Id do livro: " + livro.getId() + "\n";

        }
        return nomes;

    }
    @Override
    public String toString() {
        return "Livros reservados [ " + "\n" +
                "Id da reserva: " + idDaReserva + "\n" +
                "Sócio: " + socio.getNome() + "\n" +
                "Número mecanográfico: " + socio.getNumMecanografico() + "\n" +
                "Quantidade de Livros: " + livros.size() + "\n" +
                "Livros: " + getNomes(livros) + "\n" +
                "Data da reserva: " + dataReserva + "]" + "\n"  +
                "Devolvido em: " + dataDeDevolucao + "\n" +
                "-----------------------------" + "\n";
    }

}