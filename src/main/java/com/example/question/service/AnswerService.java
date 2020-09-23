package com.example.question.service;

import com.example.question.form.Answer;
import com.example.question.form.Question;
import com.example.question.repository.AnswerRepository;
import com.example.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;


    public boolean saveAnswer(Answer answer, Long questionId) {
        answer.setQuestionId(questionId);           //устанавливаем ссылку на ид_вопроса
        answerRepository.save(answer);              //сохраняем вопрос
        return true;
    }

    //public boolean updateAnswer(Answer answer, Long questionId) {
    //    answer.setQuestionId(questionId);
    //    answerRepository.
    //}


    public boolean delete(Long id){
        if (answerRepository.findById(id).isPresent()) {
            answerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Answer> getAnswersByQuestionId(Long id){
        return answerRepository.getAnswersByQuestionId(id);
    }

    public List<Answer> getAnswersByQuestionIdOrderByProperly(Long id){
        return answerRepository.getAnswersByQuestionIdOrderByProperlyAsc(id);
    }

}
