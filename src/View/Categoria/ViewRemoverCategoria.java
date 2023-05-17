package View.Categoria;

import Controller.ControllerCategoria;
import Model.Categoria;

import static Utilidades.Leitura.leStr;

public class ViewRemoverCategoria {

    public void removerCategoria(ControllerCategoria gestor){
        String categoriaPraRemover = leStr("Insira a categoria que deseja remover:");

        Categoria categoriaRemover = gestor.pesquisarCategoria(categoriaPraRemover);

        if(categoriaRemover == null) {
            System.out.println("Categoria não existe!");
            System.out.println(" ");
        } else{

            boolean remover = gestor.removerCategoria(categoriaRemover);

            if(remover){
                System.out.println("Categoria removida com sucesso!");
                System.out.println(" ");
            }else{
                System.out.println("Categoria esta associada a um livro, não foi possivel remover!");
                System.out.println(" ");
            }
        }
    }

}
