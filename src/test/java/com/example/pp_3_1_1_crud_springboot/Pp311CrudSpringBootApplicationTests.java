package com.example.pp_3_1_1_crud_springboot;

import com.example.pp_3_1_1_crud_springboot.model.User;
import com.example.pp_3_1_1_crud_springboot.repository.UserDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class Pp311CrudSpringBootApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAddNew() {
        User user = new User();
        user.setFirstName("Dinis");
        user.setLastName("Kakasha");
        user.setEmail("uuter@hmail.com");
        user.setAddress("Anino 237");

        User savedUSer = userDao.save(user);

        Assertions.assertThat(savedUSer).isNotNull();
        Assertions.assertThat(savedUSer.getId()).isGreaterThan(0);
    }

    @Test
    public void testAllList() {
        List<User> users = userDao.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println();
        }

    }

    @Test
    public void testUpdate() {
        long userid = 4;
        Optional<User> optionalUser = userDao.findById(userid);
        User user = optionalUser.get();
        user.setEmail("hello2022");

        userDao.save(user);

        User updatedUser = userDao.findById(userid).get();
        Assertions.assertThat(updatedUser.getEmail()).isEqualTo("hello2022");
    }

    @Test
    public void testDelete() {
        long userId = 5;
        userDao.deleteById(userId);

        Optional<User> optionalUser = userDao.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
