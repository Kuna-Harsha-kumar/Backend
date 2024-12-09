package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.Trainers;
import com.example.demo.Service.TrainerService;

@RestController
@CrossOrigin(origins = "https://fit-fusion-frontend-b67076fd503c.herokuapp.com")
public class TrainerController {
    


    @Autowired
    TrainerService trainerService;

     @GetMapping("/getTrainerDetails")
    public ResponseEntity<?> getUsers(){
        Map<String, List<Trainers>> response = new HashMap<>();
        List<Trainers> trainers=trainerService.getTrainerList();
        response.put("TrainerDetails:",trainers);
        return ResponseEntity.status(200).body(response);
    }
}
