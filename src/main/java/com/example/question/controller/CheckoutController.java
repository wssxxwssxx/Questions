package com.example.question.controller;
/**

import com.example.question.commands.CheckoutCommand;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CheckoutController {

    @RequestMapping("checkout")
    public String checkotForm(){
        return "checkoutform";
    }

    @RequestMapping(value = "/docheckout", method = RequestMethod.POST)
    public String doCheckout(@Valid CheckoutCommand checkoutCommand, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "checkoutform";
        }
        return "checkoutComplete";
    }
}
*/