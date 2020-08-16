package com.example.question.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.persistence.*;


@Entity
@Table(name = "t_answer")
public class Answer {

    @Id
    @GeneratedValue(generator = "optimized-sequence")
    @Column(name = "a_id")
    private Long a_id;

    @Size(min = 2, max = 50)
    @Column(name = "aname",
            nullable = false)
    private String aname;

    @Column(name = "properly",
            nullable = false)
    private boolean properly = false;



    @NotBlank
    @Column(name= "question_id")
    private Long q_id;

    public Answer() {
    }

    public Long getId() {
        return a_id;
    }

    public void setId(Long id) {
        this.a_id = id;
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

    public Long getQ_id() {
        return q_id;
    }

    public void setQ_id(Long q_id) {
        this.q_id = q_id;
    }
}
