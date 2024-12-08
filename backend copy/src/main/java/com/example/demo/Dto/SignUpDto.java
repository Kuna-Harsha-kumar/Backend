package com.example.demo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SignUpDto {
    

    @NotNull
    public String email;
    @NotNull
    public String password;
}
