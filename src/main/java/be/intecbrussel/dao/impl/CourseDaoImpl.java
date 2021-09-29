package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.CourseDao;
import be.intecbrussel.model.Course;
import be.intecbrussel.utils.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public void save(Course course) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Course newCourse = findById(course.getId());
        if (newCourse == null) {
            em.merge(course);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity already exist!");
        }
        em.close();

    }

    @Override
    public Course findById(Long id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void remove(Course course) {

    }
}
