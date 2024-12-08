package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.Trainers;
import com.example.demo.Mapper.TrainerMapper;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class TrainerService {

    @Autowired
    TrainerMapper trainerMapper;

     public List<Trainers> getTrainerList() {
        List<Trainers> users = trainerMapper.getTrainerDetails();
        return users;
    }

    
}
