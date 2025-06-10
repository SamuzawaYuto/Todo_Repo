package com.example.todo_repo.entity;
 import lombok.Data;
 import java.time.LocalDateTime;
 @Data
 public class User {
    private long userId;
    private String name;
    private String password;
    private LocalDateTime createdAt;
 }