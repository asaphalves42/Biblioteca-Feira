package Model;

public enum TipoUtilizador {
    Bibliotecario(2),
    Administrador(1),

    Socio(3),
    Default(0);

    private int value;

    public int getValue() {
        return value;
    }

    TipoUtilizador(int i) {
        this.value = i;
    }
}
