package Model;

public class Categoria {


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
    private String nome;
    private static int proximoId = 0;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public Categoria() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Categoria [" +
                "ID: " + id + "\n" +
                "Nome: " + nome + "]" + "\n";
    }


}