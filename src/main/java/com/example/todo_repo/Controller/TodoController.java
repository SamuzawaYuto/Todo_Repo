package com.example.todo_repo.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TodoController {

    @GetMapping({"/", "/add", "/detail"})
    public String serveIndex() {
        return "forward:/index.html";
    }
}