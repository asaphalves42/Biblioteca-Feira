package View.Satisfacao;

import java.util.ArrayList;

public class ViewSatisfacao {

    ArrayList<String> escolhas = new ArrayList<>();

    public void satisfacao(){
        Satisfacao satisfacao = new Satisfacao();
        int escolha = satisfacao.escolherSatisfacao();

        switch (escolha) {
            case 1:
                escolhas.add("Muito Ruim");
                break;
            case 2:
                escolhas.add("ruim");
                break;
            case 3:
                escolhas.add("regular");
                break;
            case 4:
                escolhas.add("bom");
                break;
            case 5:
                escolhas.add("muito bom");
                break;
            default:
                break;
        }

    }
}