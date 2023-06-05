package Model;

public class Administrador extends Utilizador {
    public Administrador(String email, String password) {
        super(email, password);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
