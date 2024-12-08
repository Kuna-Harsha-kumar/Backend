package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Dto.LoginDto;

@Mapper
public interface LoginMapper {
    
    @Select("Select * from users")
    List<LoginDto> checkUsers();

    @Insert("insert into users(first_name,last_name,email,username,password,date_of_birth," +
            "gender,weight,height,activity_level,terms_accepted) values" +
            "(#{firstName},#{lastName},#{email},#{username},#{password},#{dateOfBirth}," +
            "#{gender},#{weight},#{height},#{activityLevel},#{termsAccepted}) ")
    void insertUser(LoginDto loginDto);

    @Select("Select * from users where email=#{email}")
    LoginDto getUserByEmail(String email);

     @Update("UPDATE users SET password = ? WHERE email = ?")
    void updatePassword(String password,String email);
}
