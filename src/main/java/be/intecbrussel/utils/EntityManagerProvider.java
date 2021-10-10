package be.intecbrussel.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
    private final static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("school-app");
    private final static EntityManager entityManager = emf.createEntityManager();

    public static EntityManager getEntityManager(){
        return entityManager;
    }
}
