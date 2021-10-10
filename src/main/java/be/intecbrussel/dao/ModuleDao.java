package be.intecbrussel.dao;

import be.intecbrussel.model.Module;
import be.intecbrussel.model.Person;

import java.util.List;

public interface ModuleDao {

    Module save(Module module);
    Module findById(Long id);
    Module update(Module module);
    void remove(Module module);
    List<Module> findAll();
}
