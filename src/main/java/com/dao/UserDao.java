package com.dao;

import com.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);

    Optional<User> findUserByEmail(String email);
}
