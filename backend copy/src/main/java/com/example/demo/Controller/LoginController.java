package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.SignUpDto;
import com.example.demo.Mapper.LoginMapper;
import com.example.demo.Service.LoginService;

import jakarta.validation.Valid;


@CrossOrigin(origins = "https://fit-fusion-frontend-b67076fd503c.herokuapp.com")
@RestController
@RequestMapping("/api")
public class LoginController {
    
    @Autowired
    LoginMapper  mapper;

    @Autowired
    private LoginService loginServiceImpl;


    @GetMapping("/logindetails")
    public ResponseEntity<?> getUsers() {
        Map<String, List<LoginDto>> response = new HashMap<>();
        List<LoginDto> users = loginServiceImpl.getUserList();
        response.put("Users:", users);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/addUsers")
    public ResponseEntity<?> addUsers(@Valid @RequestBody LoginDto loginDto) {
        Map<String, String> response = new HashMap<>();
        String details=loginServiceImpl.addUsers(loginDto);
        System.out.println(details);
        if(details==null) {
            response.put("User added ", "Successfully");
        }else{
            response.put("User already exists ", "with the mailId");
            return ResponseEntity.status(400).body(response);
        }
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignUpDto signUpDto) {
        String loginResponse = loginServiceImpl.login(signUpDto);
        return ResponseEntity.status(200).body(loginResponse);
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email, @RequestParam String newPassword) {
        boolean isReset = loginServiceImpl.updatePassword(email, newPassword);
        if (isReset) {
            return "Password reset successfully!";
        }
        return "User not found!";
    }

    @GetMapping("/loginDetailsByEmail")
        public ResponseEntity<?> getDetailsByEmail(String email) {
            LoginDto loginResponse = loginServiceImpl.getUserByEmail(email);
            Map<String, String> failureresponse = new HashMap<>();
            if(loginResponse==null){
                failureresponse.put("User not","found");
                return ResponseEntity.status(400).body(loginResponse);
            }else{
            return ResponseEntity.status(200).body(loginResponse);
        }
    }
}
