package View;

import Controller.ControllerAutores;
import Utilidades.ValidacaoData;

import java.util.Date;

import static Utilidades.Leitura.LeStr;
import static Utilidades.Leitura.ler;


public class ViewFuncaoAdicionarAutores {

    ControllerAutores autor = new ControllerAutores();

    public void menuAdicionarAutores() {

        ControllerAutores autor = new ControllerAutores();

        String nome = LeStr("Insira o nome do(a) autor(a)");

        String morada = LeStr("Insira a morada do(a) autor(a)");

        System.out.println("Insira a data de nascimento do(a) autor(a)");
        String date = ler.next();
        ler.nextLine();

        ValidacaoData validarData = new ValidacaoData();
        Date dataDeNascimento = validarData.LerData(date);

        System.out.println("Autor(a) adicionado(a) com sucesso");

        //autor.adicionarAutores(nome, morada, dataDeNascimento);


    }
}
