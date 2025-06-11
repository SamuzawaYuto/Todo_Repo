package com.example.todo_repo.controller;

import com.example.todo_repo.entity.Todo;
import com.example.todo_repo.form.TodoForm;
import com.example.todo_repo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        TodoForm todoForm = new TodoForm();
        model.addAttribute("todoForm", todoForm);
        return "todo/todo-list";
    }

   @PostMapping("/new")
   public String createTodo(TodoForm todoForm) {
       todoService.createTodo(todoForm);
       return "redirect:/todo";
   }
/*
   @GetMapping("/{todoId}")
   public String todo(@PathVariable long taskId, Model model) {  
    Todo todo = todoService.getTodoById(taskId);
    
   }

    @PostMapping("/{todoId}/delete")
    public String deleteTodo(@PathVariable long taskId) {
        todoService.deleteTodo(taskId);
        return "redirect:/todo";
    }

    public String createTaskForm(@PathVariable long taskId, TaskForm taskForm) {
        
    }

    public String createTask(@PathVariable long taskId, TaskForm taskForm) {
    
    }

    public String deleteTask(@PathVariable long taskId) {
    
    }
*/
 }