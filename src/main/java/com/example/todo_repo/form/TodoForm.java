package com.example.todo_repo.form;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data
public class TodoForm {
    private String title;
    private LocalDate date;
    private LocalTime time;
    private String area;
    private String url;
    private String memo;
    private String userId;
}
