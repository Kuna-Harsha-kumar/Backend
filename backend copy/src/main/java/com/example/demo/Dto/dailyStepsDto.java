package com.example.demo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Data
public class dailyStepsDto {
    

     @NotNull
    public int id;
    public int userId;
    public Date stepDate;
    public int stepCount;
}
