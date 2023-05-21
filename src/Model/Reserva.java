package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Reserva {
    private Socio socio;
    private ArrayList<Produto> livros = new ArrayList<>();
    private ArrayList<Produto> cds = new ArrayList<>();
    private LocalDate dataReserva;
    private final String idDaReserva;

    private LocalDate dataDeDevolucao;

    private boolean devolvido;


    public String getIdDaReserva() {
        return idDaReserva;
    }

    public Reserva(){
        //Gerar id da reserva
        Random aleatorio = new Random();
        int id = aleatorio.nextInt(99999999);
        this.idDaReserva = String.format("%08d", id);
        this.devolvido = false;
    }
    public Reserva(String idReserva, Socio socio, ArrayList<Produto> livros, ArrayList<Produto> cds,
                   LocalDate dataReserva, LocalDate dataDeDevolucao) {
        this.idDaReserva = idReserva;
        this.socio = socio;
        this.livros = livros;
        this.cds= cds;
        this.dataReserva = dataReserva;
        this.dataDeDevolucao = dataDeDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
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

    public void setLivros(ArrayList<Produto> livros) {
        this.livros = livros;
    }

    public ArrayList<Produto> getCds() {
        return cds;
    }

    public void setCds(ArrayList<Produto> cds) {
        this.cds = cds;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getNomes(ArrayList<Produto> produtos) {

        if(produtos.size() > 0){
            String nomes = "";
            for (Produto prod : produtos) {
                if(prod.getTipo().equalsIgnoreCase("livro")){
                    nomes += prod.getTitulo().toLowerCase()+ " | " + "Id do livro: " + prod.getId() + "\n";
                }else{
                    nomes += prod.getTitulo().toLowerCase()+ " | " + "Id do CD: " + prod.getId() + "\n";
                }
            }
            return nomes;
        }
        return "";
    }

    @Override
    public String toString() {
        return "Produtos reservados [ " + "\n" +
                "Id da reserva: " + idDaReserva + "\n" +
                "Sócio: " + socio.getNome() + "\n" +
                "Número mecanográfico: " + socio.getNumMecanografico() + "\n" +
                "Quantidade de Livros: " + livros.size() + "\n" +
                "Quantidade de CD´s: " + cds.size() + "\n" +
                "Livros: " + getNomes(livros) + "\n" +
                "CD´s: " + getNomes(cds) + "\n" +
                "Data da reserva: " + dataReserva + "]" + "\n"  +
                "Devolvido em: " + dataDeDevolucao + "\n" +
                "-----------------------------" + "\n";
    }

}