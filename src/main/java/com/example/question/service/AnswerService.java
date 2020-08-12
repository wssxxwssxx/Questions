package com.example.question.service;

import com.example.question.form.Answer;
import com.example.question.form.Question;
import org.springframework.stereotype.Service;


public interface AnswerService {
    public void addAnswer(Answer answer, Long id);

    public void updateAnswer(Answer answer, Long id);

    public Answer getAnswerById(Long id);

    public void delete(Long id);

    public void setRightAnswer(Long id);
}
