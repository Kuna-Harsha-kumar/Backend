package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.demo.Dto.exercisesDto;
import com.example.demo.Service.ExercisesServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ExerciseControllerTest{

    @Mock
    private ExercisesServiceImpl exercisesService;

    @InjectMocks
    private ExercicsesController exercicesController;

    private List<exercisesDto> mockExerciseList;
    private exercisesDto mockExercise;

    @BeforeEach
    public void setUp() {
        // Setting up mock data
        mockExercise = new exercisesDto();
        mockExercise.setExerciseName("Push Up");

        mockExerciseList = new ArrayList<>();
        mockExerciseList.add(mockExercise);
    }

    @Test
    public void testGetUsers() {
        // Arrange
        when(exercisesService.getallExercies()).thenReturn(mockExerciseList);

        // Act
        ResponseEntity<?> response = exercicesController.getUsers();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("Exercises:"));
        verify(exercisesService, times(1)).getallExercies();
    }

    @Test
    public void testGetExercisesByCategory() {
        // Arrange
        String category = "Strength";
        when(exercisesService.getExercisesBycategpry(category)).thenReturn(mockExerciseList);

        // Act
        ResponseEntity<?> response = exercicesController.getExercisesByCategory(category);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("Category Exercises:"));
        verify(exercisesService, times(1)).getExercisesBycategpry(category);
    }

    @Test
    public void testGetExercise() {
        // Arrange
        String exerciseName = "Push Up";
        when(exercisesService.getExercise(exerciseName)).thenReturn(mockExercise);

        // Act
        ResponseEntity<?> response = exercicesController.getExercise(exerciseName);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("Exercises:"));
        verify(exercisesService, times(1)).getExercise(exerciseName);
    }

}
