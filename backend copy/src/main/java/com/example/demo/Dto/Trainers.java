package com.example.demo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Trainers {
    

  @NotNull
  public int id;
  public String FirstName;
  public String LastName;
  public String Gender;
  public String Email;
  public String Qualifications;
  public String Specialization;
  public int YearOfExperience;
  public String Bio;
  public int Rating;
  public String Availability;
}
