package com.example.question.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "t_answer")
public class Answer {

    @Id
    @Column(name = "a_id")
    private Long a_id;

    @Size(min = 2,max = 50)
    @Column(name = "aname",
            nullable = false)
    @NotBlank
    private String aname;

    @Column(name = "properly_answer",
            nullable = false,
            columnDefinition = "timestamp default now()")
    private boolean properly = false;

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

    public boolean isProperly() {
        return properly;
    }

    public void setProperly(boolean properly) {
        this.properly = properly;
    }
}
