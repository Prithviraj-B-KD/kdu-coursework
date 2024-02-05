package com.kdu.smartHome.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterResponse {
    private String message;
    private String token;
}
