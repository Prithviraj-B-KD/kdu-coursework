package com.example.assesment2.mapper;

import com.example.assesment2.entity.Person;
import com.example.assesment2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    PasswordEncoder passwordEncoder;

    @Autowired
    public PersonMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Person mapUser(User user){
        return new Person(user.getFullName(), user.getEmail(), passwordEncoder.encode(user.getPassword()),"ROLE_BASIC");
    }

}
