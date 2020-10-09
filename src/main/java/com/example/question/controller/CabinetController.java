package com.example.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CabinetController {
    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String cabinet(){
        return "cabinet";
    }
}
