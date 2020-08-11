package com.example.question.repository;

import com.example.question.form.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FormRepository extends JpaRepository<Form,Long> {


}