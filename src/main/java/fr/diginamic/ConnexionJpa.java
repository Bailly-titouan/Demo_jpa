package fr.diginamic;

import fr.diginamic.entites.Region;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;

public class ConnexionJpa
{
    public static void main(String[] args)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo_jpa_database");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<Region> query = em.createQuery("FROM Region", Region.class);

        for (Region region : query.getResultList())
        {
            System.out.println(region.getNom());
        }

        transaction.commit();

    }
}
