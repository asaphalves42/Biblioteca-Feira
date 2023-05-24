package View.Satisfacao;

import Controller.ControllerLogin;
import Controller.ControllerSatisfacao;

import java.util.Scanner;

import static Utilidades.Leitura.leStr;

public class ViewSatisfacao {
    private Scanner scanner;
    private Scanner scanner2;

    ControllerSatisfacao controllersatisfacao = new ControllerSatisfacao();

    public void mostrarMensagem() {
        System.out.println("Avaliação salva com sucesso!");
        System.out.println(" ");
    }


    public void obterSatisfacao() {
        System.out.println("## Formulario de Satisfacao ##");
        System.out.println("-----------------------------------");
        System.out.print("Por favor, avalie de 1 a 5 em que : " +"\n");
        System.out.print("                       1 - Nada Satisfeito"+ "\n");
        System.out.print("                       2 - Insatisfeito      "+ "\n");
        System.out.print("                       3 - Razoavel "+ "\n");
        System.out.print("                       4 - Satisfeito      "+ "\n");
        System.out.print("                       5 - Bastante Satisfeito"+ "\n");


        String nota = leStr("Insira a sua avalicacao");

        String observacao = leStr("Deixe uma observacao :");

        boolean adicionado = ControllerSatisfacao.adicionarSatisfacao(nota, observacao);

        if(adicionado){
            System.out.println("Satisfacao adicionada com sucesso");
            controllersatisfacao.gravarSatisfacaoParaFicheiro();
        } else{
            System.out.println("erro ao adicionar satisfacao");
        }




    }

}
