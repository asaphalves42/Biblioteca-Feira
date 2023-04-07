package Model;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Utilizador {

    public Utilizador(String email, String password) {
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

    public void guardarEmFicheiro() {
        try {
            PrintWriter writer = new PrintWriter(new File("utilizadores.txt"));
            writer.println(email + "," + password);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao guardar utilizador em ficheiro.");
        }
    }
}
