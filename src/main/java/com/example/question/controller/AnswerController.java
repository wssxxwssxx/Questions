package com.example.question.controller;


import com.example.question.form.Answer;
import com.example.question.service.AnswerService;
import com.example.question.service.FormService;
import com.example.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
    public class AnswerController {
    private AnswerService answerService;
    private QuestionService questionService;
    private FormService formService;



    private String topicName;
    public Long tId;
    public Long qId;
    public int counter;
    public int allQuestion;

    public List<String> questionList;
    public List<String> answerList;
    public Map<Long, Boolean> allAnswers;
    public List<Answer> correctAnswers;

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService){
        this.questionService = questionService;
    }

    @Autowired
    public void setFormService(FormService formService) {
        this.formService = formService;
    }

    @GetMapping(value = "/answers")
    public String addAnswer(String name,Model model ){
        if (name == null || name.isEmpty()){
            return "redirect:/topic";
        }

        setTopicName(name);
        this.tId = formService.getIdByName(name);
        loadFromDb(this.tId);
        model.addAttribute("topicName", this.topicName);
        model.addAttribute("questionList", this.questionList);
        model.addAttribute("answerList",this.answerList);
        model.addAttribute("counter", this.counter);
        model.addAttribute("allQuestion", this.allQuestion);

        return "answers";
    }

    public void loadFromDb(Long tId) {
        // название темы +
        // вытянуть из базы название +
        // массив вопросы +
        // вытянуть вопросы в массив +
        // ответы массив +
        // вытянуть ответы +

        // Loading questions
        this.questionList = new ArrayList<>();
        for (int i = 0; i < questionService.getQuestionsByFormId(tId).size(); i++) {
            this.questionList.add(questionService.getQuestionsByFormId(tId).get(i).getName());
            this.qId = questionService.getQuestionsByFormId(tId).get(i).getId();
            loadAnswers(this.qId);
        }
    }

    public void loadAnswers (Long qID) {
        this.answerList = new ArrayList<>();
        this.allAnswers = new HashMap<>();

        // Loading all answers
        for (int j =0; j < answerService.getAnswersByQuestionId(qID).size(); j++){
            this.answerList.add(answerService.getAnswersByQuestionId(qID).get(j).getName());
            this.allAnswers.put(answerService.getAnswersByQuestionId(qID).get(j).getId(),
                    answerService.getAnswersByQuestionId(qID).get(j).getProperly());
        }

        // Loading correct answers ONLY!
        for (int k =0; k < answerService.getAnswersByQuestionIdOrderByProperly(qID).size(); k++) {
            if(answerService.getAnswersByQuestionIdOrderByProperly(qID).get(k).getProperly())
                this.correctAnswers.add(answerService.getAnswersByQuestionIdOrderByProperly(qID).get(k));
        }
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }


}
