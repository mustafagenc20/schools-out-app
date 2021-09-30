package be.intecbrussel.dao;

import be.intecbrussel.model.Exam;

public interface ExamDao {
    Exam save(Exam exam);
    Exam findById(Long id);
    void update(Exam Exam);
    void remove(Exam exam);
}
