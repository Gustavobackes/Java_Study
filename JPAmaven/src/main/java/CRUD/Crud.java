package CRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crud {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();

    public void criar(Object p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
}
