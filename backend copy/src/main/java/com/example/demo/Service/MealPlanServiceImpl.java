package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.mealPlanDto;
import com.example.demo.Mapper.MealMapper;


@Service
public class MealPlanServiceImpl {
    


    @Autowired
    MealMapper mealMapper;

    public List<mealPlanDto> getMealPlanList(){
        List<mealPlanDto> mealDetails=mealMapper.getMealPlan();
        return mealDetails;
    }

    public List<mealPlanDto> getMealPlanByType(String mealType){
        List<mealPlanDto> mealDetails=mealMapper.getMealByType(mealType);
        return mealDetails;
    }

    public List<mealPlanDto> getMealPlanByCalories(String mealType,String calories){
        List<mealPlanDto> mealDetailsByCalories=mealMapper.getMealByCalories(mealType,calories);
        return mealDetailsByCalories;
    }
}
