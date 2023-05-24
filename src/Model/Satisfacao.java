package Model;


public  class Satisfacao {

    public Satisfacao(String nota, String observacao) {
        this.nota = nota;
        this.observacao = observacao;
    }

    private String nota;
    private String observacao;

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Satisfacao{" +
                "nota=" + nota +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
