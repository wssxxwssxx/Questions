package com.example.question.controller;


import com.example.question.entity.User;
import com.example.question.form.Answer;
import com.example.question.form.Form;
import com.example.question.form.Question;
import com.example.question.service.AnswerService;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {

    private FormService formService;
    private QuestionService questionService;
    private AnswerService answerService;

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

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
        ArrayList<Answer> answers = new ArrayList<>(Arrays.asList(

                new Answer(),
                new Answer(),
                new Answer(),
                new Answer(),
                new Answer()));
        model.addAttribute("nForm", new Form());
        model.addAttribute("nQuestion", new Question());
        model.addAttribute("nAnswers", answers );
        return "newform";
    }

    @PostMapping("/newform")
    public String addForm(@ModelAttribute("nForm")  Form form,
                          @ModelAttribute("nQuestion") Question question, Model m
                          ){

        //@ModelAttribute("nAnswers") ArrayList<Answer> answers;

        ArrayList<Answer> answers = new ArrayList<>(Arrays.asList(

                new Answer(),
                new Answer(),
                new Answer(),
                new Answer(),
                new Answer()));
        m.addAttribute("nAnswers", answers);

        formService.saveForm(form);
        addQuestion(question,form.getId());
        addAnswer(answers,question.getId());
        return "/topic";
    }
    //--------------------------------------------------------------
    public void addQuestion(@ModelAttribute("nQuestion")Question question,Long formId) {
        questionService.saveQuestion(question, formId);
    }
    //--------------------------------------------------------------
    public void addAnswer(@ModelAttribute("nAnswers")List<Answer> answers, Long questionId) {
        for (Answer answer: answers) {
            //System.out.println(answer);
            //if (answer != null)
                answerService.saveAnswer(answer, questionId);
        }

    }

}