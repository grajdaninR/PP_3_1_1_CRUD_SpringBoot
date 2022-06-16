package com.example.pp_3_1_1_crud_springboot.service;

import com.example.pp_3_1_1_crud_springboot.model.User;
import com.example.pp_3_1_1_crud_springboot.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addInitUsersToDB() {
        List<User> initUsersList = new ArrayList<>();
        userDao.deleteAll();

        initUsersList.add(new User("Anton","Antonov","Antonov@gmail.com","Engelsa 9"));
        initUsersList.add(new User("Ivan","Ivanov","Ivanov@gmail.com","Lenina 128"));
        initUsersList.add(new User("Maksim","Maksimov","Maksimov@gmail.com","Marksa 24"));
        initUsersList.add(new User("Andrey","Andreev","Andreev@gmail.com","Marksa 189"));
        initUsersList.add(new User("Evgeniy","Tarasov","Tarasov@gmail.com","Kurchatova 76"));
        for (User user : initUsersList) {
            userDao.saveAndFlush(user);
        }
    }

    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

}



