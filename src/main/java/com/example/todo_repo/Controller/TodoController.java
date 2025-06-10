package com.example.todo_repo.controller;
 import com.example.todo_repo.entity.Todo;
 import com.example.todo_repo.service.TodoService;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import java.util.List;

 @Controller
 @RequestMapping("/todos")
 public class TodoController {
    private final TodoService todoService;
    public TodoController(TodoService todoService) {
       this.todoService = todoService;
   }
    @GetMapping
   public String todos(Model model) {
       List<Todo> todos = todoService.getAllTodos();
       model.addAttribute("todos", todos);
       return "todo/todo-list";
   }
 }