package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;

import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;
public class ViewFuncaoRemoverAutor {
    public void removerAutorPorNome(ControllerAutores gestor) {
        boolean sair = false;

        while (!sair) {
            try {
                String nome = leStr("Insira o nome do(a) autor(a): ");
                ArrayList<Autor> autorParaRemover = gestor.pesquisarAutorPorNome(nome);
                ArrayList<Integer> idsValidos = new ArrayList<>();

                if (autorParaRemover.isEmpty()) {
                    System.out.println("Não existem autores com esse nome!\n");
                    continue;  // Continuar no loop para permitir nova tentativa
                } else {
                    boolean autorEncontrado = false;
                    for (Autor autor : autorParaRemover) {
                        if (autor.getNome().equals(nome)) {
                            System.out.println(autor);
                            idsValidos.add(autor.getId());
                            autorEncontrado = true;
                        }
                    }
                    if (!autorEncontrado) {
                        System.out.println("Autor(a) não encontrado(a)\n");
                        continue;  // Continuar no loop para permitir nova tentativa
                    }
                }

                int idAutor = leInt("Insira o ID do(a) autor(a) que deseja remover: ");

                if (!idsValidos.contains(idAutor)) {
                    System.out.println("ID inválido. Insira um ID válido da lista mostrada.\n");
                    continue;  // Continuar no loop para permitir nova tentativa
                }

                boolean removido = gestor.removerAutor(idAutor);

                if (removido) {
                    System.out.println("Autor(a) removido(a) com sucesso!\n");
                    sair = true;  // Autor removido com sucesso, então sair do loop
                } else {
                    System.out.println("Não é possível remover o(a) autor(a), pois está ligado a um livro.\n");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao remover o(a) autor(a): " + e.getMessage() + "\n");
            }
        }
    }

}

