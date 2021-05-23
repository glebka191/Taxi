package com.tsk.controllers;

import com.tsk.entity.User;
import com.tsk.repo.UserRepo;
import com.tsk.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    private final UserRepo userRepo;
    private final UserService userService;

    public RegistrationController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        if (!userService.addUser(user)) {
            model.put("message", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}