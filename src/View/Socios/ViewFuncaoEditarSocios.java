package View.Socios;

import Controller.ControllerSocios;
import Model.Socio;
import Utilidades.ValidacaoData;

import java.time.LocalDate;

import static Utilidades.Leitura.leInt;
import static Utilidades.Leitura.leStr;

public class ViewFuncaoEditarSocios {

    public void editarSocioPorNumMecTodosOsCampos(ControllerSocios gestor) {
        try {
            int numMecanografico = 0;
            boolean sair = false;

            do {
                try {
                    numMecanografico = leInt("Insira o número mecanográfico do sócio que pretende editar (Digite 0 para sair): ");
                    if (numMecanografico == 0) {
                        sair = true;
                        break;
                    }

                    Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

                    if (socio == null) {
                        System.out.println("Não existem sócios com esse número");
                        System.out.println(" ");
                    } else {
                        String novoNome = "";
                        while (novoNome.trim().equals("")) {
                            novoNome = leStr("Insira o novo nome do sócio (Digite 'sair' para sair): ");
                            if (novoNome.equalsIgnoreCase("sair")) {
                                sair = true;
                                break;
                            }
                        }
                        if (sair) {
                            break;
                        }

                        String novaMorada = "";
                        while (novaMorada.trim().equals("")) {
                            novaMorada = leStr("Insira a nova morada do sócio (Digite 'sair' para sair): ");
                            if (novaMorada.equalsIgnoreCase("sair")) {
                                sair = true;
                                break;
                            }
                        }
                        if (sair) {
                            break;
                        }

                        System.out.println("Digite a data de nascimento do sócio: ");
                        ValidacaoData validarData = new ValidacaoData();
                        LocalDate novaDataDeNascimento = validarData.LerData2();

                        int novoTelefone = 0;
                        while (novoTelefone < 100000000 || novoTelefone > 999999999) {
                            novoTelefone = leInt("Insira o novo número de telefone (Digite 0 para sair): ");
                            if (novoTelefone == 0) {
                                sair = true;
                                break;
                            }
                        }
                        if (sair) {
                            break;
                        }

                        boolean editado = gestor.editarSocio(numMecanografico, novoNome, novaMorada, novaDataDeNascimento, novoTelefone);

                        if (editado) {
                            System.out.println("Sócio editado com sucesso");
                            System.out.println(" ");
                        } else {
                            System.out.println("Sócio não editado");
                            System.out.println(" ");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao editar o sócio: " + e.getMessage());
                }
            } while (!sair);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar o número mecanográfico: " + e.getMessage());
        }
    }


    public void editarNomeSocioPorNumMecanografico(ControllerSocios gestor) {
        try {
            int numMecanografico = 0;
            boolean sair = false;

            do {
                try {
                    numMecanografico = leInt("Insira o número mecanográfico do sócio que pretende editar (Digite 0 para sair): ");
                    if (numMecanografico == 0) {
                        sair = true;
                        break;
                    }

                    Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

                    if (socio == null) {
                        System.out.println("Não existem sócios com esse número!");
                        System.out.println(" ");
                    } else {
                        String novoNome = "";
                        while (novoNome.trim().equals("")) {
                            novoNome = leStr("Insira o novo nome do sócio (Digite 'sair' para sair): ");
                            if (novoNome.equalsIgnoreCase("sair")) {
                                sair = true;
                                break;
                            }
                        }
                        if (sair) {
                            break;
                        }

                        boolean editado = gestor.editarSocioPorNome(numMecanografico, novoNome);

                        if (editado) {
                            System.out.println("Sócio editado com sucesso");
                            System.out.println(" ");
                        } else {
                            System.out.println("Sócio não editado");
                            System.out.println(" ");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao editar o sócio: " + e.getMessage());
                }
            } while (!sair);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar o número mecanográfico: " + e.getMessage());
        }
    }

    public void editarMoradaSocioPorNumMecanografico(ControllerSocios gestor) {
        int numMecanografico = leInt("Insira o número mecanográfico do sócio que pretende editar:");
        Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);
        String novaMorada;
        if (socio == null) {
            System.out.println("Não existem sócios com esse número");
            System.out.println(" ");
            return;
        } else {
            novaMorada = "";
            while (novaMorada.trim().equals("")) {
                novaMorada = leStr("Insira a nova morada do sócio:");
            }
        }
        boolean editado = gestor.editarSocioPorMorada(numMecanografico, novaMorada);
        if (editado) {
            System.out.println("Sócio editado com sucesso!");
            System.out.println(" ");
        } else {
            System.out.println("Sócio não editado!");
            System.out.println(" ");
        }
    }

    public void editarDataDeNascimentoSocioPorNumMecanografico(ControllerSocios gestor) {
        try {
            int numMecanografico = 0;
            boolean sair = false;

            do {
                try {
                    numMecanografico = leInt("Insira o número mecanográfico do sócio que pretende editar (Digite 0 para sair): ");
                    if (numMecanografico == 0) {
                        sair = true;
                        break;
                    }

                    Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

                    if (socio == null) {
                        System.out.println("Não existem sócios com esse número");
                        System.out.println(" ");
                    } else {
                        boolean dataValida = false;
                        LocalDate novaDataDeNascimento = null;

                        if (!dataValida) {
                            try {
                                System.out.println("Digite a data de nascimento do sócio (Digite 'sair' para sair): ");
                                ValidacaoData validarData = new ValidacaoData();
                                novaDataDeNascimento = validarData.LerData2();
                                String valiStr=String.valueOf(novaDataDeNascimento);

                                if (valiStr.equalsIgnoreCase("sair")) {
                                    sair = true;
                                    break;
                                }

                                dataValida = true;
                            } catch (Exception e) {
                                System.out.println("Ocorreu um erro ao ler a data de nascimento: " + e.getMessage());
                            }
                        }

                        if (sair) {
                            break;
                        }

                        boolean editado = gestor.editarSocioPorDataDeNascimento(numMecanografico, novaDataDeNascimento);
                        if (editado) {
                            System.out.println("Sócio editado com sucesso");
                            System.out.println(" ");
                        } else {
                            System.out.println("Sócio não editado");
                            System.out.println(" ");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao editar o sócio: " + e.getMessage());
                }
            } while (!sair);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar o número mecanográfico: " + e.getMessage());
        }
    }

    public void editarTelefoneSocioPorNumMecanografico(ControllerSocios gestor) {
        try {
            int numMecanografico = leInt("Insira o número mecanográfico do sócio que pretende editar (ou 0 se quer sair): ");
            if (numMecanografico==0){
                return;
            }

            Socio socio = gestor.pesquisarSocioPorNumMecanografico(numMecanografico);

            int novoTelefone = 0;
            if (socio == null) {
                System.out.println("Não existem sócios com esse número");
                System.out.println(" ");
            } else {
                boolean sair = false;

                do {
                    try {
                        novoTelefone = leInt("Insira o novo número de telefone (ou 0 se quer sair): ");
                        if (novoTelefone==0){
                            break;
                        }

                        if (novoTelefone < 100000000 || novoTelefone > 999999999) {
                            System.out.println("Por favor, introduza um número de telefone com 9 dígitos!");
                        } else {
                            sair = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro ao ler o número de telefone: " + e.getMessage());
                    }
                } while (!sair);

                if (sair) {
                    boolean editado = gestor.editarSocioPorTelefone(numMecanografico, novoTelefone);
                    if (editado) {
                        System.out.println("Sócio editado com sucesso");
                        System.out.println(" ");
                    } else {
                        System.out.println("Sócio não editado");
                        System.out.println(" ");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar o número mecanográfico: " + e.getMessage());
        }
    }
}