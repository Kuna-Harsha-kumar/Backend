package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.exercisesDto;
import com.example.demo.Mapper.ActivityMapper;


@Service
public class ExercisesServiceImpl {
    

     @Autowired
    ActivityMapper activityMapper;

    public List<exercisesDto> getallExercies(){
        List<exercisesDto> details=activityMapper.getexercises();
        return details;
    }

    public List<exercisesDto> getExercisesBycategpry(String category){
        System.out.println(category);
        List<exercisesDto> detilas=activityMapper.getExercisesByCategory(category);
        return detilas;
    }

    public exercisesDto getExercise(String exercise){
        exercisesDto details=activityMapper.getExcerciseDetails(exercise);
        return details;
    }
}
