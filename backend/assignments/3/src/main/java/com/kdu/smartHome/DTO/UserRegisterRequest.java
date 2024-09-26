package com.kdu.smartHome.DTO;


import lombok.Builder;
import lombok.Data;

import java.util.regex.Pattern;

@Data
@Builder
public class UserRegisterRequest {

    private String username;
    private String password;
    private String name;
    private String firstName;
    private String lastName;
    private String emailId;

    public void validate() {
        if (username.isBlank()) {
            throw new IllegalArgumentException("Username is required");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        if (!Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", emailId)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // Add more validation rules as needed, checking each field

        // If all validations pass, you can perform additional actions here
    }

    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }

}

