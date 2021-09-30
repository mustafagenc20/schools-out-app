package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.ExamDao;
import be.intecbrussel.model.Exam;
import be.intecbrussel.utils.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;

public class ExamDaoImpl implements ExamDao {
    @Override
    public void save(Exam exam) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Exam newExam = findById(exam.getId());
        if (newExam == null) {
            em.merge(exam);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity is already exist!");
        }
        em.close();
    }

    @Override
    public Exam findById(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Exam exam = em.find(Exam.class, id);
        if (exam == null) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("I don't wanna work without implementation!");
        }
        em.close();
        return exam;
    }

    @Override
    public List<Exam> findAll() {

//        String query = "SELECT e FROM Employee e WHERE e.employee = :employee";
//        EntityManager em = EntityManagerProvider.getEntityManager();
//
//        em.getTransaction().begin();
//        TypedQuery<Exam> typedQuery = em.createQuery(query, Exam.class);
//        typedQuery.setParameter("Exam", );
//        List<Exam> employees = typedQuery.getResultList();
//
//        em.getTransaction().commit();
//
//        em.close();
        return null;
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
}
