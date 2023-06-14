package Controller;

import Model.Consulta;
import Model.Socio;
import Utilidades.GestorFicheiros;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerConsultas {
    public static ArrayList<Consulta> consultas = new ArrayList<>();
    public static ArrayList<String> eliminadas = new ArrayList<>();
    public ControllerSocios controllerSocios;



    public ControllerConsultas(ControllerSocios controllerSocios){
        this.controllerSocios = controllerSocios;
    }

    public void lerConsultaFicheiro(){
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("consultas.txt");

        consultas=new ArrayList<>();
        LocalDate date;
        for (String linha : linhas){
            if (!linha.isEmpty()){
                String[] value_split = linha.split("\\|");
                if(value_split.length!=0){
                    Socio socio =controllerSocios.pesquisarSocioPorNumMecanografico(Integer.parseInt(value_split[1]));
                }
            }
        }


    }

}
