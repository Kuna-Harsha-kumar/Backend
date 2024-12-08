package com.example.demo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Data
@Getter
@Setter
public class goalsDto {
    
     @NotNull
    public int id;

    @NotNull
    public int userId;

    public String goalType;
    public int targetValue;
    public int currentValue;
    public Timestamp createdAt;
    public Timestamp dueDate;
}
