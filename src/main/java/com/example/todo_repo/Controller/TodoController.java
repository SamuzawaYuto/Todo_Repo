package com.example.todo_repo.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;


@Controller
@RequestMapping("/Todo")
public class TodoController {
    
    @GetMapping
    public String TodoList() {
        return "index";
    }
}