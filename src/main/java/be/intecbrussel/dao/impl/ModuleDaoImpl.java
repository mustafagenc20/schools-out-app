package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.CourseDao;
import be.intecbrussel.dao.ModuleDao;
import be.intecbrussel.model.Course;
import be.intecbrussel.model.Module;
import be.intecbrussel.utils.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;

public class ModuleDaoImpl implements ModuleDao {

    @Override
    public void save(Module module) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Module newModule = findById(module.getId());
        if (newModule == null) {
            em.merge(module);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity is already exist!");
        }
        em.close();

    }

    @Override
    public Module findById(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Module module = em.find(Module.class, id);
        if (module == null) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("I don't wanna work without implementation!");
        }
        em.close();
        return module;
    }

    @Override
    public List<Module> findAll() {
        return null;
    }

    @Override
    public void update(Module module) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Module newModule = findById(module.getId());
        if (newModule != null) {
            em.merge(module);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();

    }

    @Override
    public void remove(Module module) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Module newModule = findById(module.getId());
        if (newModule != null) {
            em.remove(module);
            em.getTransaction().commit();
        } else {
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();

    }
}
