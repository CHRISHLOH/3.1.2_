package com.example.demo.dao;


import com.example.demo.model.User;


import java.util.List;

public interface UserDao {


    List<User> getUserList();

    void saveUser(User user);

    User getUserByID(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);

}
