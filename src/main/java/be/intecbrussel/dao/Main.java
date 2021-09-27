package be.intecbrussel.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("schools_out");
        EntityManager em = emf.createEntityManager();
        Person person = new Person();
        person.setFirstName("Mustafa");
        person.setFamilyName("Genc");
        person.setCourse(new Course());
        person.setGender(Gender.MALE);

        User user = new User();
        user.setLogin("Admin");
        user.setPasswordhash("12345");
        user.setPerson(person);
        user.setActive(true);





        em.getTransaction().begin();
        em.persist(person);
        em.persist(user);
        em.getTransaction().commit();

    }
}
