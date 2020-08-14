package com.example.question.service;

import com.example.question.form.Form;
import com.example.question.repository.FormRepository;
import com.example.question.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {


    @Autowired
    FormRepository formRepository;

    @Autowired
    SearchRepository searchRepository;

    @Transactional
    public List<Form> listForms() {
        return formRepository.findAll();
    }

    @Transactional
    public List<Form> findByNameStartingWith(String name){return searchRepository.findByNameStartingWith(name);}

    @Transactional
    public List<Form> findByNameEndingWith(String name){return searchRepository.findByNameEndingWith(name);}

    @Transactional
    public List<Form> findByNameContaining(String name){return searchRepository.findByNameContaining(name);}


}
