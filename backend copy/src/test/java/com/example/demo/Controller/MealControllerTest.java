package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.demo.Dto.mealPlanDto;
import com.example.demo.Service.MealPlanServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MealControllerTest {

    @Mock
    private MealPlanServiceImpl mealPlanServiceImpl;

    @InjectMocks
    private MealController mealController;

    private mealPlanDto mockMealPlan;


    @Test
    public void testGetMealPlans_Success() {
        // Arrange
        List<mealPlanDto> mockMealPlans = new ArrayList<>();
        mockMealPlans.add(mockMealPlan);
        when(mealPlanServiceImpl.getMealPlanList()).thenReturn(mockMealPlans);

        // Act
        ResponseEntity<?> response = mealController.getMealPlans();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("Meal Details"));
        assertTrue(((Map<?, ?>) response.getBody()).containsKey("Meal Details"));
        assertTrue(((List<?>) ((Map<?, ?>) response.getBody()).get("Meal Details")).size() > 0);
        verify(mealPlanServiceImpl, times(1)).getMealPlanList();
    }

    @Test
    public void testGetMealPlanByType_Success() {
        // Arrange
        List<mealPlanDto> mockMealPlans = new ArrayList<>();
        mockMealPlans.add(mockMealPlan);
        when(mealPlanServiceImpl.getMealPlanByType("Vegetarian")).thenReturn(mockMealPlans);

        // Act
        ResponseEntity<?> response = mealController.getMealPlanByType("Vegetarian");

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("Meal Details"));
        assertTrue(((Map<?, ?>) response.getBody()).containsKey("Meal Details"));
        assertTrue(((List<?>) ((Map<?, ?>) response.getBody()).get("Meal Details")).size() > 0);
        verify(mealPlanServiceImpl, times(1)).getMealPlanByType("Vegetarian");
    }
    @Test
    public void testGetMealPlanByCalories_Success() {
        // Arrange
        List<mealPlanDto> mockMealPlans = new ArrayList<>();
        mockMealPlans.add(mockMealPlan);
        when(mealPlanServiceImpl.getMealPlanByCalories("Vegetarian", "500")).thenReturn(mockMealPlans);

        // Act
        ResponseEntity<?> response = mealController.getMealPlanByCalories("Vegetarian", "500");

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("Meal Details"));
        assertTrue(((Map<?, ?>) response.getBody()).containsKey("Meal Details"));
        assertTrue(((List<?>) ((Map<?, ?>) response.getBody()).get("Meal Details")).size() > 0);
        verify(mealPlanServiceImpl, times(1)).getMealPlanByCalories("Vegetarian", "500");
    }

    @Test
    public void testGetMealPlanByCalories_Failure() {
        // Arrange
        List<mealPlanDto> emptyMealPlans = new ArrayList<>();
        when(mealPlanServiceImpl.getMealPlanByCalories("Vegetarian", "1000")).thenReturn(emptyMealPlans);

        // Act
        ResponseEntity<?> response = mealController.getMealPlanByCalories("Vegetarian", "1000");

        // Assert
        assertEquals(400, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("Meal Not available"));
        verify(mealPlanServiceImpl, times(1)).getMealPlanByCalories("Vegetarian", "1000");
    }
}
