package com.example.todo_repo.mapper;
import com.example.todo_repo.entity.Todo;
import com.example.todo_repo.entity.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
 import java.util.List;
 @Mapper
 public interface TodoMapper {
   @Select("SELECT * FROM todos LEFT JOIN users ON todos.userId = users.userId WHERE todos.userId = users.userId")
   List<Todo> selectAllTodos();

   @Insert("INSERT INTO todos (title, date, time, area, url, memo, userId) VALUES (#{title}, #{date}, #{time}, #{area}, #{url}, #{memo}, #{userId})")
   @Options(useGeneratedKeys = true, keyProperty = "todoId")
   void insertTodo(Todo todo);

  //  @Select("SELECT userId FROM users WHERE userId = #{userId1}")
  //  String getId(String userId1);

   @Select("SELECT * FROM todos WHERE todo_id = #{todoId}")
   Todo selectTodoById(long todoId);

   @Delete("DELETE FROM todos WHERE todo_id = #{todoId}")
    void deleteTodoById(long todoId);
  
 }