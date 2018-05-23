package com.sveticov.sveticovinterseptor.controller;

import com.sveticov.sveticovinterseptor.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @GetMapping("/user")
    public String userSend(Model model){
        User user=new User();
        user.setId(1l);
        user.setName("Danil");
        user.setPassword("root");

        model.addAttribute("user",user);
        return "user";
    }
}
