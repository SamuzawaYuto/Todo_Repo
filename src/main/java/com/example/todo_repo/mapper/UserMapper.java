package com.example.todo_repo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.example.todo_repo.entity.User;


@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE user_id = #{user_id}") 
    User selectUserByUserId(String userId);

    @Insert("INSERT INTO users (user_id, password, user_name) VALUES (#{user_id}, #{password}, 名無し)") 
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(com.example.todo_repo.entity.User user);
}
