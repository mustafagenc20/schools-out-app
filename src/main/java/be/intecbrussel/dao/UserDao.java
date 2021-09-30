package be.intecbrussel.dao;

import be.intecbrussel.model.User;

public interface UserDao {
    User save(User user);
    User findById(String id);
    void update(User user);
    void remove(User user);
}
