package com.example.question.service;



import com.example.question.controller.AnswerController;
import com.example.question.form.Answer;
import com.example.question.repository.AnswerRepository;
import com.example.question.repository.SaveResultsRepository;
import com.example.question.results.TempResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

@Service
public class TempResultService {



    @Autowired
    //SaveResultsRepository saveResults; //ссылка на сохранить_результат_репо
    AnswerRepository ans;





//    public boolean saveRes(TempResult tr, Long id, Boolean checked){
//        tr.setAnswerId(id);         //переданому результату задаем ид_ответа
//        tr.setUserAnswer(checked);  //переданому результату задаем выбраный ответ пользователя
//        saveResults.save(tr);       //сохраняем результат
//        return true;
//    }

    //вызываем проверку результат
//    public Map<Long, Boolean> getTResult(){
//        return saveResults.tResult();
//    }

   public Integer getCountRights(){
       return ans.countRights();
   }

}
