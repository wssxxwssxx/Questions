package com.example.question.controller;

import com.example.question.form.Answer;
import com.example.question.form.Form;
import com.example.question.form.Question;
import com.example.question.service.AnswerService;
import com.example.question.service.FormService;
import com.example.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    private FormService formService;

    private QuestionService questionService;


    private AnswerService answerService;

    @Autowired(required=true)
    //@Qualifier(value="formService")
    public void setFormService(FormService fs){
        this.formService = fs;
    }

    @RequestMapping(value = "/forms", method = RequestMethod.GET)
    public String listForms(Model model) {
        model.addAttribute("form", new Form());
        model.addAttribute("listForms", this.formService.listForms());
        return "form";
    }

    // Создаем новую форму с вопросами
    @PostMapping(value= "/newform")
    public String addForm(@ModelAttribute("form") Form form,
                          @ModelAttribute("question") Question question,
                          @ModelAttribute("answer") Answer[] answers,
                          @ModelAttribute("isTrue") boolean isTrue,
                          Model model){

        if(form.getId() == 0) {
            //---------- добавляем форму ---------------------
            this.formService.addForm(form);
            //---------- добавляем пустые вопросы ------------
            this.questionService.addQuestion(question,form.getId());
            //----------- наполним каждый вопрос ответами ----
                for (int j = 0; j < 3; j++) {
                    answers[j].setProperly(isTrue);
                    this.answerService.addAnswer(answers[j],question.getId());
                }
        }
        return "redirect:/";
    }

    @RequestMapping("/remove/{id}")
    public String removeForm(@PathVariable("id") Long id){

        this.formService.removeForm(id);
        return "redirect:/forms";
    }

    @RequestMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("form", this.formService.getFormById(id));
        model.addAttribute("listForms", this.formService.listForms());
        return "form";
    }

}