package Model;

public class Bibliotecario extends Utilizador {

    public Bibliotecario(String email, String password, int id, boolean pendente) {
        super(email, password, id, pendente);
    }

    public Bibliotecario(String email, String password, int id) {
        super(email, password, id);
    }

    @Override
    public TipoUtilizador getTipo() {
        return TipoUtilizador.Bibliotecario;
    }
}
