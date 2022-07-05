package aplicacao;

import dominio.Pessoa;
import lombok.Getter;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            System.out.println("escreva seu nome: ");
            String nome = scan.next();
            System.out.println("escreva sua idade: ");
            int idade = Integer.parseInt(scan.next());
            Pessoa p1 = new Pessoa(null, nome, idade);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();
        System.out.println("Finish!");
    }
}
