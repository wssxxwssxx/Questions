package com.example.question.controller;


import com.example.question.form.Answer;
import com.example.question.form.Question;
import com.example.question.results.TempResult;
import com.example.question.service.AnswerService;
import com.example.question.service.FormService;
import com.example.question.service.QuestionService;
import com.example.question.service.TempResultService;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
    public class AnswerController {
    private AnswerService answerService;                    //Служба ответа
    private QuestionService questionService;                //Служба вопроса
    private FormService formService;                        //Служба Темы
    private TempResultService TRS;


    private String topicName;
    public Long tId;                                        //ИД_ТЕМЫ
    public Long qId;                                        //ИД_ВОПРОСА
    //public int counter;                                     //указатель на текущий вопрос
    //public int allQuestion;                                 //общее количество вопросов в теме
    public List<Boolean> userAnswer;                        //список ответов пользователя???


    public Page<Question> questionList;                     //список вопросов отображаемых постранично, по 1 вопросу на странице
   // public List<answerStructure> answerList;                         //список ответов, по шесть ответов на 1 вопрос


    public List<Question> qList= new ArrayList<>();         //Список вопросов???

    Answers2 answers2 = new Answers2();  //тут создается объект хранения!!!

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService){
        this.questionService = questionService;
    }

    @Autowired
    public void setFormService(FormService formService) {
        this.formService = formService;
    }

    @Autowired
    public void setTRS(TempResultService TRS) {
        this.TRS = TRS;
    }


    @GetMapping(value = "/answers/{pageNo}")
    public String addAnswer(@PathVariable (value = "pageNo") int pageNo,
                            Model model,
                            @PageableDefault(sort = {"qid"},
                                            direction = Sort.Direction.ASC) Pageable pageable){


        int pageSize = 1; //показ постранично(повопросно!)

        //-----------------ТУТ ИСПРАВИТЬ НА ДИНАМИКУ--------------------------------
        setTopicName("Преступление и наказание");
        this.tId = 3000L;//formService.getIdByName(name);
        //-------------------------------------------------------------------------

        loadFromDb(this.tId, pageable, pageNo, pageSize);                          //выгрузка из базы

        //                  собираем модель, т.е передаем во вьюшку наши переменные:
        model.addAttribute("qList", this.qList);                                //список вопросов получаем из контента страницы
        model.addAttribute("topicName", this.topicName);                        //название темы
        model.addAttribute("questionList", this.questionList);                  //Страница с текущим вопросом
        model.addAttribute("counter", pageNo);                                  //номер страницы(он же номер вопроса -1)
        model.addAttribute("allQuestion", questionList.getTotalElements());     //общее количество вопросов
        model.addAttribute("uAnswers", answers2);                               //список гребаных ответов

        return "answers";
    }

    public void loadFromDb(Long qid, Pageable pageable, int pageNumber, int pageSize) {


        questionList = questionService.getQuestionsByFormId(this.tId, pageable, pageNumber, pageSize);
        qList = questionList.getContent();
        this.qId = qList.get(0).getQid();

        int qq = answerService.getAnswersByQuestionId(qId).size(); // количество ответов в вопросе!
        //----Начало цикла (перебираем ответы в вопросе) -----------
        for (int j = 0; j < qq; j++) {
           // заполняем новый (сущность)ответ значениями полей из базы
           Answer answer = new Answer();                                                         //объявили сущность
           answer.setId(answerService.getAnswersByQuestionId(qId).get(j).getId());               //передали ИД
           answer.setName(answerService.getAnswersByQuestionId(qId).get(j).getName());           //передали название
           answer.setProperly(answerService.getAnswersByQuestionId(qId).get(j).getProperly());   //передали признак правильного ответа
           answer.setUserAnswer(answerService.getAnswersByQuestionId(qId).get(j).isUserAnswer());//передали ответ пользователя
           // сохраняем сущность в список
           answers2.addAnswer(answer);
        //------------------------- конец цикла ---------------------
        }
    }

    public void saveToDb(Answers2 answers, Long questionId) {
        System.out.println("--------------------------------СОХРАНЕНИЕ ОТВЕТОВ В БАЗУ-------------------------------------------");
        for (Answer answer: answers.getAnswers()) {
            System.out.println(answer.getId() + " | " + answer.getName() + " | " + answer.getProperly() + " | " + answer.isUserAnswer());
            answerService.saveAnswer(answer, questionId);
        }

    }



    @PostMapping(value = "/answers/*")
    public String saveResults(@ModelAttribute("uAnswers") Answers2 answers){

        saveToDb(answers,qId);
        return "/results";
    }


    //--------------------------------------------------------------
    // класс оболочка - список ответов пользователя
   public class Answers2 {
        private List<Answer> user_answers ;           // здесь создаем список ответов

        @Autowired
        public Answers2() {
            this.user_answers = new ArrayList<>();
        }


        public void addAnswer(Answer answer){
            System.out.println(answer.getId() + " "+answer.getName() + " "+answer.getProperly());
            this.user_answers.add(answer);            // в список добавляем ответ
        }

        public List<Answer> getAnswers() {
            return user_answers;
        }

        public void setAnswers(List<Answer> answers) {
            this.user_answers = answers;
        }
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
