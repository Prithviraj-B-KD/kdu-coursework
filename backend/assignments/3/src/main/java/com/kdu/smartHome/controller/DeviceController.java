package com.kdu.smartHome.controller;

import com.kdu.smartHome.DTO.AddDeviceRequest;
import com.kdu.smartHome.DTO.DeviceRegisterRequest;
import com.kdu.smartHome.DTO.DeviceRegisterResponse;
import com.kdu.smartHome.entity.Device;
import com.kdu.smartHome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/device")
public class DeviceController {
    DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/register")
    public ResponseEntity<DeviceRegisterResponse> registerDevice(@RequestBody DeviceRegisterRequest deviceRegisterRequest){
        Device device = deviceService.registerDevice(deviceRegisterRequest);
        return ResponseEntity.ok(DeviceRegisterResponse.builder()
                        .message("Registered Device Successfully")
                        .device(device)
                        .status(HttpStatus.OK)
                .build());

    }

    @PostMapping("/add")
    public ResponseEntity<DeviceRegisterResponse> addDeviceToHouse(@RequestBody AddDeviceRequest addDeviceRequest){
        Device device = deviceService.addDeviceToHouse(addDeviceRequest);
        return ResponseEntity.ok(DeviceRegisterResponse.builder()
                        .message("Device Added successfully")
                        .device(device)
                        .status(HttpStatus.OK)
                .build());

    }
}
