package View.Categoria;

import Controller.ControllerCategoria;
import Model.Categoria;

import static Utilidades.Leitura.leInt;

public class ViewRemoverCategoria {

    public void removerCategoria(ControllerCategoria gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                for (Categoria categoria : gestor.listarCategorias()) {
                    System.out.println(categoria);
                }

                int idCategoria = leInt("Insira o id da categoria que deseja remover:");

                boolean remover = gestor.removerCategoria(idCategoria);

                if (remover) {
                    System.out.println("Categoria removida com sucesso!\n");
                } else {
                    System.out.println("Categoria não encontrada ou está associada a um livro, não foi possível remover!\n");
                }

                sair = true; // Sai do loop após a execução bem-sucedida
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao remover a categoria: " + e.getMessage() + "\n");
            }
        }
    }

}


