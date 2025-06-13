package com.example.todo_repo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.example.todo_repo.entity.User;


@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE userId = #{userId}") 
    User selectUserByUserId(String userId);

    @Insert("INSERT INTO users (userId, password, userName) VALUES (#{userId}, #{password}, 名無し)") 
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(com.example.todo_repo.entity.User user);
}
