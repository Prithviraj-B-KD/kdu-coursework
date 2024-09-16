package com.example.assesment2.service;

import com.example.assesment2.dao.UserRepository;
import com.example.assesment2.dto.UserRequestDTO;
import com.example.assesment2.dto.UserResponseDTO;
import com.example.assesment2.entity.User;
import com.example.assesment2.exception.custom.CustomException;
import com.example.assesment2.mapper.PersonMapper;
import com.example.assesment2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PersonMapper personMapper;
    PersonService personService;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, PersonMapper personMapper, PersonService personService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.personMapper = personMapper;
        this.personService = personService;
    }


    /**
     * user is created and added to security and database
     *
     * @param userRequestDTO
     */
    public void addUser(UserRequestDTO userRequestDTO){
        try {
            User user = userMapper.mapUserRequestDTO(userRequestDTO);
            userRepository.save(user);
            personService.addPerson(personMapper.mapUser(user));
        } catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    /**
     *
     * @param userid get user from database by id
     * @return
     */
    public UserResponseDTO getUserById(UUID userid){
        return  userMapper.mapUser(userRepository.getReferenceById(userid));
    }
    public void updateUserById(UserRequestDTO userRequestDTO,UUID userid){
        try {
        User updatedUser = userMapper.mapUserRequestDTO(userRequestDTO);
        userRepository.setUserInfoById(updatedUser.getFullName(), updatedUser.getEmail(), updatedUser.getPassword(), userid);
        } catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }

    /**
     *  delete user by id
     * @param userid
     */
    public void deleteUsersById(UUID userid){
            try {
            userRepository.deleteById(userid);
            } catch (Exception e){
                throw new CustomException(e.getMessage());
            }
    }
}
