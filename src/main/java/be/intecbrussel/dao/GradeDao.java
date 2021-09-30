package be.intecbrussel.dao;

import be.intecbrussel.model.Grade;
import be.intecbrussel.model.Person;

import java.util.List;

public interface GradeDao {

    Grade save(Grade grade);
    Grade findById(Long id);
    void update(Grade grade);
    void remove(Grade grade);
    List<Grade> findAll();
}
