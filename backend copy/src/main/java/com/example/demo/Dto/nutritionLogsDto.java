package com.example.demo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class nutritionLogsDto {
    

    @NotNull
    public int id;
    @NotNull
    public int userId;
    public Date logDate;
    public int calories;
    public int protein;
    public int carbs;
    public int fats;
}
