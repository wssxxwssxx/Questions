package com.example.question.form;


import com.example.question.entity.User;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "t_form")
public class Form {

    @Id
    @GeneratedValue(generator = "optimized-sequence")
    @Column(name = "id")
    private Long id;

    @Size(min = 2)
    @NotNull
    @Column(name = "name",
            nullable = true)
    private String name;

    @NotNull
    @CreationTimestamp
    @Column(name = "data",
            nullable = true,
            columnDefinition = "bool default true")
    private Date data;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Form() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
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

    public Date getData() {
        return data;
    }

}
