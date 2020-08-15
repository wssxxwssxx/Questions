package com.example.question.controller;

//import com.example.question.service.FormService;
import com.example.question.form.Form;
import com.example.question.repository.SearchRepository;
import com.example.question.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
public class TopicController {

    private TopicService topicService;


    @Autowired
    public void setFormService(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping("/form")
    public String getTopic(Model model) {
        model.addAttribute("forms", topicService.listForms());
        return "topic";
    }

    @PostMapping("/form")
    public String filter(@RequestParam String filter, Model model){
        model.addAttribute("forms", topicService.findByNameStartingWith(filter));
        model.addAttribute("forms", topicService.findByNameEndingWith(filter));
        model.addAttribute("forms", topicService.findByNameContaining(filter));
        return "topic";
    }


}
