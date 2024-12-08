package com.example.demo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class exercisesDto {
    
    @NotNull
    public int id;
    public String exerciseName;
    public String category;
    public int duration;
}
