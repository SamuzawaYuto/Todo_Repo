package com.example.todo_repo.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.todo_repo.controller.RegistrationController;
import com.example.todo_repo.entity.User;
import com.example.todo_repo.form.UserForm;
import com.example.todo_repo.handler.CustomDuplicateUserException;
import com.example.todo_repo.repository.UserRepository;

import jakarta.servlet.RequestDispatcher;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final String DB_URL = "jdbc:h2:file:./sampledb";
    private static final String USER = "sa";
    private static final String PASS = "";

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserForm userForm){
        String sql = "INSERT INTO users (userId, password, userName) VALUES (?, ?, ?)";

        User user = new User();
        user.setUserId(userForm.getUserId());
        String hashedPassword = passwordEncoder.encode(userForm.getPassword());
        user.setPassword(hashedPassword);
        user.setUserName("名無し");
         try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, "名無し");
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // ユニーク制約違反のエラーコードをチェック
            if ("23505".equals(e.getSQLState())) {
                throw new CustomDuplicateUserException("このユーザーIDは既に存在します。");
            } else {
                e.printStackTrace();
            }
        }
        // userRepository.insertUser(user);
    }
   
}
