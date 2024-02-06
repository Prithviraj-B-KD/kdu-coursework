package com.example.assesment2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {
    private String fullName;
    private String email;

}
