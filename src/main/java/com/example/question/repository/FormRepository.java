package com.example.question.repository;

import com.example.question.form.Form;

import java.util.List;

public interface FormRepository {

    public void addForm(Form f);
    public void updateForm(Form f);
    public List<Form> listForms();
    public Form getFormById(Long id);
    public void removeForm(Long id);
}