package com.example.question.repository;

import com.example.question.form.Answer;
import com.example.question.form.Form;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository{

    private static final Logger logger = LoggerFactory.getLogger(FormRepositoryImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public long qId;

    @Override
    public Long setQId(){
        return this.qId;
    }

    @Override
    public void addAnswer(Answer answer, Long questionId) {
        this.qId = questionId; //пока не понятно как передать questionId
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(answer);
        logger.info("Answer saved successfully, answer Details=" + answer);
    }

    @Override
    public void updateAnswer(Answer answer, Long questionId) {
        this.qId = questionId; //пока не понятно как передать questionId
        Session session = this.sessionFactory.getCurrentSession();
        session.update(answer); // дописать запрос
        logger.info("Answer update successfully, answer Details=" + answer);
    }

    @Override
    public List<Answer> listAnswer(Long questionId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Answer> answerList = session.createQuery("from Answer").list();
        for(Answer a : answerList){
            logger.info("Answer List::"+ a);
        }
        return answerList;
    }

    @Override
    public Answer getAnswerById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Answer answer = (Answer) session.load(Answer.class, Long.valueOf(id));
        logger.info("Answer loaded successfully, Answer details=" + answer);
        return answer;
    }

    @Override
    public void removeAnswer(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Answer answer = (Answer) session.load(Answer.class, Long.valueOf(id));
        if(null != answer){
            session.delete(answer);
        }
        logger.info("Answer deleted successfully, Answer details="+answer);
    }

    @Override
    public void setRightAnswer(Long id) {
        // дописать запрос
    }
}
