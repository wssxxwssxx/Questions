package com.example.question.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "t_form")
public class Form {

    @Id
    @NotBlank
    private Long id;

    @Size(min = 2)
    @NotBlank
    @Column(name = "topic_name",
            nullable = false)
    private String name;

    @NotNull
    @Column(name = "data",
            nullable = false,
            columnDefinition = "bool default true")
    private Date data;

    public Form() {
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
