package com.example.todo_repo.entity;
 import lombok.Data;
 import org.springframework.format.annotation.DateTimeFormat;
 import java.time.LocalDate;
 import java.time.LocalDateTime;
import java.time.LocalTime;

 @Data
 public class Todo {
   private long todoId;
   private String title;
   private int frag;
   private long taskId;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDate date;
   @DateTimeFormat(pattern = "HH:mm")
   private LocalTime time;
   private String area;
   private String url;
   private String memo;
 }