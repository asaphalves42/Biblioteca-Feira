package Model;

public class Consulta {
    private Socio socio;
    private Produto produto;
    private static int proximoId = 0;
    private int idDaConsulta;
    public Consulta(int idDaConsulta, Socio socio, Produto produto) {

        this.idDaConsulta = idDaConsulta;
        this.socio = socio;
        this.produto = produto;

        if (idDaConsulta > proximoId){
            proximoId = idDaConsulta;
        }
        if (idDaConsulta == 0){
            this.idDaConsulta = ++proximoId;
        }
    }

}

