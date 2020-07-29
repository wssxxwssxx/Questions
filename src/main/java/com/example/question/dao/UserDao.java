package com.example.question.dao;


import com.example.question.model.Role;
import com.example.question.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
