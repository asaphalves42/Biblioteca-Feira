package Model;

public class PalavraChave {
    public static String palavrachave;
    private static int proximoId = 0;
    private int id;
    private boolean pendenteGravacao;

    public String getPalavrachave() {

        return palavrachave;
    }
    public static int getProximoId() {
            return proximoId;
        }

    public static void setProximoId(int proximoId) {
        PalavraChave.proximoId = proximoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Palavra Chave [" +
                "ID: " + id +
                "Palavras Chave: " + palavrachave + '\'' +
                ']';
    }

    public boolean isPendenteGravacao() {
        return pendenteGravacao;
    }

    public void setPendenteGravacao(boolean pendenteGravacao) {
        this.pendenteGravacao = pendenteGravacao;
    }

    public PalavraChave(int id, String palavrachave) {
        this.palavrachave = palavrachave;
        this.id = id;
        if (id > proximoId){
            proximoId = id;
        }
        if (id == 0){
            this.id = ++proximoId;
        }
    }

}
