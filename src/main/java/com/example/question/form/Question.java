package com.example.question.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "t_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "q_id", nullable = false, insertable = true, updatable = true)
    private Long qid;

    @Size(min = 2, max = 50)
    @Column(name = "qname",
            nullable = false)
    @NotBlank
    private String qname;



    @NotBlank
    @Column(name= "form_id",insertable = true, updatable = true)
    private Long formID;

    public Question() {
    }

    public Long getId() {
        return qid;
    }

    public void setId(Long id) {
        this.qid = id;
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
