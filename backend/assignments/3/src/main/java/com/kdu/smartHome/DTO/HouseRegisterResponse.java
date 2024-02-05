package com.kdu.smartHome.DTO;

import com.kdu.smartHome.entity.House;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class HouseRegisterResponse {
    private String message;
    private House house;
    private HttpStatus status;
}
