package com.example.todo_repo.repository;

import com.example.todo_repo.entity.User;
import com.example.todo_repo.mapper.UserMapper;
import org.springframework.stereotype.Repository;
@Repository
public class UserRepository {
    private final UserMapper userMapper;
    public UserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public User getUserByUserId(String userId){
        return userMapper.selectUserByUserId(userId);
    }
    public void insertUser(User user){
        userMapper.insertUser(user);
    }
}