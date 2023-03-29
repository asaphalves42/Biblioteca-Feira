package Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidacaoData {


    //Metodo retirado da internet para ler datas https://stackoverflow.com/questions/27580655/how-to-set-a-date-as-input-in-java

    public Date LerData(String date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (date2);

    }
}
