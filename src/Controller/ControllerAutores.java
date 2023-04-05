package Controller;

import Model.Autor;

import java.util.ArrayList;
import java.util.Date;
public class ControllerAutores {

    ArrayList<Autor> autor = new ArrayList<>();

    Autor Autor = new Autor();

    public void adicionarAutores(String nome, String morada, Date dataDeNascimento) {

        Autor.setNome(nome);
        Autor.setMorada(morada);
        Autor.setDataDeNascimento(dataDeNascimento);

        this.autor.add(Autor);

    }


    public ArrayList<Autor> listarAutores() {

        return this.autor;

    }
}