package View.CD;

import Controller.ControllerProdutos;
import Model.CD;

import java.util.ArrayList;

import static Utilidades.Leitura.leStr;

public class ViewPesquisarCd {
    public void CDPorTitulo(ControllerProdutos gestor){

        String tituloCD = leStr("Insira o título do livro:");

        ArrayList<CD>  CD = gestor.pesquisarCDPorTitulo(tituloCD);

        if(CD.isEmpty()){
            System.out.println("CD nao existente!");
        }else{
            System.out.println(gestor.pesquisarCDPorTitulo(tituloCD));
        }
    }
    public void CDSPorAutor(ControllerProdutos gestor){

        String autorCDInserido = leStr("Insira o autor do CD:");

        ArrayList<CD> CD = gestor.pesquisarCDPorAutor(autorCDInserido);

        if(CD.isEmpty()){
            System.out.println("Autor nao existe!");
        }else{
            System.out.println(CD);
        }

    }
}
