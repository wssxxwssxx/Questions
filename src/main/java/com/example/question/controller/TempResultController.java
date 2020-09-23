package com.example.question.controller;


import com.example.question.form.Answer;
import com.example.question.results.TempResult;
import com.example.question.service.TempResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class TempResultController {

    //List<Answer> answers = new ArrayList<>();
    private Integer countRight;

    @Autowired
    private TempResultService TRS;

    public void setTRS(TempResultService TRS) {
        this.TRS = TRS;
    }

//    @GetMapping(value = "/results")
//    public String showResults(Model model) {
//        // show results
//        model.addAttribute("trueAnswers",calculate());
//        return "results";
//    }

    @GetMapping("/results")
    public String setResult(@ModelAttribute("uAnswers") AnswerController.Answers2 answers, Model model){
//        this.answers.addAll((Collection<? extends Answer>) answers);
//
//        for (Answer a: this.answers) {
//            TRS.saveRes(new TempResult(), a.getId(),a.getProperly());
//        }
        this.setCountRight(TRS.getCountRights());
        model.addAttribute("trueAnswers", this.getCountRight() );

        return "results";
    }

    @PostMapping("/results")
    public String viewResult(@ModelAttribute("uAnswers") AnswerController.Answers2 answers, Model model){
//        this.answers.addAll((Collection<? extends Answer>) answers);
//
//        for (Answer a: this.answers) {
//            TRS.saveRes(new TempResult(), a.getId(),a.getProperly());
//        }
        this.setCountRight(TRS.getCountRights());
        model.addAttribute("trueAnswers", this.getCountRight() );

        return "results";
    }


    public int calculate (){
        return TRS.getCountRights();
    }

//    public int calculate(){
//        Map tRes = new HashMap();
//        List<Boolean> LB = new ArrayList<Boolean>();
//
//        tRes = TRS.getTResult();
//        LB.addAll(tRes.values());
//
//        return LB.size();
//    }



    public Integer getCountRight() {
        return countRight;
    }

    public void setCountRight(Integer countRight) {
        this.countRight = countRight;
    }
}
