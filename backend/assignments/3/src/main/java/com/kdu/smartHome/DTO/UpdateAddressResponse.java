package com.kdu.smartHome.DTO;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class UpdateAddressResponse {
    private String message;
    private String information;
    private HttpStatus status;
}
