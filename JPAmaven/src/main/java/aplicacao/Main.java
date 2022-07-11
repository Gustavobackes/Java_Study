package aplicacao;

import CRUD.Crud;
import dominio.Pessoa;


public class Main {
    public static void main(String[] args) {
        Crud crud = new Crud();

        Pessoa pes = new Pessoa(null, "Gustavoteste", 12);

        crud.criar(pes);

        System.out.println("Finish!");
        crud.closeConnection();
    }
}
