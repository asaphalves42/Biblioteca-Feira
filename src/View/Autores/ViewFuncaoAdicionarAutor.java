package View.Autores;

import Controller.ControllerAutores;
import Utilidades.Leitura;
import Utilidades.ValidacaoData;

import java.time.LocalDate;

import static Utilidades.Leitura.*;

public class ViewFuncaoAdicionarAutor {

    public void menuAdicionarAutores(ControllerAutores gestor) {

        String nome = LeStr("Insira o nome do(a) autor(a)");

        String morada = LeStr("Insira a morada do(a) autor(a)");

        System.out.println("Digite a data de nascimento do autor: ");
        ValidacaoData validarData = new ValidacaoData();
        LocalDate dataDeNascimento = validarData.LerData2();

        System.out.println("Autor(a) " + nome + " adicionado(a) com sucesso!");
        System.out.println(" ");

        gestor.adicionarAutores(nome, morada, dataDeNascimento);

    }

}
