package aplicacao;

import dominio.Pessoa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {

        try {



            Pessoa p1 = new Pessoa(null, nome, idade);
        }catch (Exception e){
            System.out.println("Digige um valor valido!");

        }

        Pessoa pes1 = new Pessoa();



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pes1);
        em.getTransaction().commit();
        System.out.println("Finish!");
    }
}
