package View;

import Controller.ControllerSocios;
import Utilidades.ValidacaoData;

import java.util.Date;

import static Utilidades.Leitura.leStr;
import static Utilidades.Leitura.ler;

public class ViewFuncaoAdicionarSocios {
    ControllerSocios adicionar = new ControllerSocios();
    public void MenuAdicionarSocios(){
        String nome =leStr("Introduza o nome: ");
        String morada =leStr("Introduza morada: ");
        System.out.println("Introduza a data de data de nascimento: ");
        String date  = ler.next();
        ler.nextLine();

        ValidacaoData validarData = new ValidacaoData();
        Date dataDeNascimento = validarData.LerData(date);

        String telefone =leStr("Introduza o nr de telefone: ");
        //Gerar numeromecanografico


}
}