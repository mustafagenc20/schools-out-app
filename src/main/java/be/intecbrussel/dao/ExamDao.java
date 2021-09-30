package be.intecbrussel.dao;

import be.intecbrussel.model.Exam;
import be.intecbrussel.model.Person;

import java.util.List;

public interface ExamDao {
    Exam save(Exam exam);
    Exam findById(Long id);
    void update(Exam Exam);
    void remove(Exam exam);
    List<Exam> findAll();
}
