package com.example.demo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class userActivityLevelsDto {
    
    @NotNull
    public int id;
    @NotNull
    public int userId;
    public int activityLevelId;
    public Date startDate;
    public Date endDate;
}
