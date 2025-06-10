package com.example.todo_repo.mapper;
 import com.example.todo_repo.entity.Todo;
 import org.apache.ibatis.annotations.Mapper;
 import org.apache.ibatis.annotations.Select;
 import java.util.List;
 @Mapper
 public interface TodoMapper {
   @Select("SELECT * FROM todos")
   List<Todo> selectAllTodos();
 }