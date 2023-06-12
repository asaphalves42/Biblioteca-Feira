package Model;
public abstract class Utilizador {



    public Utilizador(String email, String password,int id) {
        this.email = email;
        this.password = password;
        this.id = id;

        if(id>proxID){
            proxID = id;
        }
        if(id==0){
            this.id=++proxID;
        }
    }

    public Utilizador(String email, String password,int id, boolean pendente) {
        this(email, password, id);
        this.pendenteGravacao = pendente;

    }

    private boolean pendenteGravacao;
    private final String email;
    private int id;
    private final String password;
    private static int proxID;
    public boolean getPendenteGravacao() { return pendenteGravacao; }
    public void setPendenteGravacao(boolean pendenteGravacao) {
        this.pendenteGravacao = pendenteGravacao;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public abstract TipoUtilizador getTipo();
}
