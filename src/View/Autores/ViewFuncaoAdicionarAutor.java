package View.Autores;

import Controller.ControllerAutores;
import Utilidades.Leitura;
import java.time.LocalDate;

import static Utilidades.Leitura.*;

public class ViewFuncaoAdicionarAutor {

    public void menuAdicionarAutores(ControllerAutores gestor) {
        int id;
        String nome, morada;

        do {
            id = LeInt("Insira o Id do(a) Autor(a)");
        } while (id <= 0);

        do {
            nome = LeStr("Insira o nome do(a) autor(a)");
        } while (nome.trim().isEmpty());

        do {
            morada = LeStr("Insira a morada do(a) autor(a)");
        } while (morada.trim().isEmpty());

        LocalDate dataDeNascimento = Leitura.LeData();

        System.out.println("Autor(a) " + nome + " adicionado(a) com sucesso");

        gestor.adicionarAutores(id, nome, morada, dataDeNascimento);

    }

}
