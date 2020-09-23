package com.example.question.form;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "t_answer")
public class Answer {

    @Id
    @GeneratedValue(generator = "optimized-sequence")
    @Column(name = "a_id")
    private Long aId;

    @Size(min = 2, max = 50)
    @Column(name = "aname",
            nullable = false)
    private String aname;

    @Column(name = "properly",
            nullable = false)
    private boolean properly = false;

    @NotNull
    @Column(name= "question_id")
    private Long questionId;

    @Column(name = "user_answer",
            nullable = false)
    private boolean userAnswer = false;

    public Answer() {
    }

    public Long getId() {
        return aId;
    }

    public void setId(Long id) {
        this.aId = id;
    }

    public String getName() {
        return aname;
    }

    public void setName(String name) {
        this.aname = name;
    }

    public boolean getProperly() {
        return properly;
    }

    public void setProperly(boolean properly) {
        this.properly = properly;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public boolean isUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }
}
