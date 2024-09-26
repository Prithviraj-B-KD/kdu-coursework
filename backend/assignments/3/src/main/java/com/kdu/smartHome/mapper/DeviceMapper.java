package com.kdu.smartHome.mapper;


import com.kdu.smartHome.DTO.DeviceRegisterRequest;
import com.kdu.smartHome.entity.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {
    public Device mapDeviceRequest(DeviceRegisterRequest deviceRegisterRequest){
        return Device.builder()
                .kickstonId(deviceRegisterRequest.getKickstonId())
                .deviceUsername(deviceRegisterRequest.getDeviceUsername())
                .devicePassword(deviceRegisterRequest.getDevicePassword())
                .build();
    }
}
