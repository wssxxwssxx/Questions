package com.example.question.form;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "t_question")
public class Question {

    @Id
    @NotBlank
    private Long id;

    @Size(min = 2,max = 50)
    @Column(name = "name_question",nullable = false)
    @NotBlank
    private String name;

    public Question() {
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
}
