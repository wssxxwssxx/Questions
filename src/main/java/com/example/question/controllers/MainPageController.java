package com.example.question.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    //MainPage
    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }
}
