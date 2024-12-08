package com.example.demo.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Getter
@Setter
public class LoginDto {


    @NotNull
    @JsonIgnore
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String username;
    @NotNull
    public String password;
    public Date dateOfBirth;
    public String gender;
    public int weight;
    public int height;
    public String activityLevel;
    public Timestamp createdAt;
    public Timestamp updatedAt;
    public int termsAccepted;

}