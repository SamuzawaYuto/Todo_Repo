package com.example.todo_repo.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/Todo")
public class TodoController {
    
    @GetMapping
    public String TodoList() {
        return "index";
    }
}