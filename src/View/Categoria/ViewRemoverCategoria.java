package View.Categoria;

import Controller.ControllerCategoria;
import Model.Categoria;

import static Utilidades.Leitura.leStr;

public class ViewRemoverCategoria {

    public void removerCategoria(ControllerCategoria gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                String categoriaPraRemover = leStr("Insira a categoria que deseja remover (ou digite 'sair' para sair):");

                // Verificar se o usuário digitou "sair" e, se sim, sair do loop
                if (categoriaPraRemover.equalsIgnoreCase("sair")) {
                    sair = true;
                    continue;
                }

                Categoria categoriaRemover = gestor.pesquisarCategoriaPorNome(categoriaPraRemover);

                if (categoriaRemover == null) {
                    System.out.println("Categoria não existe!\n");
                } else {
                    boolean remover = gestor.removerCategoria(categoriaRemover);

                    if (remover) {
                        System.out.println("Categoria removida com sucesso!\n");
                    } else {
                        System.out.println("Categoria está associada a um livro, não foi possível remover!\n");
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao remover a categoria: " + e.getMessage() + "\n");
            }
        }
    }


}
