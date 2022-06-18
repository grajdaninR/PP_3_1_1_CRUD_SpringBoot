package com.example.pp_3_1_1_crud_springboot.service;

import com.example.pp_3_1_1_crud_springboot.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

     Optional<User> findById(Long id);

     List<User> findAll();

     User saveUser(User user);

     void deleteById(Long id);

}
