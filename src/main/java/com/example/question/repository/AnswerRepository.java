package com.example.question.repository;

import com.example.question.form.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;


public interface AnswerRepository extends JpaRepository<Answer,Long> {
    List<Answer> getAnswersByQ_id(Long qId);
    List<Answer> getAnswersByQ_idOrderByProperly(Long qId);

}
