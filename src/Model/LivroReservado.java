package Model;

import java.time.LocalDate;
import java.util.Random;

public class LivroReservado {
    private Socio socio;
    private Livro livro;
    private LocalDate dataReserva;
    private String idDaReserva;

    public LivroReservado(Socio socio, Livro livro, LocalDate dataReserva) {
        this.socio = socio;
        this.livro = livro;
        this.dataReserva = dataReserva;

        //Gerar id da reserva
        Random aleatorio = new Random();
        int id = aleatorio.nextInt(99999999);
        this.idDaReserva = String.format("%08d", id);
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    @Override
    public String toString() {
        return "Livros reservados [ " + "\n" +
                "Id da reserva: " + idDaReserva + "\n" +
                "Sócio: " + socio.getNome() + "\n" +
                "Número mecanográfico: " + socio.getNumMecanografico() + "\n" +
                "Livro: " + livro.getTitulo() + "\n" +
                "Id do livro: " + livro.getId() + "\n" +
                "Data da reserva: " + dataReserva + "]" + "\n" + "-----------------------------";
    }

}