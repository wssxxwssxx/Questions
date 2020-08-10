package com.example.question.service;

import com.example.question.form.Form;
import com.example.question.form.Question;

public interface QuestionService {

    public void addQuestion(Question question, Long id);

    public void updateQuestion(Question question, Long id);

    public Question getQuestionById(Long id);

    public void delete(Long id);

}
