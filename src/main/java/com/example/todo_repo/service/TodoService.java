package com.example.todo_repo.service;

import com.example.todo_repo.repository.TodoRepository;
import com.example.todo_repo.entity.Todo;
import com.example.todo_repo.entity.User;
import com.example.todo_repo.form.TodoForm;
import com.example.todo_repo.form.UserForm;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(String userId) {
        return todoRepository.getAllTodos(userId);
    }

    public void createTodo(TodoForm todoForm, String userId) {
        Todo todo = new Todo();
        todo.setTitle(todoForm.getTitle());
        todo.setDate(todoForm.getDate());
        todo.setTime(todoForm.getTime());
        todo.setArea(todoForm.getArea());
        todo.setUrl(todoForm.getUrl());
        todo.setMemo(todoForm.getMemo());
        todo.setUserId(userId);
        todoRepository.insertTodo(todo);
    }

    // public String getId(UserForm userForm){
    //     String userId1 = userForm.getUserId();
    //     return userId1;
    // }

    public Todo getTodoById(long todoId) {
        return todoRepository.getTodoId(todoId);
    }

    public void deleteTodo(long todoId) {
        todoRepository.deleteTodo(todoId);
    }

    public void deleteTodoById(Long todoId) {
        todoRepository.deleteTodo(todoId);
    }

    public void updateTodo(long todoId, Todo todo) {
        if(todoId != todo.getTodoId()) {
            throw new IllegalArgumentException("todoId dosen't match");
        }
        todoRepository.updateTodo(todo);
    }

}