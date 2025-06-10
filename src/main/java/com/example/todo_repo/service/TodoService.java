package com.example.todo_repo.service;
 import com.example.todo_repo.repository.TodoRepository;
 import com.example.todo_repo.entity.Todo;
import com.example.todo_repo.form.TodoForm;

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
   public void createTodo(TodoForm todoForm) {
       Todo todo = new Todo();
       todo.setTitle(todoForm.getTitle());
       todo.setDate(todoForm.getDate());
       todo.setTime(todoForm.getTime());
       todo.setArea(todoForm.getArea());
       todo.setUrl(todoForm.getUrl());
       todoRepository.insertTodo(todo);
   }
   public Todo getTodoById(long todoId) {
    return todoRepository.getTodoId(todoId);
   }
   public void deleteTodo(long todoId) {
    todoRepository.deleteTodo(todoId);
   }
 }