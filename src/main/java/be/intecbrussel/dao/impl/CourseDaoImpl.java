package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.CourseDao;
import be.intecbrussel.model.Course;
import be.intecbrussel.utils.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public Course save(Course course) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Course newCourse = em.merge(course);
        em.getTransaction().commit();
        em.close();
        return newCourse;
    }

    @Override
    public Course findById(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
        if (course != null) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("I don't wanna work without implementation!");
        }
        em.close();
        return course;
    }

    @Override
    public void update(Course course) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Course newCourse = findById(course.getId());
        if (newCourse != null) {
            em.merge(course);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
    }

    @Override
    public void remove(Course course) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Course newCourse = findById(course.getId());
        if (newCourse != null) {
            em.remove(course);
            em.getTransaction().commit();
        } else {
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
    }
}
