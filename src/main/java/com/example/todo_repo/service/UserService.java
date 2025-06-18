package com.example.todo_repo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.todo_repo.entity.User;
import com.example.todo_repo.form.UserForm;
import com.example.todo_repo.handler.CustomDuplicateUserException;
import com.example.todo_repo.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserForm userForm){
        
        User user = new User();
        user.setUserId(userForm.getUserId());
        String hashedPassword = passwordEncoder.encode(userForm.getPassword());
        user.setPassword(hashedPassword);
        user.setUserName("名無し");
        userRepository.insertUser(user);
    }
   
}
