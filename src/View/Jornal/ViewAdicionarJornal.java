package View.Jornal;

import Controller.ControllerProdutos;
import Utilidades.ValidacaoData;

import java.time.LocalDate;

import static Utilidades.Leitura.leIntPositivo;
import static Utilidades.Leitura.leStr;


public class ViewAdicionarJornal {
    public void MenuAdicionarJornal(ControllerProdutos gestorJornais){
        boolean sair = false;
        do {

            System.out.println("Caso pretenda sair, digite 'sair'");
            String titulo = "";
            while (titulo.trim().isEmpty()) {
                titulo = leStr("Introduza o titulo: ");
                if (titulo.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (titulo.trim().isEmpty()) {
                    System.out.println("Por favor, introduza um titulo válido!");
                }
            }
            if (sair) {
                break;
            }
            String subtitulo = "";
            while (subtitulo.trim().isEmpty()) {
                subtitulo = leStr("Introduza o subtitulo: ");
                if (subtitulo.equalsIgnoreCase("sair")) {
                    sair = true;
                    break;
                }
                if (subtitulo.trim().isEmpty()) {
                    System.out.println("Por favor, introduza um subtitulo válido!");
                }
            }
            if (sair) {
                break;
            }

                System.out.println("Digite a data de lançamento do jornal (dd/MM/yyyy): ");
                ValidacaoData validarData = new ValidacaoData();
                LocalDate dataDePublicacao = validarData.LerData2();

                String editora = "";
                while (editora.trim().isEmpty()) {
                    editora = leStr("Introduza a editora: ");
                    if (editora.equalsIgnoreCase("sair")) {
                        sair = true;
                        break;
                    }
                    if (editora.trim().isEmpty()) {
                        System.out.println("Por favor, introduza uma editora válida!");
                    }
                }
                if (sair) {
                    break;
                }
                //automaticamente a quantidade passa a ser uma unidade
                int quantidade=1;

                int numeroPaginas = leIntPositivo("Introduza o número de páginas: ");
                System.out.println(" ");

                boolean adicionado = gestorJornais.adicionarJornais(titulo,subtitulo,quantidade,numeroPaginas,dataDePublicacao,editora);

                if (adicionado) {
                    System.out.println("Jornal " + titulo + " adicionado com sucesso!");
                    System.out.println(" ");
                } else {
                    System.out.println("Ocorreu um erro ao adicionar o Jornal!\n");
                }


        } while (sair);
    }

}