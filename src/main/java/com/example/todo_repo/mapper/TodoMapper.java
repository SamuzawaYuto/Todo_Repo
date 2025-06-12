package com.example.todo_repo.mapper;
 import com.example.todo_repo.entity.Todo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
 import java.util.List;
 @Mapper
 public interface TodoMapper {
   @Select("SELECT * FROM todos")
   List<Todo> selectAllTodos();

   @Insert("INSERT INTO todos (title, date, time, area, url, memo) VALUES (#{title}, #{date}, #{time}, #{area}, #{url}, #{memo})")
   @Options(useGeneratedKeys = true, keyProperty = "todoId")
   void insertTodo(Todo todo);

   @Select("SELECT * FROM todos WHERE todo_id = #{todoId}")
   Todo selectTodoById(long todoId);

   @Delete("DELETE FROM todo WHERE task_id = #{taskId}")
   void deleteTodoById(long taskId);
  
 }