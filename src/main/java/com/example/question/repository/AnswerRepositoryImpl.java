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

    private Long answerID;

    public void setAnswerId(Long answerID){
        this.answerID = answerID;
    }

    public Long getAnswerID() {
        return answerID;
    }

    @Override
    public void addAnswer(Answer answer, Long id) {
        setAnswerId(id); // передаем ссылку на ид_вопроса в новый ответ
        Session session = this.sessionFactory.getCurrentSession();

        // надо создать для наглядности список локальных переменных,
        // которые будут использованы в запросе

        session.createSQLQuery("INSERT INTO t_answer (question_answer_id, name_answer, properly_answer) VALUES ("
                + getAnswerID() +", " + answer.getName()+", "+answer.isProperly() +");");
        //session.persist(answer); //свой запрос
        logger.info("Answer saved successfully, answer Details=" + answer);
    }

    @Override
    public void updateAnswer(Answer answer, Long id) {
        setAnswerId(id); //пока не понятно как передать questionId
        Session session = this.sessionFactory.getCurrentSession();
        session.update(answer); // свой запрос
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
