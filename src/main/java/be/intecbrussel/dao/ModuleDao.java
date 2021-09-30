package be.intecbrussel.dao;

import be.intecbrussel.model.Module;

import java.util.List;

public interface ModuleDao {

    Module save(Module module);
    Module findById(Long id);
    void update(Module module);
    void remove(Module module);
}
