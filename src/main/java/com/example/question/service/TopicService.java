package com.example.question.service;

import com.example.question.form.Form;
import com.example.question.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {


    @Autowired
    FormRepository formRepository;

    @Transactional
    public List<Form> listForms() {
        return formRepository.findAll();
    }

}
