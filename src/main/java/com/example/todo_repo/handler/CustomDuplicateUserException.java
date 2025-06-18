package com.example.todo_repo.handler;

public class CustomDuplicateUserException extends RuntimeException{
    public CustomDuplicateUserException(String message) {
        super(message);
    }
}
