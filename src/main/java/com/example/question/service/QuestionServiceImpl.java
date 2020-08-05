package com.example.question.service;


import com.example.question.form.Question;
import com.example.question.repository.QuestionRepository;
import org.springframework.transaction.annotation.Transactional;


public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public void setFormRepo(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    @Transactional
    public void addQuestion(Question question) {
        this.questionRepository.addQuestion(question);
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        this.questionRepository.updateQuestion(question);
    }

    @Override
    @Transactional
    public Question getFormById(Long id) {
        return this.questionRepository.getFormById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.questionRepository.delete(id);
    }
}
