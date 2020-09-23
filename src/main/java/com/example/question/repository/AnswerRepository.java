package com.example.question.repository;

import com.example.question.form.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


public interface AnswerRepository extends JpaRepository<Answer,Long> {
    List<Answer> getAnswersByQuestionId(Long id);

    List<Answer> getAnswersByQuestionIdOrderByProperlyAsc(Long id);


    @Query(value = "SELECT COUNT(a.aname) FROM t_answer a WHERE (a.properly = true) AND (a.user_answer = a.properly)", nativeQuery = true)
    Integer countRights();

}
