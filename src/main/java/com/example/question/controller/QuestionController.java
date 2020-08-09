package com.example.question.controller;

import com.example.question.form.Question;
import com.example.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionController {

    private  QuestionService questionService;

    @Autowired(required = true)
    public void setQuestionService(QuestionService questionService){
        this.questionService = questionService;
    }

    @RequestMapping(value = "/форма_вопроса", method = RequestMethod.GET)
    public String addQuestion(@ModelAttribute("question")Question question){
        if(question.getId() == 0){
            this.questionService.addQuestion(question);
        }
        else {
            this.questionService.updateQuestion(question);
        }

        return "redirect:/форма_вопроса";
    }

    @RequestMapping("/qwe")
    public String removeForm(@PathVariable("id") Long id){

        this.questionService.delete(id);
        return "redirect:/форма_вопроса";
    }

    @RequestMapping("/qwe/{id}")
    public String editForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("форма вопроса", this.questionService.getQuestionById(id));
        return "вопрос";
    }

}
