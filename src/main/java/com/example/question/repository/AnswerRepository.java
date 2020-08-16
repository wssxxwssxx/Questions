package com.example.question.repository;

import com.example.question.form.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AnswerRepository extends JpaRepository<Answer,Long> {


}
