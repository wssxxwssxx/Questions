package com.example.question.service;


import com.example.question.form.Question;
import com.example.question.repository.QuestionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public void setQuestionRepo(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    @Transactional
    public void addQuestion(Question question, Long id) {
        this.questionRepository.addQuestion(question, id);
    }

    @Override
    @Transactional
    public void updateQuestion(Question question, Long id) {
        this.questionRepository.updateQuestion(question, id);
    }

    @Override
    @Transactional
    public Question getQuestionById(Long id) {
        return this.questionRepository.getQuestionById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.questionRepository.delete(id);
    }
}
