package be.intecbrussel.dao;

import be.intecbrussel.model.Course;
import be.intecbrussel.model.User;

import java.util.List;

public interface UserDao {
    User save(User user);
    User findById(String id);
    void update(User user);
    void remove(User user);
}
