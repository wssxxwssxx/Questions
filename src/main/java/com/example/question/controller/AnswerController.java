package com.example.question.controller;


import com.example.question.form.Answer;
import com.example.question.form.Question;
import com.example.question.service.AnswerService;
import com.example.question.service.FormService;
import com.example.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    public Page<Question> questionList;
    public List<String> answerList;
    public Map<Long, Boolean> allAnswers = new HashMap<>();
    public List<Answer> correctAnswers = new ArrayList<>();

    public List<Question> qList= new ArrayList<>();

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

    @GetMapping(value = "/answers/{pageNo}")
    public String addAnswer(@PathVariable (value = "pageNo") int pageNo,
                            Model model,
                            @PageableDefault(sort = {"qid"},
                                            direction = Sort.Direction.ASC) Pageable pageable){
        //if (name == null || name.isEmpty()){
          //  return "#";
        //}
        int pageSize = 1;
        setTopicName("Преступление и наказание");
        this.tId = 3000L;//formService.getIdByName(name);



        loadFromDb(this.tId, pageable, pageNo, pageSize);
        model.addAttribute("qList", this.qList);
        model.addAttribute("topicName", this.topicName);
        model.addAttribute("questionList", this.questionList);
        model.addAttribute("answerList",this.answerList);
        model.addAttribute("counter", pageNo);
        model.addAttribute("allQuestion", questionList.getTotalElements());

        return "answers";
    }

    public void loadFromDb(Long qid, Pageable pageable, int pageNumber, int pageSize){
        this.answerList = new ArrayList<>();
        questionList = questionService.getQuestionsByFormId(this.tId, pageable, pageNumber, pageSize);
        qList = questionList.getContent();
        this.qId = qList.get(0).getQid();

        int qq = answerService.getAnswersByQuestionId(qId).size();
        for (int j =0; j < qq; j++){
            this.answerList.add(answerService.getAnswersByQuestionId(qId).get(j).getName());
    }

//    public void loadFromDb(Long tId) {
//        // название темы +
//        // вытянуть из базы название +
//        // массив вопросы +
//        // вытянуть вопросы в массив +
//        // ответы массив +
//        // вытянуть ответы +
//        int qq = questionService.getQuestionsByFormId(tId).size(); //3
//        // Loading questions
//
//        for (int i = 0; i < 1 ; i++) {
//            this.questionList.add(questionService.getQuestionsByFormId(tId).get(i).getName());
//            this.qId = questionService.getQuestionsByFormId(tId).get(i).getQid();
//            loadAnswers(this.qId, qq);
//        }
//    }

    //public void loadAnswers (Long qID, int qq) {

     //   int qa = answerService.getAnswersByQuestionId(qID).size(); //6
        // Loading all answers
    //    for (int j =0; j < 6; j++){
           // this.answerList.add(answerService.getAnswersByQuestionId(qID).get(j).getName());
            //this.allAnswers.put(answerService.getAnswersByQuestionId(qID).get(j).getId(),
              //      answerService.getAnswersByQuestionId(qID).get(j).getProperly());
        }

        // Loading correct answers ONLY!
//        for (int k =0; k < answerService.getAnswersByQuestionIdOrderByProperly(qID).size(); k++) {
//            if(answerService.getAnswersByQuestionIdOrderByProperly(qID).get(k).getProperly())
//                this.correctAnswers.add(answerService.getAnswersByQuestionIdOrderByProperly(qID).get(k));
//        }
   // }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }


}
