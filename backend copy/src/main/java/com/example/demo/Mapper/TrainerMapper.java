package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Dto.Trainers;

@Mapper
public interface TrainerMapper {
    

    @Select("Select * from GymTrainer")
    List<Trainers> getTrainerDetails();
}
