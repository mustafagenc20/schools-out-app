package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.CourseDao;
import be.intecbrussel.dao.PersonDao;
import be.intecbrussel.model.Course;
import be.intecbrussel.model.Person;
import be.intecbrussel.utils.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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
            throw new UnsupportedOperationException("Entity doesn't exist!");
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

    @Override
    public List<Person> findAll() {
        String query = "Select p from Person p";
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Person> typedQuery = em.createQuery(query, Person.class);
        List<Person> personList = typedQuery.getResultList();
        em.getTransaction().commit();
        em.close();
        return personList;
    }

    @Override
    public Person makePassive(Integer id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Person newPerson = findById(id);
        CourseDao courseDao = new CourseDaoImpl();
        Course course = courseDao.findById(newPerson.getCourseActive().getId());
        if (newPerson != null) {
            course.setActive(false);
            courseDao.update(course);
            newPerson.setCourseActive(null);
            newPerson.getCourseHistory().add(course);
            newPerson = em.merge(newPerson);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
        return newPerson;
    }
}
