package com.example.question.controller;

import com.example.question.form.Form;
import com.example.question.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {

    private FormService formService;

    @Autowired(required=true)
    //@Qualifier(value="formService")
    public void setFormService(FormService fs){
        this.formService = fs;
    }

    @RequestMapping(value = "/forms", method = RequestMethod.GET)
    public String listForms(Model model) {
        model.addAttribute("form", new Form());
        model.addAttribute("listForms", this.formService.listForms());
        return "form";
    }

    //For add and update form both
    @RequestMapping(value= "/form/add", method = RequestMethod.POST)
    public String addForm(@ModelAttribute("form") Form f){

        if(f.getId() == 0){
            //new form, add it
            this.formService.addForm(f);
        }else{
            //existing form, call update
            this.formService.updateForm(f);
        }

        return "redirect:/forms";

    }

    @RequestMapping("/remove/{id}")
    public String removeForm(@PathVariable("id") Long id){

        this.formService.removeForm(id);
        return "redirect:/forms";
    }

    @RequestMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("form", this.formService.getFormById(id));
        model.addAttribute("listForms", this.formService.listForms());
        return "form";
    }

}