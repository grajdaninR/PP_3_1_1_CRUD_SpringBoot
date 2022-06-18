package com.example.pp_3_1_1_crud_springboot.repository;

import com.example.pp_3_1_1_crud_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User,Long> {

}
