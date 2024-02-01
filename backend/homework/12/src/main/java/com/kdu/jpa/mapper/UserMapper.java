package com.kdu.jpa.mapper;

import com.kdu.jpa.dto.UsersDTO;
import com.kdu.jpa.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapUserDTO(UsersDTO usersDTO) {
        User user = new User();
        user.setUsername(usersDTO.getUsername());
        user.setLoggedIn(usersDTO.getLoggedIn());
        user.setTimeZone("India");
        //user.setTenant(usersDTO.getTenant());
        return user;
    }
}