package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.exercisesDto;
import com.example.demo.Service.ExercisesServiceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ExercicsesController {
    
    @Autowired
    ExercisesServiceImpl exercisesService;


    @GetMapping("/exercisedetails")
    public ResponseEntity<?> getUsers(){
        Map<String, List<exercisesDto>> response = new HashMap<>();
        List<exercisesDto> users=exercisesService.getallExercies();
        response.put("Exercises:",users);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/categoryExercises")
    public ResponseEntity<?> getExercisesByCategory(String category){
        Map<String, List<exercisesDto>> response = new HashMap<>();
        System.out.println(category);
        List<exercisesDto> users=exercisesService.getExercisesBycategpry(category);
        response.put("Category Exercises:",users);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/exercise")
    public ResponseEntity<?> getExercise(String exercise){
        Map<String, exercisesDto> response = new HashMap<>();
        exercisesDto users=exercisesService.getExercise(exercise);
        response.put("Exercises:",users);
        return ResponseEntity.status(200).body(response);
    }

}
