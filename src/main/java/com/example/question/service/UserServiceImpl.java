package com.example.question.service;


import com.example.question.dao.RoleDao;
import com.example.question.dao.UserDao;
import com.example.question.model.Role;
import com.example.question.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    private UserDao userDao;


    private RoleDao roleDao;

    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;


    public void save(User user) {
        //user.setConfirmPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
