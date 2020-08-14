package com.example.question.repository;

import com.example.question.form.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRepository extends JpaRepository<Form,Long> {

    List<Form> findByNameStartingWith(String name);
    List<Form> findByNameEndingWith(String name);
    List<Form> findByNameContaining(String name);

}
