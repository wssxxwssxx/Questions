package com.example.question.form;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Entity
@Table(name = "t_question")
public class Question {



    @Id
    @GeneratedValue(generator = "optimized-sequence")
    @Column(name = "qid")
    private Long qid;

    @Size(min = 2, max = 50)
    @Column(name = "qname",
            nullable = false)
    @NotNull
    private String qname;



    @NotNull
    @Column(name= "form_id",insertable = true, updatable = true)
    private Long formID;

    public Question() {
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long q_id) {
        this.qid = q_id;
    }

    public String getName() {
        return qname;
    }

    public void setName(String name) {
        this.qname = name;
    }

    public Long getFormID() {
        return formID;
    }

    public void setFormID(Long formID) {
        this.formID = formID;
    }
}
