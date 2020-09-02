package com.example.question.controller;

import com.example.question.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
//@RequestMapping("/")
public class MainController {
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    public String getName() {
        return Name;
    }

    public void setName(String aName) {
        this.Name = aName;
    }

    private String Name;

    @GetMapping("/main")
    public String main(Model model, @AuthenticationPrincipal User user) {
//        HashMap<Object, Object> data = new HashMap<>();
//        data.put("profile",user);
//
//        model.addAttribute("frontendData",data);

        Authentication authentication = authenticationFacade.getAuthentication();
        setName(authentication.getName());
        model.addAttribute("guestname", this.getName());
        return "main";
   }

}

