package com.example.todo_repo.service;
 import com.example.todo_repo.repository.TodoRepository;
 import com.example.todo_repo.entity.Todo;
 import org.springframework.stereotype.Service;
 import java.util.List;
 @Service
 public class TodoService {
   private final TodoRepository todoRepository;
   public TodoService(TodoRepository todoRepository) {
       this.todoRepository = todoRepository;
   }
   public List<Todo> getAllTodos() {
       return todoRepository.getAllTodos();
   }
 }