package com.example.question.service;

import com.example.question.entity.Role;
import com.example.question.entity.User;
import com.example.question.form.Form;
import com.example.question.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class FormService {

    @Autowired
    FormRepository formRepository;

    @Transactional
    public boolean saveForm(Form form) {
        //Form f = formRepository.findByFormName(form.getName());
        //if (f != null) {
        //    return false;
        //}
        formRepository.save(form);
        return true;
    }
    @Transactional
    public boolean deleteUser(Long Id) {
        if (formRepository.findById(Id).isPresent()) {
            formRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    public Long getIdByName(String name){
         return formRepository.findByFormName(name).getId();
    }

}
