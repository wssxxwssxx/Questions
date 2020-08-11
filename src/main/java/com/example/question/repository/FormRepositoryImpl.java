package com.example.question.repository;
/**
import com.example.question.form.Form;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Repository
public class FormRepositoryImpl implements FormRepository {



    private static final Logger logger = LoggerFactory.getLogger(FormRepositoryImpl.class);



    @Override
    public void addForm(Form f) {
        session.persist(f);
        logger.info("Form saved successfully, Form Details=" + f);
    }

    @Override
    public void updateForm(Form f) {

        session.update(f);
        logger.info("Form updated successfully, Form Details="+f);
    }


    @Override
    public List<Form> listForms() {

        List<Form> formsList = session.createQuery(" from Form").getResultList();
        for(Form f : formsList){
            logger.info("Form List::"+f);
        }
        return formsList;
    }

    @Override
    public Form getFormById(Long id) {

        Form f = (Form) session.load(Form.class, Long.valueOf(id));
        logger.info("Form loaded successfully, Form details=" + f);
        return f;
    }

    @Override
    public void removeForm(Long id) {

        Form f = (Form) session.load(Form.class, Long.valueOf(id));
        if(null != f){
            session.delete(f);
        }
        logger.info("Form deleted successfully, Form details="+f);
    }

}
 */