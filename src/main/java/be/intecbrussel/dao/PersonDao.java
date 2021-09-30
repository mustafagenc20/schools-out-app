package be.intecbrussel.dao;

import be.intecbrussel.model.Person;

import java.util.List;

public interface PersonDao {
    void save(Person person);
    Person findById(Integer id);
    List<Person> findAll();
    void update(Person person);
    void remove(Person person);
}
