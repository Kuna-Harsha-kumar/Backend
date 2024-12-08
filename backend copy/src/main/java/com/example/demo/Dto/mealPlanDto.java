package com.example.demo.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class mealPlanDto {
    
    private int id;
    private String mealName;
    private String mealType;
    private int calories;
    private int protein;
    private int carbohydrates;
    private int fats;
}
