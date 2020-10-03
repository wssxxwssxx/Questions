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


    private String topicName;                               //Название темы
    public Long tId;                                        //ИД_ТЕМЫ
    public Long qId;                                        //ИД_ВОПРОСА
    int allAnswerCount =0;
    //List <Boolean> correct;
    boolean[] correct =null;
    //Answers2 answers;
    public List<Question> questionList;        //Список вопросов???

    public Questions questions;

    public Map<Question, List<Answer>> questionListMap;
    public Map<Question, List<Answer>> answerListMap;

    //Answers2 answers2 = new Answers2();  //тут создается объект хранения!!!

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


    @GetMapping(value = "/answers")
    public String addAnswer(Model model){
        //correct = new boolean[100];

        questionListMap = new HashMap<>();
        answerListMap = new HashMap<>();



        //-----------------ТУТ ИСПРАВИТЬ НА ДИНАМИКУ--------------------------------
        setTopicName("Преступление и наказание");
        this.tId = 3000L;//formService.getIdByName(name);
        //-------------------------------------------------------------------------

        //loadFromDb(this.tId, this.questionList);                          //выгрузка из базы
        load(this.tId);

        model.addAttribute("topicName", this.topicName);                        //название темы
       // model.addAttribute("questionList", this.questionList);                  //Страница с текущим вопросом
        model.addAttribute("allItems", this.questionListMap);
       // model.addAttribute("questionsMap", this.questionListMap); //список вопросов
        model.addAttribute("answerListMap", this.answerListMap);





        return "answers";
    }


    public void load(Long tid){
        for (Question q : questionService.getQuestionsByFormId(tid)){
            List<Answer> TAnswers = new ArrayList<>();
            List<Answer> n = new ArrayList<>();
            n.add(new Answer());
            this.answerListMap.put(new Question(), n);//создаем список ответов на один вопрос
            TAnswers.addAll(answerService.getAnswersByQuestionId(q.getQid()));     //заполняем его
            this.questionListMap.put(q, TAnswers);
        }
    }













//    public void load(Long tid){
//        long questionsQuantity = questionService.getQuestionsByFormId(tid).size();
//
//        for (Question q:questionService.getQuestionsByFormId(tid)) {
//            List<Answer> TAnswers = new ArrayList<>();                             //создаем список ответов на один вопрос
//            TAnswers.addAll(answerService.getAnswersByQuestionId(q.getQid()));     //заполняем его
//            questions.setQuestion(q, TAnswers);                                    //передаем пару(ключ=вопрос, значение=список ответов)
//        }
//
//    }





//    public void loadFromDb(Long tid, List<Question> currentQuestionList) {
//
//        //Сначала отправим ид_темы - получим список вопросов этой темы
//        //this.questionList.addAll(questionService.getQuestionsByFormId(tid));
//
//
//        answerService.getAnswersByQuestionId(qId).size(); // количество ответов в вопросе!
//        //----Начало цикла (перебираем ответы в вопросе) -----------
//        for (Question que : questionList) {
//            //получим текущий ИД_ВОПРОСА
//            this.qId = que.getQid();
//
//            //т.к. кол-во вариантов ответов подразумевается
//            // разное, поэтому получаем новый размер списка ответов
//            int queSize = answerService.getAnswersByQuestionId(this.qId).size();
//
//
//            // теперь переберем текущий список вариантов ответов
//            for (int j = 0; j < queSize; j++) {
//                // заполняем новый вариант ответа значениями полей из базы
//                Answer answer = new Answer();                                                         //объявили сущность
//                answer.setId(answerService.getAnswersByQuestionId(qId).get(j).getId());               //передали ИД
//                answer.setName(answerService.getAnswersByQuestionId(qId).get(j).getName());           //передали название
//                answer.setProperly(answerService.getAnswersByQuestionId(qId).get(j).getProperly());   //передали признак правильного ответа
//                answer.setUserAnswer(answerService.getAnswersByQuestionId(qId).get(j).isUserAnswer());//передали ответ пользователя
//
//                allAnswerCount++;
//                // сохраняем сущность в список
//                answers2.addAnswer(answer);
//                //------------------------- конец цикла ---------------------
//            }
//        }
//        correct = new boolean[allAnswerCount];
//    }

    public void saveToDb(Map<Question, List<Answer>> answers) {

        System.out.println("--------------------------------СОХРАНЕНИЕ ОТВЕТОВ В БАЗУ-------------------------------------------");
        for(Question q : answers.keySet()) {
            for (Answer answer : answers.get(q)) {
                System.out.println(answer.getId() + " | " + answer.getName() + " | " + answer.getProperly() + " | " + answer.isUserAnswer());
                answerService.saveAnswer(answer, q.getQid());
            }
        }
    }

    public void save(long id){
        for(Question q : this.questionListMap.keySet()) {
            for (Answer answer : this.questionListMap.get(q)) {
                if (answer.getId()==id)
                    answer.setUserAnswer(true);
                answerService.saveAnswer(answer, q.getQid());
            }
        }
    }


    @PostMapping(value = "/answers")
    public String saveResults() {

    // for (int i = 0; i < correct.length ; i++) {
       //     System.out.println(correct[i]);
       // }
       //
       saveToDb(this.answerListMap);

        //List<Boolean> checkedItems = foo.getCheckedItems();
        //for (Question q : foo.keySet()) {
         //   for (Answer a : questionListMap.get(q)) {
          //      a.setUserAnswer(checkedItems.get(k));

          //  }
      //  }

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







    public class Foo {
        private List<Boolean> checkedItems;

        public List<Boolean> getCheckedItems() {
            return checkedItems;
        }

        public void setCheckedItems(List<Boolean> checkedItems) {
            this.checkedItems = checkedItems;
        }
    }










    // класс оболочка - карта вопросов и ответов пользователя
    public class Questions {
        private Map<Question, List<Answer>> questions ;           // здесь создаем список ответов


        @Autowired
        public Questions() {
            this.questions = new HashMap<>();

        }



        public void addQuestion(Question question, List<Answer> answers){

            System.out.println("Создан вопрос: id = " + question.getQid() + " | название: "+ question.getName() + " ; ");
            this.questions.put(question, answers);            // в список добавляем ответ
        }

        public Map<Question,List<Answer>> getAll(){
            return this.questions;
        }

        public List<Question> getListOfQuestionNames() {
            return (List<Question>) this.questions.keySet();
        }

        public  List<Answer> getListOfQuestionAnswersByQuestion(Question key){
            return this.questions.get(key);
        }

        public void setQuestion(Question key, List<Answer> value){
            this.questions.put(key, value);
        }
    }


}
