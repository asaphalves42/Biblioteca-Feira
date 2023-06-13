package Controller;

import Model.*;
import Utilidades.BaseDados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Controller.*;


public class ControllerLogin {
    //ControllerEmail controlleremail = new ControllerEmail(Email email);
    public static ArrayList<Utilizador> utilizadores = new ArrayList<>();
    public static ArrayList<Integer> eliminados = new ArrayList<Integer>();
ControllerEmail controlleremail= new ControllerEmail();
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

                }
            }
            basedados.Desligar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarUtilizadorParaBaseDados() {
        try {
            BaseDados basedados = new BaseDados();
            basedados.Ligar();

            // Inserir ou atualizar registros
            for (Utilizador aux : utilizadores) {
                if (aux.getPendenteGravacao()) {
                    basedados.Executar("DELETE FROM Utilizador WHERE id_utilizador = " + aux.getId());
                    basedados.Executar("INSERT INTO Utilizador (username, senha, id_role) VALUES ('" + aux.getEmail() + "', '" + aux.getPassword() + "', '" + aux.getTipo().getValue() + "')");
                }
            }

            // Eliminar registros que foram apagados
            if (!eliminados.isEmpty()) {
                for (Integer aux : eliminados) {
                    basedados.Executar("DELETE FROM Utilizador WHERE id = " + aux);
                }
                eliminados.clear(); // Apago o array porque já foi processado
            }

            basedados.Desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



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

    public boolean adicionarFuncionario(String username, String password){
        Bibliotecario adicionarUtil = new Bibliotecario(username, password,0);
        adicionarUtil.setPendenteGravacao(true);
        utilizadores.add(adicionarUtil);

        return true;
    }

    public boolean adicionarSocio(String username,String password ){
        SocioUtilizador adicionarSocio = new SocioUtilizador(username,password, 0, true);

        utilizadores.add(adicionarSocio);
        gravarUtilizadorParaBaseDados();

        //enviar o email automatico

        return true;
    }

}





