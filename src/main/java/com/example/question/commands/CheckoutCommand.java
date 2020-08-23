package com.example.question.commands;

import com.example.question.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CheckoutCommand  extends  User{

    @NotNull
    @Size(min = 2, max=63)
    private String username;

    @NotNull
    @Size(min = 8, max = 127)
    private String password;



    @NotNull
    @Size(min = 8, max = 127)
    private String confirm;

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getLogin() {
        return username;
    }

    public void setLogin(String login) {
        this.username = login;
    }

    public String getPass() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
