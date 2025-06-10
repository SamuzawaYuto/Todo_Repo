package com.example.todo_repo.entity;
 import lombok.Data;
 
 @Data
 public class User {
    private long id;
    private String userId;
    private String password;
    private String userName;
 }