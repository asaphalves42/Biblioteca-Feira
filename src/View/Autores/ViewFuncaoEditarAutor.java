package View.Autores;

import Controller.ControllerAutores;
import Model.Autor;
import Utilidades.ValidacaoData;

import java.time.LocalDate;
import java.util.ArrayList;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoEditarAutor {

    public void editarAutor(ControllerAutores gestor) {

        boolean sair = false;
        do {
            int idAutor = leInt("Insira o Id do(a) autor(a) que quer editar");
            ArrayList<Autor> autorEditar = gestor.pesquisarAutorPorId(idAutor);

            if (autorEditar == null) {
                System.out.println("Não existem autores com esse Id");
                System.out.println(" ");
            } else {
                System.out.println("Caso pretenda sair, digite 'sair'");
                String novoNome = "";
                while (novoNome.trim().equals("")) {
                    novoNome = leStr("Insira o novo nome do(a) autor(a): ");
                    if (novoNome.equalsIgnoreCase("sair")) {
                        sair = true;
                        break;
                    }
                    if (novoNome.trim().isEmpty()) {
                        System.out.println("Por favor, introduza um valor válido para o nome!");
                    }
                }
                if (sair) {
                    break;
                }

                String novaMorada = "";
                while (novaMorada.trim().equals("")) {
                    novaMorada = leStr("Insira a nova morada: ");
                    if (novaMorada.equalsIgnoreCase("sair")) {
                        sair = true;
                        break;
                    }
                }

                if (sair) {
                    break;

                }
                System.out.println("Digite a nova data de nascimento do autor: ");
                ValidacaoData validarData = new ValidacaoData();
                LocalDate novaDataDeNascimento = validarData.LerData2();

                boolean editado = gestor.editarAutor(idAutor, novoNome, novaMorada, novaDataDeNascimento);

                if (editado) {
                    System.out.println("Autor editado com sucesso");
                    System.out.println(" ");
                } else {
                    System.out.println("Autor não editado");
                    System.out.println(" ");
                    gestor.gravarAutorParaBaseDados();
                }
            }
            }
        while (!sair) ;
    }

}
