package aplicacao;

import CRUD.Crud;
import dominio.Pessoa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        Crud crud = new Crud();

        Pessoa pes2 = new Pessoa(null, "Gustavoteste", 90);

           crud.criar(pes2);
           crud.excluir(3);


        System.out.println("Finish!");
        crud.closeConnection();
    }
}
