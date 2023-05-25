package Model;

public class Categoria {
    private String nome;
    private boolean pendenteGravacao; //indicador que informa se o registo é novo ou alterado e precisa de ser gravado na base de dados

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getPendenteGravacao() { return pendenteGravacao; }
    public void setPendenteGravacao(boolean pendenteGravacao) {
        this.pendenteGravacao = pendenteGravacao;
    }

    @Override
    public String toString() {
        return "Categoria [" +
                "Nome: " + nome + "]" + "\n";
    }
}
