package View.Satisfacao;

import Controller.ControllerSatisfacao;

import static Utilidades.Leitura.leStr;

public class ViewSatisfacao {
    private ControllerSatisfacao controllerSatisfacao = new ControllerSatisfacao();

    public void obterSatisfacao(String idReserva) {
        System.out.println("## Formulário de Satisfação ##");
        System.out.println("-----------------------------------");
        System.out.println("Por favor, avalie de 1 a 5, onde:");
        System.out.println("1 - Nada Satisfeito");
        System.out.println("2 - Insatisfeito");
        System.out.println("3 - Razoável");
        System.out.println("4 - Satisfeito");
        System.out.println("5 - Bastante Satisfeito");


        String nota = leStr("Insira a sua avaliação:");
        String observacao = leStr("Deixe uma observacao em formato de texto:");


        boolean adicionado = controllerSatisfacao.adicionarSatisfacao(nota, observacao, idReserva);

        if (adicionado) {
            System.out.println("Satisfação adicionada com sucesso");
            controllerSatisfacao.gravarSatisfacaoParaFicheiro();
        } else {
            System.out.println("Erro ao adicionar satisfação");
        }
    }
}
