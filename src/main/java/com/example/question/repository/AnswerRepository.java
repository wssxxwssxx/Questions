package com.example.question.repository;

import com.example.question.form.Answer;
import java.util.List;


public interface AnswerRepository {

    public void addAnswer(Answer answer, Long questionId);
    public void updateAnswer(Answer answer, Long questionId);
    public List<Answer> listAnswer(Long questionId);
    public Answer getAnswerById(Long id);
    public void removeAnswer(Long id);
    public void setRightAnswer(Long id);
}
