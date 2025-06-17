package com.example.todo_repo.repository;
 import com.example.todo_repo.mapper.TodoMapper;
 import com.example.todo_repo.entity.Todo;
import com.example.todo_repo.entity.User;

import org.springframework.stereotype.Repository;
 import java.util.List;
 @Repository
 public class TodoRepository {
   private final TodoMapper todoMapper;
   public TodoRepository(TodoMapper todoMapper) {
       this.todoMapper = todoMapper;
   }
   public List<Todo> getAllTodos() {
       return todoMapper.selectAllTodos();
   }
   public void insertTodo(Todo todo) {
       todoMapper.insertTodo(todo);
   }

//    public String getId(String userId1){
//        return todoMapper.getId(userId1);
//    }   
   
   public Todo getTodoId(long todoId) {
       return todoMapper.selectTodoById(todoId);
   }
   
   public void deleteTodo(long todoId) {
        todoMapper.deleteTodoById(todoId);
    }
   
 }