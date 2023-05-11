package View.Categoria;

import Controller.ControllerCategoria;

import static Utilidades.Leitura.leStr;

public class ViewAdicionarCategoria {

    public void adicionarCategoria(ControllerCategoria gestorCategoria) {
        String categoria = leStr("Insira a categoria:");

        boolean adicionado = gestorCategoria.adicionarCategorias(categoria);

        if (adicionado) {
            System.out.println("Categoria " + categoria + " adicionada com sucesso!");
            System.out.println(" ");
        }

    }
}
