package com.example.question.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_answer")
public class Answer {

    @Id
    @NotBlank
    private Long id;

    @Size(min = 2,max = 50)
    @Column(name = "name_answer",
            nullable = false)
    @NotBlank
    private String name;

    @Column(name = "properly_answer",
            nullable = false,
            columnDefinition = "timestamp default now()")
    private boolean properly = false;

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isProperly() {
        return properly;
    }

    public void setProperly(boolean properly) {
        this.properly = properly;
    }
}
