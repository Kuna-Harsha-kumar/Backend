package com.example.demo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Data
@Getter
@Setter
public class achievements {
    

    @NotNull
    public int id;
    public int userId;
    public String achievementType;
    public String achievementValue;
    public Date achievementDate;
}
