package com.example.assesment2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;

    private String username;

    private String password;

    private String role;
}