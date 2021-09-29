package be.intecbrussel.dao;

import be.intecbrussel.model.Module;

import java.util.List;

public interface ModuleDao {

    void save(Module module);
    Module findById(Long id);
    List<Module> findAll();
    void update(Module module);
    void remove(Module module);
}
