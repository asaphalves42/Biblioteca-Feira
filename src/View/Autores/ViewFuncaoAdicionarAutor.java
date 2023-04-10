package View.Autores;

import Controller.ControllerAutores;
import Utilidades.ValidacaoData;

import java.util.Date;

import static Utilidades.Leitura.LeStr;
import static Utilidades.Leitura.ler;

public class ViewFuncaoAdicionarAutor {

    public void menuAdicionarAutores(ControllerAutores gestor) {

        String id = LeStr("Insira o Id do(a) Autor(a)");

        String nome = LeStr("Insira o nome do(a) autor(a)");

        String morada = LeStr("Insira a morada do(a) autor(a)");

        System.out.println("Insira a data de nascimento do(a) autor(a)");
        String date = ler.next();
        ler.nextLine();

        ValidacaoData validarData = new ValidacaoData();
        Date dataDeNascimento = validarData.LerData(date);

        System.out.println("Autor(a)" + nome + "adicionado(a) com sucesso");

        gestor.adicionarAutores(id, nome, morada, dataDeNascimento);

    }

}
