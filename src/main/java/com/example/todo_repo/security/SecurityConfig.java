package com.example.todo_repo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.security.Security;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/user", "/login", "/style.css", "/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()// h2-consoleでログイン無効
                        .anyRequest().authenticated())
                // Spring 4 以降はデフォルトでCSRFが有効だが、明示的に有効にする。
                .csrf(csrf -> csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository())
                        // h2-consoleでCSRFを無効にする
                        .ignoringRequestMatchers("/h2-console/**"))
                // h2-consoleの設定
                .securityMatcher("/h2-console/**")
                .headers(headers -> headers.frameOptions(
                        frame -> frame.sameOrigin()))
                // 全体への設定
                .securityMatcher("/**")
                .formLogin(login -> login
                        .loginProcessingUrl("/login")
                        .loginPage("/login")
                        .defaultSuccessUrl("/home")
                        .failureUrl("/login?error")
                        .permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
