package com.example.question.service;


import com.example.question.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
