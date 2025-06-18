package com.example.todo_repo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo_repo.entity.User;
import com.example.todo_repo.form.UserForm;
import com.example.todo_repo.handler.CustomDuplicateUserException;
import com.example.todo_repo.service.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private final UserService userService;

    public RegistrationController(UserService userService){
        this.userService = userService;
    }



    @GetMapping("/user")
    public String showRegistrationForm(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "user/userRegistration";
    }

    @PostMapping("/user")
    public String registerUser(@ModelAttribute UserForm userForm, Model model){
        try{
            userService.createUser(userForm);
            return "redirect:/login";
        } catch (CustomDuplicateUserException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "user/userRegistration?error";
        }
        
    }

}
