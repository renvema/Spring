package com.service;

import com.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);

    Optional<User> findUserByEmail(String email);
}
