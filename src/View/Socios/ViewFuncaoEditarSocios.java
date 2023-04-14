package View.Socios;

public class ViewFuncaoEditarSocios {

   /*public void editarSocio(ControllerSocios gestor) {

        String numMecanografico = LeStr("Insira o número mecanográfico do sócio que pretende editarr");
        ArrayList<Socio> socioEditar = gestor.pesquisarSocioPorNome(numMecanografico);

        if (socioEditar == null) {
            System.out.println("Não existem sócios com esse número");
            System.out.println(" ");
        }else {
            String novoNome = "";
            while (novoNome.trim().equals("")) {
                novoNome = LeStr("Insira o novo nome do sócio");
            }

            String novaMorada = "";
            while (novaMorada.trim().equals("")) {
                novaMorada = LeStr("Insira a nova morada do sócio");
            }
            LocalDate novaDataDeNascimento = Leitura.LeData();

            boolean editado = gestor.editarSocio(novoNome, novaMorada, novaDataDeNascimento, numMecanografico);

            if (editado) {
                System.out.println("Sócio editado com sucesso");
                System.out.println(" ");
            } else {
                System.out.println("Sócio não editado");
                System.out.println(" ");
                //gestor.gravarAutorParaFicheiro();
            }
        }
    } */
}