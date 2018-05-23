package com.sveticov.sveticovinterseptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterController {

    @GetMapping("/")
    public String mainPage(){
        return "main";
    }

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","Hello Danil");
        return "hello";
    }
}
