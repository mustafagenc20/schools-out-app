package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.GradeDao;
import be.intecbrussel.model.Grade;
import be.intecbrussel.model.Person;
import be.intecbrussel.utils.EntityManagerProvider;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GradeDaoImpl implements GradeDao {
    @Override
    public Grade save(Grade grade) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Grade newGrade = em.merge(grade);
        em.getTransaction().commit();
        em.close();
        return newGrade;
    }

    @Override
    public Grade findById(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Grade grade = em.find(Grade.class, id);
        if (grade != null) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
        return grade;
    }

    @Override
    public void update(Grade grade) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Grade newGrade = findById(grade.getId());
        if (newGrade != null) {
            em.merge(grade);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
    }

    @Override
    public void remove(Grade grade) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Grade newGrade = findById(grade.getId());
        if (newGrade != null) {
            em.remove(grade);
            em.getTransaction().commit();
        } else {
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
    }

    @Override
    public List<Grade> findAll() {
        String query = "Select p from Grade p";
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Grade> typedQuery = em.createQuery(query, Grade.class);
        List<Grade> gradeList = typedQuery.getResultList();
        em.getTransaction().commit();
        em.close();
        return gradeList;
    }
}
