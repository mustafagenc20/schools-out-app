package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.ExamDao;
import be.intecbrussel.model.Exam;
import be.intecbrussel.model.Person;
import be.intecbrussel.utils.EntityManagerProvider;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ExamDaoImpl implements ExamDao {
    @Override
    public Exam save(Exam exam) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Exam newExam = em.merge(exam);
        em.getTransaction().commit();
        em.close();
        return newExam;
    }

    @Override
    public Exam findById(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Exam exam = em.find(Exam.class, id);
        if (exam != null) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
        return exam;
    }

    @Override
    public void update(Exam exam) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Exam newExam = findById(exam.getId());
        if (newExam != null) {
            em.merge(exam);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
    }

    @Override
    public void remove(Exam exam) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Exam newExam = findById(exam.getId());
        if (newExam != null) {
            em.remove(exam);
            em.getTransaction().commit();
        } else {
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
    }

    @Override
    public List<Exam> findAll() {
        String query = "Select p from Exam p";
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Exam> typedQuery = em.createQuery(query, Exam.class);
        List<Exam> examList = typedQuery.getResultList();
        em.getTransaction().commit();
        em.close();
        return examList;
    }
}
