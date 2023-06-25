package Controller;

import Model.*;
import Utilidades.BaseDados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControllerLogin {

    public static ArrayList<Utilizador> utilizadores = new ArrayList<>();

    /*
    Ler e gravar utilizadores para a base de dados
     */

    public void lerUtilizadoresDaBaseDeDados() {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();
            ResultSet resultado = basedados.Selecao("SELECT * FROM Utilizador");

            while (resultado.next()) {
                Utilizador aux;

                // enquanto existirem registos, vou ler 1 a 1
                int idRole = resultado.getInt("id_role");
                if (idRole == 1) {
                    aux = new Administrador(

                            resultado.getString("username"),
                            resultado.getString("senha"),
                            resultado.getInt("id_utilizador")

                    );
                    utilizadores.add(aux);

                } else if (idRole == 2) {
                    aux = new Bibliotecario(
                            resultado.getString("username"),
                            resultado.getString("senha"),
                            resultado.getInt("id_utilizador")
                    );

                    utilizadores.add(aux);
                } else if (idRole == 3) {

                    aux = new SocioUtilizador(
                            resultado.getString("username"),
                            resultado.getString("senha"),
                            resultado.getInt("id_utilizador")

                    );
                    utilizadores.add(aux);
                }
            }
            basedados.Desligar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarUtilizadorParaBaseDados(Utilizador util, boolean atualizacao) {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();

            String script = "";
            if (atualizacao) {
                script = "UPDATE Utilizador SET username = '@01', senha = '@02', id_role = @03";
            } else {
                script = "INSERT INTO Utilizador (username, senha, id_role) " +
                        "VALUES ('@01', '@02', @03)";
            }

            script = script.replace("@01", util.getEmail());
            script = script.replace("@02", util.getPassword());

            if (util instanceof Bibliotecario) {
                script = script.replace("@03", String.valueOf(TipoUtilizador.Bibliotecario.getValue()));
            } else if (util instanceof SocioUtilizador) {
                script = script.replace("@03", String.valueOf(TipoUtilizador.Socio.getValue()));
            } else if (util instanceof Administrador) {
                script = script.replace("@03", String.valueOf(TipoUtilizador.Administrador.getValue()));
            }

            for (int i = 30; i > 0; i--) {
                script = script.replace("'@" + String.format("%02d", i) + "'", "NULL");
                script = script.replace("@" + String.format("%02d", i), "NULL");
            }

            // Executar o script na base de dados
            basedados.Executar(script);
            basedados.Desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    Funções de adição
    */

    public boolean adicionarFuncionario(String username, String password) {
        Utilizador adicionarUtil = new Bibliotecario(username, password, 0, true);
        utilizadores.add(adicionarUtil);
        gravarUtilizadorParaBaseDados(adicionarUtil, false);

        return true;
    }

    public boolean adicionarSocio(String username, String password) {
        Utilizador adicionarSocio = new SocioUtilizador(username, password, 0, true);
        utilizadores.add(adicionarSocio);
        gravarUtilizadorParaBaseDados(adicionarSocio, false);

        return true;
    }

    // Verificar o login, baseado no seu "id_role"

    public TipoUtilizador verificarLogin(String email, String password) throws SQLException {

        BaseDados basedados = new BaseDados();
        basedados.Ligar();
        ResultSet resultado = basedados.Selecao("SELECT * FROM Utilizador WHERE username = '" + email + "' AND senha = '" + password + "'");

        if (resultado.next()) {
            int idRole = resultado.getInt("id_role");

            if (idRole == 1) {
                return TipoUtilizador.Administrador;
            } else if (idRole == 2) {
                return TipoUtilizador.Bibliotecario;
            } else if (idRole == 3) {
                return TipoUtilizador.Socio;
            }
        }

        return TipoUtilizador.Default;
    }


}





