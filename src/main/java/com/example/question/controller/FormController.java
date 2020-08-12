package com.example.question.controller;


import com.example.question.entity.User;
import com.example.question.form.Form;
import com.example.question.form.Question;
import com.example.question.service.FormService;
import com.example.question.service.QuestionService;
import com.example.question.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    private FormService formService;
    private QuestionService questionService;


    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void setFormService(FormService formService) {
        this.formService = formService;
    }

    @GetMapping("/newform")
    public String setNewForm(Model model) {
        model.addAttribute("nForm", new Form());
        return "newform";
    }

    @PostMapping("/newform")
    public String addForm(@ModelAttribute("nForm")  Form form,
                          @ModelAttribute("nQuestion") Question question,
                          Model model) {
        formService.saveForm(form);
        addQuestion(question,form.getId(),model);
        return "redirect:/topic";
    }
    //--------------------------------------------------------------
    public void addQuestion(@ModelAttribute("nQuestion")Question question,Long formId, Model model) {
        questionService.saveQuestion(question, formId);
    }


}