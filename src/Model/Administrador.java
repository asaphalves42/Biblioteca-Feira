package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public  class Administrador {

    public Administrador(String email, String password, String id ) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    private String email;
    private String password;
    private String id;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Administrador{" +
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
