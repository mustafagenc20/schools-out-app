package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.PersonDao;
import be.intecbrussel.model.Person;
import be.intecbrussel.utils.EntityManagerProvider;
import javax.persistence.EntityManager;

public class PersonDaoImpl implements PersonDao {

    @Override
    public Person save(Person person) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Person newPerson = em.merge(person);
        em.getTransaction().commit();
        em.close();
        return newPerson;
    }

    @Override
    public Person findById(Integer id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("I don't wanna work without implementation!");
        }
        em.close();
        return person;
    }

    @Override
    public void update(Person person) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Person newPerson = findById(person.getId());
        if (newPerson != null) {
            em.merge(person);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();

    }

    @Override
    public void remove(Person person) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Person newPerson = findById(person.getId());
        if (newPerson != null) {
            em.remove(person);
            em.getTransaction().commit();
        } else {
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();

    }
}
