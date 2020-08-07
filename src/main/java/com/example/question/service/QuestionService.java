package com.example.question.service;

import com.example.question.form.Question;

public interface QuestionService {

    public void addQuestion(Question question);

    public void updateQuestion(Question question);

    public Question getQuestionById(Long id);

    public void delete(Long id);

}
