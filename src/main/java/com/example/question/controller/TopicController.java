package com.example.question.controller;

//import com.example.question.service.FormService;
import com.example.question.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TopicController {

    private TopicService topicService;

    @Autowired
    public void setFormService(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping("/topic")
    public String getTopic(Model model) {
        model.addAttribute("forms", topicService.listForms());
        return "topic";
    }


}
