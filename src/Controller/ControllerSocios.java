package Controller;
import java.util.Date;
import Model.Socio;
import java.util.ArrayList;

public class ControllerSocios {

    ArrayList<Socio> socios = new ArrayList<>();

    public void adicionarSocio(String nome, String morada, Date dataDeNascimento, String telefone){
    Socio socio= new Socio (nome,morada,dataDeNascimento,telefone);

        this.socios.add(socio);
    }
    public ArrayList<Socio> listarSocio(){
        return this.socios;

    }

}