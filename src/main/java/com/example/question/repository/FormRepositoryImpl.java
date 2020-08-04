package com.example.question.repository;

import com.example.question.form.Form;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FormRepositoryImpl implements FormRepository {

    private static final Logger logger = LoggerFactory.getLogger(FormRepositoryImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addForm(Form f) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(f);
        logger.info("Form saved successfully, Form Details=" + f);
    }

    @Override
    public void updateForm(Form f) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(f);
        logger.info("Form updated successfully, Form Details="+f);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Form> listForms() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Form> formsList = session.createQuery("from Form").list();
        for(Form f : formsList){
            logger.info("Form List::"+f);
        }
        return formsList;
    }

    @Override
    public Form getFormById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Form f = (Form) session.load(Form.class, Long.valueOf(id));
        logger.info("Form loaded successfully, Form details=" + f);
        return f;
    }

    @Override
    public void removeForm(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Form f = (Form) session.load(Form.class, Long.valueOf(id));
        if(null != f){
            session.delete(f);
        }
        logger.info("Form deleted successfully, Form details="+f);
    }

}