package com.example.demo.service;


import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    void saveUser(User user);

    User getUserById(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);

}
