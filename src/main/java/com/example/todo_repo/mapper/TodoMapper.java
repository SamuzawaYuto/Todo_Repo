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
   @Select("SELECT * FROM todo")
   List<Todo> selectAllTodos();

   @Insert("INSERT INTO todo (title, date, time, area, url) VALUES (#{title}, #{date}, #{time}, #{area}, #{url})")
   @Options(useGeneratedKeys = true, keyProperty = "todoId")
   void insertTodo(Todo todo);
/*
   @Select("SELECT * FROM todo WHERE task_id = #{taskId}")
   Todo selectTodoId(long taskId);

   @Delete("DELETE FROM todo WHERE task_id = #{taskId}")
   void deleteTodoById(long taskId);
   */
 }