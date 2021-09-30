package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.ModuleDao;
import be.intecbrussel.model.Module;
import be.intecbrussel.model.Person;
import be.intecbrussel.utils.EntityManagerProvider;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ModuleDaoImpl implements ModuleDao {

    @Override
    public Module save(Module module) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Module newModule = em.merge(module);
        em.getTransaction().commit();
        em.close();
        return newModule;
    }

    @Override
    public Module findById(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        Module module = em.find(Module.class, id);
        if (module != null) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
        return module;
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
            em.remove(module.getId());
            em.getTransaction().commit();
        } else {
            throw new UnsupportedOperationException("Entity doesn't exist!");
        }
        em.close();
    }

    @Override
    public List<Module> findAll() {
        String query = "Select p from Module p";
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Module> typedQuery = em.createQuery(query, Module.class);
        List<Module> moduleList = typedQuery.getResultList();
        em.getTransaction().commit();
        em.close();
        return moduleList;
    }
}
