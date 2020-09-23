package com.example.question.results;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "t_tempresult")
public class TempResult {


    @Id
    @GeneratedValue(generator = "optimized-sequence")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "answerId")
    private Long answerId ;

    @NotNull
    @Column(name = "userAnswer")
    private Boolean userAnswer;

    public TempResult(){

    }

    // Getters and setters
    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Boolean getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(Boolean userAnswer) {
        this.userAnswer = userAnswer;
    }
}