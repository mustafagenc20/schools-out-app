package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.UserDao;
import be.intecbrussel.model.User;
import be.intecbrussel.utils.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User save(User user) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        User newUser = em.merge(user);
        em.getTransaction().commit();
        em.close();
        return newUser;
    }

    @Override
    public User findById(String login) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, login);
        if (user != null) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("I don't wanna work without implementation!");
        }
        em.close();
        return user;
    }


    @Override
    public void update(User user) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        User newUser = findById(user.getLogin());
        if (newUser != null) {
            em.merge(user);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
    }

    @Override
    public void remove(User user) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        User newUser = findById(user.getLogin());
        if (newUser != null) {
            user.setPerson(null);
            em.remove(user);
            em.getTransaction().commit();
        } else {
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
    }
}
