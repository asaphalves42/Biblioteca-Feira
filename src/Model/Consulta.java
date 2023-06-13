package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Consulta {
    private Socio socio;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private LocalDate dataConsulta;

    private LocalDate dataDeDevolucao;

    private boolean devolvido;

    private boolean pendenteGravacao; //indicador que informa se o registo é novo ou alterado e precisa de ser gravado na base de dados

    public String getIdConsulta() {
        return idConsulta;
    }

    public Consulta(){
        //Gerar id da reserva
        Random aleatorio = new Random();
        int id = aleatorio.nextInt(99999999);
        this.idConsulta = String.format("%08d", id);
        this.devolvido = false;
    }
    public Consulta(String idConsulta, Socio socio, ArrayList<Produto> produtos,
                   LocalDate dataConsulta, LocalDate dataDeDevolucao, boolean consultado) {
        this.idConsulta = idConsulta;
        this.socio = socio;
        this.produtos = produtos;
        this.dataConsulta = dataConsulta;
        this.dataDeDevolucao = dataDeDevolucao;
        consultado = false;
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

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    public ArrayList<Produto> getProdutosPorTipo(TipoProduto tipo) {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        for (Produto produto : this.produtos) {
            if (produto.getTipo() == tipo){
                produtos.add(produto);
            }
        }
        return produtos;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getNomesProdutos(TipoProduto tipo) {
        if (produtos.size() > 0){
            String nomes = "";
            for (Produto prod : produtos) {
                if(prod.getTipo() == tipo){
                    nomes += prod.getTitulo().toLowerCase()+ " | " + "Id do " + tipo.toString() + ": " + prod.getId() + "\n";
                }
            }
            return nomes;
        }
        return "";
    }

    public boolean getPendenteGravacao() { return pendenteGravacao; }
    public void setPendenteGravacao(boolean pendenteGravacao) {
        this.pendenteGravacao = pendenteGravacao;
    }

    @Override
    public String toString() {
        return "Produtos Consultados [ " + "\n" +
                "Id da reserva: " + idConsulta + "\n" +
                "Sócio: " + socio.getNome() + "\n" +
                "Número mecanográfico: " + socio.getNumMecanografico() + "\n" +
                "Quantidade de Livros: " + getProdutosPorTipo(TipoProduto.Livro).size() + "\n" +
                "Quantidade de CD´s: " + getProdutosPorTipo(TipoProduto.CD).size() + "\n" +
                "Livros: " + getNomesProdutos(TipoProduto.Livro) + "\n" +
                "CD´s: " + getNomesProdutos(TipoProduto.CD) + "\n" +
                "Data da reserva: " + dataConsulta + "]" + "\n"  +
                "Devolvido em: " + dataDeDevolucao + "\n" +
                "-----------------------------" + "\n";
    }

}

*/