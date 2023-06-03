package Model;

public class Categoria {
    private String nome;
    private boolean pendenteGravacao; //indicador que informa se o registo é novo ou alterado e precisa de ser gravado na base de dados


    public Categoria(int id, String nome) {
        this.nome = nome;
        this.id = id;
        if (id > proximoId){
            proximoId = id;
        }
        if (id == 0){
            this.id = ++proximoId;
        }
    }

    private static int proximoId = 0;
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    public boolean getPendenteGravacao() { return pendenteGravacao; }

    public void setPendenteGravacao(boolean pendenteGravacao) {
        this.pendenteGravacao = pendenteGravacao;
    }

    @Override
    public String toString() {
        return "Categoria [" +
                "ID: " + id + "\n" +
                "Nome: " + nome + "]" + "\n";
    }
}