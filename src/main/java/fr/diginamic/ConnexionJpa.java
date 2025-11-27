package fr.diginamic;

import fr.diginamic.entites.Region;

import javax.persistence.*;

public class ConnexionJpa
{
    public static void main(String[] args)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo_jpa_database");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        Region region = new Region();
        region.setNom("Boulette");
        em.persist(region);
        System.out.println(region.getId());
        transaction.commit();

    }
}
