package com.example.question.service;
/**
import com.example.question.form.Form;
import com.example.question.repository.FormRepository;
import com.example.question.repository.FormRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FormServiceImpl implements FormService {
    private static final Logger logger = LoggerFactory.getLogger(FormRepositoryImpl.class);

    @Autowired
    //private FormRepository formRepo;

    //private Map<Long, Form> formMap;

    public FormServiceImpl() {

    }

    public void setFormRepo(FormRepository formRepo) {
        this.formRepo = formRepo;
    }

    @Override
    @Transactional
    public void addForm(Form f) {
        this.formRepo.addForm(f);
    }

    @Override
    @Transactional
    public void updateForm(Form f) {
        this.formRepo.updateForm(f);
    }



    public List<Form> listForms() {
        List<Form> someList = new ArrayList<>();
        someList.addAll(this.formRepo.listForms());
        return someList;
    }

    @Override
    @Transactional
    public Form getFormById(Long id) {
        return this.formRepo.getFormById(id);
    }

    @Override
    @Transactional
    public void removeForm(Long id) {
        this.formRepo.removeForm(id);
    }

}
*/
