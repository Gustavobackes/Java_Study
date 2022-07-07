package CRUD;

import dominio.Pessoa;

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
    public void excluir(int num){
        Pessoa p = em.find(Pessoa.class, num);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public void closeConnection(){
        em.close();
        emf.close();
    }

}
