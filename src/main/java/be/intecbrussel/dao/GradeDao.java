package be.intecbrussel.dao;

import be.intecbrussel.model.Grade;

public interface GradeDao {

    Grade save(Grade grade);
    Grade findById(Long id);
    void update(Grade grade);
    void remove(Grade grade);
}
