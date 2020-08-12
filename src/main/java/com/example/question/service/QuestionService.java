package com.example.question.service;

import com.example.question.form.Form;
import com.example.question.form.Question;
import com.example.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public boolean saveQuestion(Question question, Long formId) {
            question.setFormID(formId);           //устанавливаем ссылку на ид_формы
            questionRepository.save(question);    //сохраняем вопрос
        return true;
    }


}
