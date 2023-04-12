package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;
import Utilidades.Leitura;

import java.time.LocalDate;

import static Utilidades.Leitura.LeInt;
import static Utilidades.Leitura.LeStr;

public class ViewFuncaoEditarAutor {

    public void editarAutor(ControllerAutores gestor) {

        int idAutor = LeInt("Insira o Id do(a) autor(a) que quer editar");
        Autor autorEditar = gestor.pesquisarAutorPorId(idAutor);

        if (autorEditar == null) {
            System.out.println("Não existem autores com esse Id");
            System.out.println(" ");
        }else {
            String novoNome = LeStr("insira o novo nome do(a) autor(a)");
            String novaMorada = LeStr("insira a nova morada");
            LocalDate novaDataDeNascimento = Leitura.LeData();

            boolean editado = gestor.editarAutor(idAutor, novoNome, novaMorada, novaDataDeNascimento);

            if (editado) {
                System.out.println("Autor editado com sucesso");
                System.out.println(" ");
            } else {
                System.out.println("Autor não editado");
                System.out.println(" ");
            }
        }
   }
}