package Controller;
import java.util.Date;
import Model.Socio;
import java.util.ArrayList;

public class ControllerSocios {

    ArrayList<Socio> socios = new ArrayList<>();
    Socio socio=new Socio();


    public void adicionarsocio(String nome, String morada, Date dataDeNascimento, String telefone, String numMecanografico){
        socio.setNome(nome);
        socio.setMorada(morada);
        socio.setDataDeNascimento(dataDeNascimento);
        socio.setTelefone(telefone);
        socio.setNumMecanografico(numMecanografico);

        this.socios.add(socio);
    }


}