package Model;

public class Bibliotecario extends Utilizador {
    private boolean pendenteGravacao;

    public boolean isPendenteGravacao() {
        return pendenteGravacao;
    }

    public void setPendenteGravacao(boolean pendenteGravacao) {
        this.pendenteGravacao = pendenteGravacao;
    }

    public Bibliotecario(String email, String password, int id) {
        super(email, password, id);
    }

    @Override
    public TipoUtilizador getTipo() {
        return TipoUtilizador.Bibliotecario;
    }
}
