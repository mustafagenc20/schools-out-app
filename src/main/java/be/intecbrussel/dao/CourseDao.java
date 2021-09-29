package be.intecbrussel.dao;

import be.intecbrussel.model.Course;

import java.util.List;

public interface CourseDao {

    void save(Course course);
    Course findById(Long id);
    List<Course> findAll();
    void update(Course course);
    void remove(Course course);
}
