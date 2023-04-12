package View.Socios;

import Controller.ControllerSocios;
import Utilidades.ValidacaoData;

import java.time.LocalDate;
import java.util.Date;

import static Utilidades.Leitura.*;

public class ViewFuncaoAdicionarSocios {

    public void adicionarsocios(ControllerSocios gestorSocio){

        String nome =LeStr("Introduza o nome: ");
        String morada =LeStr("Introduza morada: ");
        System.out.println("Introduza a data de data de nascimento: ");
        String date  = ler.next();
        ler.nextLine();

        ValidacaoData validarData = new ValidacaoData();
        LocalDate dataDeNascimento = validarData.LerData2();

        String telefone =LeStr("Introduza o nr de telefone: ");

        System.out.println(" ");
        System.out.println("Sócio adicionado com sucesso!");
        System.out.println(" ");

        gestorSocio.adicionarSocio(nome,morada,dataDeNascimento,telefone);


    }
}
