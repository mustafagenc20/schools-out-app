package be.intecbrussel.dao;

import be.intecbrussel.model.Person;

import java.util.List;

public interface PersonDao {
    Person save(Person person);
    Person findById(Integer id);
    void update(Person person);
    void remove(Person person);
}
