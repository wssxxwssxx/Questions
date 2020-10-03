package com.example.question.service;

import com.example.question.form.Form;
import com.example.question.form.Question;
import com.example.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public boolean saveQuestion(Question question, Long formId) {
            question.setFormID(formId);           //устанавливаем ссылку на ид_формы
            questionRepository.save(question);    //сохраняем вопрос
        return true;
    }

    //public Page<Question> getQuestionsByFormId(Long id, Pageable pageable, int pageNo, int pageSize){
    //    Pageable p = pageable;
    //    p = PageRequest.of(pageNo-1, pageSize);
    //    return questionRepository.getQuestionsByFormID(id, p);
    //}

    public List<Question> getQuestionsByFormId(Long id){
        return questionRepository.getQuestionsByFormID(id);
    }

}
