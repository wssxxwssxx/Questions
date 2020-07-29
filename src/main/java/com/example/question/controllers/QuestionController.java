package com.example.question.controllers;

import com.example.question.model.User;
import com.example.question.service.UserService;
import com.example.question.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionController {
    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        //userValidator.validate(userForm, bindingResult);

        //if (bindingResult.hasErrors()) {
       //     return "registration";
       // }

        userService.save(userForm);

       // securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/main";
    }
}
