package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.SignUpDto;
import com.example.demo.Mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class LoginService {
    
     @Autowired
    LoginMapper loginMapper;

    public List<LoginDto> getUserList() {
        List<LoginDto> users = loginMapper.checkUsers();
        return users;
    }

    public LoginDto getUserByEmail(String email) {
        LoginDto details = loginMapper.getUserByEmail(email);
        return details;
    }

    public String addUsers(LoginDto loginDto) {
        LoginDto details = loginMapper.getUserByEmail(loginDto.getEmail());
        System.out.println(details);
        if(details==null) {
            loginMapper.insertUser(loginDto);
        }else{
            return "User with email already exists";
        }
        return null;
    }

    public String login(SignUpDto signUpDto) {
        LoginDto loginDto = loginMapper.getUserByEmail(signUpDto.getEmail());
        if (loginDto == null) {
            return "User Not Found";
        } else if (loginDto.getPassword().equals(signUpDto.getPassword())) {
            return "Login Successful";
        } else {
            return "Wrong Password";
        }
    }

    public boolean updatePassword(String email, String password) {
        LoginDto user = loginMapper.getUserByEmail(email);
        if (user != null) {
            loginMapper.updatePassword(email, password);
            return true;
        }
        return false;
    }
}
