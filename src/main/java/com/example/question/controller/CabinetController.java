package com.example.question.controller;

import com.example.question.entity.User;
import com.example.question.form.Form;
//import com.example.question.repository.CabinetRepository;
import com.example.question.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CabinetController {


    @Autowired
    FormRepository formRepository;

    @RequestMapping(value = "/cabinet/{id}")
    public String cabinet(){
        return "cabinet";
    }

    @RequestMapping(value = "/cabinet")
    public String getForm(Model model){
        Form form = new Form();
        model.addAttribute("userForm",formRepository.getFormByName(form.getName()));
        return "cabinet";
    }
}
