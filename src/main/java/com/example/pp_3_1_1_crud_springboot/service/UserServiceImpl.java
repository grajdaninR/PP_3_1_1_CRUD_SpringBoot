package com.example.pp_3_1_1_crud_springboot.service;

import com.example.pp_3_1_1_crud_springboot.model.User;
import com.example.pp_3_1_1_crud_springboot.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }
    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}



