package com.example.question.service;
/**
import com.example.question.form.Answer;
import com.example.question.repository.AnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService{

    private AnswerRepository answerRepository;

    public void setAnswerRepo(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public void addAnswer(Answer answer , Long id) {
        this.answerRepository.addAnswer(answer, id); // создан ответ, и передан ид_вопроса
    }

    @Override
    public void updateAnswer(Answer answer, Long id) {
        this.answerRepository.updateAnswer(answer, id);
    }

    @Override
    public Answer getAnswerById(Long id) {
        return this.answerRepository.getAnswerById(id);
    }

    @Override
    public void delete(Long id) {
        this.answerRepository.removeAnswer(id); // учесть каскадное удаление отсюда
    }

    @Override
    public void setRightAnswer(Long id) {
        this.answerRepository.setRightAnswer(id); //установка верного варианта ответа по ИД ответа
    }
}
*/