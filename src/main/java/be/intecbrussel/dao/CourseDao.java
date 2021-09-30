package be.intecbrussel.dao;

import be.intecbrussel.model.Course;

import java.util.List;

public interface CourseDao {

    Course save(Course course);
    Course findById(Long id);
    void update(Course course);
    void remove(Course course);
}
