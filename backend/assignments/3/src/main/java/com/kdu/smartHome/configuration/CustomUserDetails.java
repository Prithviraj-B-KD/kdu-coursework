package com.kdu.smartHome.configuration;


import com.kdu.smartHome.dao.UserRepository;
import com.kdu.smartHome.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetails implements UserDetailsService {
    UserRepository userRepository;

    @Autowired
    public CustomUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users currentUsers = userRepository.findUserByUsername(username);
        if(currentUsers == null){
            throw new UsernameNotFoundException("User details not found for user : " + username + ". Please register fist.");
        }
        String currentUsername = currentUsers.getUsername();
        String currentPassword= currentUsers.getPassword();
        List<GrantedAuthority> authorities= new ArrayList<>();
        return new User(currentUsername,currentPassword,authorities);
    }
}
