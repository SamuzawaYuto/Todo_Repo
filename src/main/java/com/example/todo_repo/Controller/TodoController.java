package com.example.todo_repo.controller;
 import com.example.todo_repo.entity.Todo;
import com.example.todo_repo.form.TodoForm;
import com.example.todo_repo.service.TodoService;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
   @GetMapping("/new")
   public String todoForm(Model model) {
       TodoForm todoForm =  new TodoForm();
       return "todo/toddo-list";
   }
   @PostMapping("/new")
   public String createTodo(TodoForm todoForm) {
       todoService.createTodo(todoForm);
       return "redirect:/todos";
   }
   @GetMapping
   public String todo(@PathVariable long, Model model) {  //途中です
    
   }
 }