package com.kdu.smartHome.mapper;


import com.kdu.smartHome.DTO.UserRegisterRequest;
import com.kdu.smartHome.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public Users mapUserRequest(UserRegisterRequest userRegisterRequest){
        return Users.builder()
                .name(userRegisterRequest.getName())
                .username(userRegisterRequest.getUsername())
                .emailId(userRegisterRequest.getEmailId())
                .firstName(userRegisterRequest.getFirstName())
                .lastName(userRegisterRequest.getLastName())
                .password(userRegisterRequest.getPassword())
                .build();
    }
}
