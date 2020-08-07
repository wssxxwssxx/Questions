package com.example.question.repository;

import com.example.question.form.Question;


public interface QuestionRepository {

    public void addQuestion(Question question);

    public void updateQuestion(Question question);

    public Question getQuestionById(Long id);

    public void delete(Long id);
}
