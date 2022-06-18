package com.example.pp_3_1_1_crud_springboot.service;

import com.example.pp_3_1_1_crud_springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class InitUsers {

    private final UserService userService;

    @Autowired
    public InitUsers(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void addInitUsersToDB() {
        userService.saveUser(new User("Anton","Antonov","Antonov@gmail.com","Engelsa 9"));
        userService.saveUser(new User("Ivan","Ivanov","Ivanov@gmail.com","Lenina 128"));
        userService.saveUser(new User("Maksim","Maksimov","Maksimov@gmail.com","Marksa 24"));
        userService.saveUser(new User("Andrey","Andreev","Andreev@gmail.com","Marksa 189"));
        userService.saveUser(new User("Evgeniy","Tarasov","Tarasov@gmail.com","Kurchatova 76"));
    }
}
