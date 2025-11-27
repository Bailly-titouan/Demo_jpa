package fr.diginamic;

import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;
import fr.diginamic.entites.Region;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestBibliotheque
{
    public static void main(String[] args)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo_jpa_database_livre");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Emprunt emprunt = em.find(Emprunt.class, 5);
        System.out.println(emprunt);

        transaction.commit();

    }
}
