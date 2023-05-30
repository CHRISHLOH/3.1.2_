package com.example.demo.dao;


import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveUser(User user){
        entityManager.persist(user);
    }

    @Override
    public User getUserByID(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        User user = entityManager.find(User.class, id);
        if(user != null){
            user.setName(updatedUser.getName());
            user.setLastName(updatedUser.getLastName());
            entityManager.merge(user);
        }
    }

    @Override
    public void deleteUser(int id) {
        User user = getUserByID(id);
        if (user != null){
            entityManager.remove(user);
        }
    }

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

}
