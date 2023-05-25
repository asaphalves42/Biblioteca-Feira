package Model;

public class Satisfacao {
    private String nota;
    private String observacao;
    private String idReserva;

    public Satisfacao(String nota, String observacao, String idReserva) {
        this.nota = nota;
        this.observacao = observacao;
        this.idReserva = idReserva;
    }

    public String getNota() {
        return nota;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public String toString() {
        return "Satisfacao{" +
                "nota=" + nota +
                ", observacao='" + observacao + '\'' +
                ", idReserva='" + idReserva + '\'' +
                '}';
    }
}
