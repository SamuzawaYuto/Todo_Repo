package com.example.todo_repo.controller;

import com.example.todo_repo.entity.Todo;
import com.example.todo_repo.form.TodoForm;
import com.example.todo_repo.form.UserForm;
import com.example.todo_repo.security.CustomUserDetails;
import com.example.todo_repo.service.TodoService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
@RequestMapping("/home")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String todos(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todo/home";
    }

    @GetMapping("/new")
    public String todoForm(Model model) {
        TodoForm todoForm = new TodoForm();
        model.addAttribute("todoForm", todoForm);
        return "todo/taskRegistration";
    }

   @PostMapping("/new")
   public String createTodo(TodoForm todoForm, @AuthenticationPrincipal CustomUserDetails userDetails) {
       todoService.createTodo(todoForm, userDetails.getUsername());
       return "redirect:/home";
   }

   @GetMapping("/{todoId}")//task詳細に飛ぶ
   public String todo(@PathVariable long todoId, Model model) {  
        Todo todo = todoService.getTodoById(todoId);
        model.addAttribute("todo", todo);
        return "todo/taskDetail";
   }
   
    @GetMapping("/delete")
    public String Delete(Model model){
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todo/taskDelete";
    }

    @PostMapping("/{todoId}/delete")
    public String deleteTodo(@PathVariable long todoId) {
        todoService.deleteTodo(todoId);
        return "redirect:/home";
    }

    @GetMapping("/option")
public String Option(Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    TodoForm todoForm = new TodoForm();
    String userId = auth.getName();
    model.addAttribute("todoForm", todoForm);
    model.addAttribute("userId", userId);
    return "todo/option";
}


    
 }