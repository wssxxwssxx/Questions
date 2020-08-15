package com.example.question.controller;

import com.example.question.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CabinetController {

    @GetMapping("/cabinet")
    public String cabinet(){
        return "cabinet";
    }
}
