package Controller;

/*public class ControllerPalavraChave {
    public static ArrayList<PalavraChave> palavraschave = new ArrayList<>();
    public static ArrayList<Integer> eliminados = new ArrayList<Integer>();

    public void lerFicheiroCategoria() {
        ArrayList<String> linhas = GestorFicheiros.LerFicheiro("palavrachave.txt");

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] value_split = linha.split("\\|");
                if (value_split.length != 0) {
                    PalavraChave aux = new PalavraChave(
                            Integer.parseInt(value_split[0]),
                            value_split[1]);

                    palavraschave.add(aux);
                }

            }
        }
    }
    public void gravarFicheiroPalavraChave(){
        String conteudo = "";
        for (PalavraChave aux : palavraschave) {
            conteudo += aux.getPalavrachave() + "\n";
            conteudo += aux.getId() + "\n";

        }
        GestorFicheiros.gravarFicheiro("palavrachave.txt", conteudo);
    }
    public boolean adicionarPalavrasChave(String PalavraChave){
        // Verificar se a palavra chave já existe
        for (PalavraChave palavraChave : PalavraChave) {
            if (PalavraChave.getPalavra().equalsIgnoreCase(palavraChave)) {
                return false; // A categoria já existe, não é possível adicioná-la novamente
            }
        }

        PalavraChave adicionarPalavra = new Categoria(0, PalavraChave.);
        adicionarPalavra.setPendenteGravacao(true);
        PalavraChave.add(adicionarPalavra);

        return true;
    }*/


