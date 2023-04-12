package Utilidades;

import java.util.UUID;

public class GeradorId {

    public static String Novo(){
        UUID guid = UUID.randomUUID();
        return guid.toString();
    }
}
