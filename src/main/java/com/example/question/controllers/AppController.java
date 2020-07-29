package com.example.question.controllers;

import com.example.question.model.Role;
import com.example.question.model.User;
import com.example.question.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class AppController {

    @Autowired
    private UserRepo userRepo;

    //MainPage
    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/newform")
    public String newForm(){
        return "newform";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @GetMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/registration"; //ЗДЕСЬ БЕЗ ПОНЯТИЯ ЧТО УКАЗАТЬ
    }

    @GetMapping("/authorized")
    public String authorized(){
        return "authorized";
    }
}
