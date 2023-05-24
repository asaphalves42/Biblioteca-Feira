package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public  class Administrador {

    public Administrador(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String email;
    private String password;

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
}
