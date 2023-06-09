package Model;

public class SocioUtilizador extends Utilizador{

    public SocioUtilizador(String email, String password, int id, boolean pendente) {
        super(email, password, id, pendente);
    }

    public SocioUtilizador(String email, String password, int id) {
        super(email, password, id);
    }

    @Override
    public TipoUtilizador getTipo() {
        return TipoUtilizador.Socio;
    }
}
