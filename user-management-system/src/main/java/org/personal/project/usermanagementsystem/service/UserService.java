package org.personal.project.usermanagementsystem.service;

import org.personal.project.usermanagementsystem.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    void saveUser(User user);
    void updateAllUserColumns(Long userId, User user);
    void deleteUserById(Long userId);
}
