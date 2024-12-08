package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.SignUpDto;
import com.example.demo.Service.LoginService;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @Mock
    private LoginService loginServiceImpl;

    @InjectMocks
    private LoginController loginController;

    private LoginDto mockLoginDto;
    private SignUpDto mockSignUpDto;

    @BeforeEach
    public void setUp() {
        // Mocking some data
        mockLoginDto = new LoginDto();
        mockLoginDto.setEmail("user@example.com");
        mockLoginDto.setPassword("password123");

        mockSignUpDto = new SignUpDto();
        mockSignUpDto.setEmail("user@example.com");
        mockSignUpDto.setPassword("password123");
    }

    @Test
    public void testGetUsers() {
        // Arrange
        List<LoginDto> mockUserList = new ArrayList<>();
        mockUserList.add(mockLoginDto);
        when(loginServiceImpl.getUserList()).thenReturn(mockUserList);

        // Act
        ResponseEntity<?> response = loginController.getUsers();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("Users:"));
        verify(loginServiceImpl, times(1)).getUserList();
    }

    @Test
    public void testAddUsers_Success() {
        // Arrange
        when(loginServiceImpl.addUsers(mockLoginDto)).thenReturn(null);

        // Act
        ResponseEntity<?> response = loginController.addUsers(mockLoginDto);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("User added "));
        verify(loginServiceImpl, times(1)).addUsers(mockLoginDto);
    }

    @Test
    public void testAddUsers_UserAlreadyExists() {
        // Arrange
        when(loginServiceImpl.addUsers(mockLoginDto)).thenReturn("User already exists");

        // Act
        ResponseEntity<?> response = loginController.addUsers(mockLoginDto);

        // Assert
        assertEquals(400, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("User already exists "));
        verify(loginServiceImpl, times(1)).addUsers(mockLoginDto);
    }

    @Test
    public void testLogin_Success() {
        // Arrange
        when(loginServiceImpl.login(mockSignUpDto)).thenReturn("Login Successful");

        // Act
        ResponseEntity<?> response = loginController.login(mockSignUpDto);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Login Successful", response.getBody());
        verify(loginServiceImpl, times(1)).login(mockSignUpDto);
    }

    @Test
    public void testForgotPassword_Success() {
        // Arrange
        String email = "user@example.com";
        String newPassword = "newpassword123";
        when(loginServiceImpl.updatePassword(email, newPassword)).thenReturn(true);

        // Act
        String response = loginController.forgotPassword(email, newPassword);

        // Assert
        assertEquals("Password reset successfully!", response);
        verify(loginServiceImpl, times(1)).updatePassword(email, newPassword);
    }

    @Test
    public void testForgotPassword_UserNotFound() {
        // Arrange
        String email = "nonexistent@example.com";
        String newPassword = "newpassword123";
        when(loginServiceImpl.updatePassword(email, newPassword)).thenReturn(false);

        // Act
        String response = loginController.forgotPassword(email, newPassword);

        // Assert
        assertEquals("User not found!", response);
        verify(loginServiceImpl, times(1)).updatePassword(email, newPassword);
    }

    @Test
    public void testGetDetailsByEmail_Success() {
        // Arrange
        String email = "user@example.com";
        when(loginServiceImpl.getUserByEmail(email)).thenReturn(mockLoginDto);

        // Act
        ResponseEntity<?> response = loginController.getDetailsByEmail(email);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockLoginDto, response.getBody());
        verify(loginServiceImpl, times(1)).getUserByEmail(email);
    }

}
