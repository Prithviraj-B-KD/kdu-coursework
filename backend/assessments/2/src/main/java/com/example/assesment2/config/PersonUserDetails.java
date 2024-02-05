package com.example.assesment2.config;

import com.example.assesment2.entity.Person;
import com.example.assesment2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonUserDetails implements UserDetailsService {
    PersonService personService;

    @Autowired
    public PersonUserDetails(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personService.getPersonUsername(username);
        String personUserName = null;
        String personPassword = null;
        List<GrantedAuthority> authorities = null;
        if(person == null){
            throw new UsernameNotFoundException("User details not found for user : " + username + ". Please register fist.");
        } else {
            personUserName = person.getUsername();
            personPassword = person.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(person.getRole()));

        }

        return new User(personUserName,personPassword,authorities);
    }
}