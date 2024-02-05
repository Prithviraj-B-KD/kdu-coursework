package com.kdu.smartHome.service;


import com.kdu.smartHome.DTO.UserRegisterRequest;
import com.kdu.smartHome.dao.UserRepository;
import com.kdu.smartHome.entity.Users;
import com.kdu.smartHome.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;

    }

    public void registerUser(UserRegisterRequest userRegisterRequest){
        Users users = userMapper.mapUserRequest(userRegisterRequest);
        userRepository.save(users);
    }
}

