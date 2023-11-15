package Controller;

import Model.Produto;

import java.util.ArrayList;

public class ControllerConsultas {

    //Funções por terminar
    public ControllerSocios controllerSocios;
    public ControllerProdutos controllerProdutos;

    ArrayList<Produto> jornais = new ArrayList<Produto>();

    public boolean consultarProdutos(Produto produto){
        if(produto.getQuantidade() == 0){
            return false;
        }
        return true;
    }
}
