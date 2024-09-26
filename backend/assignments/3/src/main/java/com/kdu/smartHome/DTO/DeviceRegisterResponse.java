package com.kdu.smartHome.DTO;


import com.kdu.smartHome.entity.Device;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceRegisterResponse{
    private String message;
    private Device device;
    private HttpStatus status;
}
