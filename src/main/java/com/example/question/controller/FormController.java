package com.example.question.controller;


import com.example.question.form.Answer;
import com.example.question.form.Form;
import com.example.question.form.Question;
import com.example.question.service.AnswerService;
import com.example.question.service.FormService;
import com.example.question.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {

    private FormService formService;
    private QuestionService questionService;
    private AnswerService answerService;
    @Autowired
    private IAuthenticationFacade authenticationFacade;

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
        Authentication authentication = authenticationFacade.getAuthentication();
        model.addAttribute("guestname", authentication.getName());

        // возможность добавить три ответа за одну отправку формы:
        Answers answers = new Answers();  //тут создается объект хранения!!!

        // три варианта ответа
        answers.addAnswer(new Answer());
        answers.addAnswer(new Answer());
        answers.addAnswer(new Answer());

        model.addAttribute("nForm", new Form());
        model.addAttribute("nQuestion", new Question());
        model.addAttribute("nAnswers", answers );
        return "newform";
    }

    @PostMapping("/newform")
    public String addForm(@ModelAttribute("nForm")  Form form,
                          @ModelAttribute("nQuestion") Question question, Model m,
                          @ModelAttribute("nAnswers") Answers answers){

        formService.saveForm(form);
        addQuestion(question,form.getId());
        saveAnswer(answers,question.getQid());
        return "/topic";
    }
    //--------------------------------------------------------------
    public void addQuestion(@ModelAttribute("nQuestion")Question question,Long formId) {
        questionService.saveQuestion(question, formId);
    }
    //--------------------------------------------------------------
    public void saveAnswer(@ModelAttribute("nAnswers")Answers answers, Long questionId) {
        for (Answer answer: answers.getAnswers()) {
            //System.out.println(answer);
            if (answer.getName() != null)
                answerService.saveAnswer(answer, questionId);
        }
    }
    //--------------------------------------------------------------
    // класс оболочка - список правильных ответов
    public class Answers {
        private List<Answer> answers ;           // здесь создаем список ответов

        @Autowired
        public Answers() {
            this.answers = new ArrayList<>();
        }


        public void addAnswer(Answer answer){
            System.out.println(answer);
            this.answers.add(answer);            // в список добавляем ответ
        }

        public List<Answer> getAnswers() {
            return answers;
        }

        public void setAnswers(List<Answer> answers) {
            this.answers = answers;
        }
    }




}