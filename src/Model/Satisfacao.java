package Model;

public class Satisfacao {
    private String nota;
    private String observacao;

    public Satisfacao(String nota, String observacao) {
        this.nota = nota;
        this.observacao = observacao;
    }

    public String getNota() {
        return nota;
    }

    public String getObservacao() {
        return observacao;
    }


    @Override
    public String toString() {
        return "Satisfacao{" +
                "nota=" + nota +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
