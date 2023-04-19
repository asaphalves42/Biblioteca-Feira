package View.Reservas;

import Controller.ControllerReservas;
import Model.LivroReservado;

import java.util.ArrayList;

import static Utilidades.Leitura.ler;

public class ViewDevolverLivroReserva {
    public void devolverLivro(ControllerReservas controllerReservas) {
        ArrayList<LivroReservado> livrosReservados = controllerReservas.listarLivrosReservados();
        if (livrosReservados.isEmpty()) {
            System.out.println("Não há livros reservados.");
            return;
        }

        System.out.println("----- Devolver Livro -----");
        System.out.print("Digite o nome do livro que deseja devolver: ");
        String tituloDoLivro = ler.next();

        LivroReservado livroReservado = null;
        for (LivroReservado livro : livrosReservados) {
            if (livro.getLivro().getTitulo().equals(tituloDoLivro)) {
                livroReservado = livro;
                break;
            }
        }

        if (livroReservado == null) {
            System.out.println("Não foi possível encontrar um livro reservado com o nome inserido.");
            return;
        }

        controllerReservas.devolverLivro(livroReservado);
        System.out.println("Livro devolvido com sucesso.");
    }
}
