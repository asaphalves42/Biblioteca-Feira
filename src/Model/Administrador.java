package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public  class Administrador extends Utilizador {

    public Administrador(String email, String password, int id) {
        super(email, password, id);
    }
    @Override
    public TipoUtilizador getTipo() {
        return TipoUtilizador.Administrador;
    }
}
