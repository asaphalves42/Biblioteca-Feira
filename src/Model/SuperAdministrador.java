package Model;

public class SuperAdministrador extends Utilizador {
    public SuperAdministrador(String email, String password) {
        super(email, password);
    }

    @Override
    public String toString() {
        return "SuperAdministrador{" +
                "email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
