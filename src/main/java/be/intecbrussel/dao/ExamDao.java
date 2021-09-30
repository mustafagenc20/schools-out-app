package be.intecbrussel.dao;

import be.intecbrussel.model.Course;
import be.intecbrussel.model.Exam;

import java.util.List;

public interface ExamDao {
    void save(Exam exam);
    Exam findById(Long id);
    List<Exam> findAll();
    void update(Exam Exam);
    void remove(Exam exam);
}
