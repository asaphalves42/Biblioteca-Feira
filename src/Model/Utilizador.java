package Model;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public  class Utilizador {

    public Utilizador(String email, String password,String id) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    private String email;
    private String id;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
