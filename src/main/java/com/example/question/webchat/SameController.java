//package com.example.question.webchat;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class SameController {
//
//    @RequestMapping("/ch_chat")
//    public String index(HttpServletRequest request, Model model) {
//        String username = (String) request.getSession().getAttribute("username");
//
//        if (username == null || username.isEmpty()) {
//            return "redirect:/ch_login";
//        }
//        model.addAttribute("username", username);
//
//        return "ch_chat";
//    }
//
//    @RequestMapping(path = "/ch_login", method = RequestMethod.GET)
//    public String showLoginPage() {
//        return "ch_login";
//    }
//
//    @RequestMapping(path = "/ch_login", method = RequestMethod.POST)
//    public String doLogin(HttpServletRequest request, @RequestParam(defaultValue = "") String username) {
//        username = username.trim();
//
//        if (username.isEmpty()) {
//            return "ch_login";
//        }
//        request.getSession().setAttribute("username", username);
//
//        return "redirect:/ch_chat";
//    }
//
//    @RequestMapping(path = "/logout")
//    public String logout(HttpServletRequest request) {
//        request.getSession(true).invalidate();
//
//        return "redirect:/ch_login";
//    }
//
//}
