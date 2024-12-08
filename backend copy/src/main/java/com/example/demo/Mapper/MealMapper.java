package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Dto.mealPlanDto;

@Mapper
public interface MealMapper {

    
    @Select("select * from meal_plans")
    List<mealPlanDto> getMealPlan();

    @Select("select * from meal_plans where meal_type=#{mealType}")
    List<mealPlanDto> getMealByType(String mealType);

    @Select("select * from meal_plans where meal_type=#{mealType} and calories=#{calories}")
    List<mealPlanDto> getMealByCalories(String mealType,String calories);
}
