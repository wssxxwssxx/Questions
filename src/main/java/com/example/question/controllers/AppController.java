package com.example.question.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

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

    @GetMapping("/authorized")
    public String authorized(){
        return "authorized";
    }
}
