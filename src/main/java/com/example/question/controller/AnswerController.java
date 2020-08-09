package com.example.question.controller;


import com.example.question.form.Answer;

import com.example.question.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AnswerController {
    private AnswerService answerService;

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping(value = "/форма_отв", method = RequestMethod.GET)
    public String addAnswer(@ModelAttribute("answer") Answer answer){
        if(answer.getId() == 0){
            this.answerService.addAnswer(answer);
        }
        else {
            this.answerService.updateAnswer(answer);
        }

        return "redirect:/форма_вопроса";
    }

    @RequestMapping("/ans")
    public String removeAnswer(@PathVariable("id") Long id){

        this.answerService.delete(id);
        return "redirect:/форма_вопроса";
    }

    @RequestMapping("/ans/{id}")
    public String editAnswer(@PathVariable("id") Long id, Model model){
        model.addAttribute("форма вопроса", this.answerService.getAnswerById(id));
        return "вопрос";
    }

}
