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

import com.example.demo.Dto.Trainers;
import com.example.demo.Service.TrainerService;

@ExtendWith(MockitoExtension.class)
public class TrainerControllerTest {

    @Mock
    private TrainerService trainerService;

    @InjectMocks
    private TrainerController trainerController;

    private Trainers mockTrainer;


    @Test
    public void testGetUsers_Success() {
        // Arrange
        List<Trainers> mockTrainersList = new ArrayList<>();
        mockTrainersList.add(mockTrainer);
        when(trainerService.getTrainerList()).thenReturn(mockTrainersList);

        // Act
        ResponseEntity<?> response = trainerController.getUsers();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("TrainerDetails:"));
        assertTrue(((Map<?, ?>) response.getBody()).containsKey("TrainerDetails:"));
        assertTrue(((List<?>) ((Map<?, ?>) response.getBody()).get("TrainerDetails:")).size() > 0);
        verify(trainerService, times(1)).getTrainerList();
    }

    @Test
    public void testGetUsers_EmptyList() {
        // Arrange
        List<Trainers> emptyList = new ArrayList<>();
        when(trainerService.getTrainerList()).thenReturn(emptyList);

        // Act
        ResponseEntity<?> response = trainerController.getUsers();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(((Map<?, ?>) response.getBody()).containsKey("TrainerDetails:"));
        assertTrue(((List<?>) ((Map<?, ?>) response.getBody()).get("TrainerDetails:")).isEmpty());
        verify(trainerService, times(1)).getTrainerList();
    }
}
