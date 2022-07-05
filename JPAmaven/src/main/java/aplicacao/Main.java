package aplicacao;

import CRUD.Crud;
import dominio.Pessoa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        Crud cria = new Crud();


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        Pessoa p2 = em.find(Pessoa.class, 2);
        System.out.println(p2);

        cria.criar(p2);

        System.out.println("Finish!");
        em.close();
        emf.close();
    }
}
