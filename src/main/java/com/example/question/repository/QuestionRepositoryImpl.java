package com.example.question.repository;

import com.example.question.form.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionRepositoryImpl implements QuestionRepository {
    private Long formID;


    public void setFormID(Long formID) {
        this.formID = formID;
    }




    private static final Logger logger = LoggerFactory.getLogger(QuestionRepositoryImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }



    @Override
    public void addQuestion(Question question, Long id) {
        setFormID(id); //установим ссылку на ид_формы
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(question);
        logger.info("Question saved successfully, Question Details=" + question);
    }

    @Override
    public void updateQuestion(Question question, Long id) {
        setFormID(id); //установим ссылку на ид_формы
        Session session = this.sessionFactory.getCurrentSession();
        session.update(question);
        logger.info("Question update successfully, Question Details=" + question);
    }

    @Override
    public Question getQuestionById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Question question = (Question) session.load(Question.class, Long.valueOf(id));
        return question;
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Question question = (Question) session.load(Question.class, Long.valueOf(id));
        if(null != question){
            session.delete(question);
        }
        logger.info("Question deleted successfully, Question details= "+ question);
    }
}
