package com.kdu.smartHome.service;

import com.kdu.smartHome.DTO.AddDeviceRequest;
import com.kdu.smartHome.DTO.DeviceRegisterRequest;
import com.kdu.smartHome.dao.DeviceRepository;
import com.kdu.smartHome.dao.HouseRepository;
import com.kdu.smartHome.dao.InventoryRepository;
import com.kdu.smartHome.dao.RoomRepository;
import com.kdu.smartHome.entity.Device;
import com.kdu.smartHome.entity.House;
import com.kdu.smartHome.entity.Inventory;
import com.kdu.smartHome.entity.Room;
import com.kdu.smartHome.exception.custom.CustomException;
import com.kdu.smartHome.mapper.DeviceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class DeviceService {
    DeviceRepository deviceRepository;
    HouseRepository houseRepository;
    RoomRepository roomRepository;
    InventoryRepository inventoryRepository;
    DeviceMapper deviceMapper;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository, InventoryRepository inventoryRepository,DeviceMapper deviceMapper,HouseRepository houseRepository,RoomRepository roomRepository) {
        this.deviceRepository = deviceRepository;
        this.inventoryRepository = inventoryRepository;
        this.deviceMapper = deviceMapper;
        this.houseRepository = houseRepository;
        this.roomRepository = roomRepository;
    }

    public Device registerDevice(DeviceRegisterRequest deviceRegisterRequest){
        Inventory foundDevice = null;
        List<Inventory> inventory = inventoryRepository.findAll();
        for(Inventory device : inventory){
           if(device.getKickstonId().equals(deviceRegisterRequest.getKickstonId())){
               foundDevice = device;
            }
        }
        if(foundDevice == null){
            throw new CustomException("Invalid Kickston Id");
        }
        if(!foundDevice.getDeviceUsername().equals(deviceRegisterRequest.getDeviceUsername())){
            throw new CustomException("Invalid username, or device doesnt exist");
        }
        if(!foundDevice.getDevicePassword().equals(deviceRegisterRequest.getDevicePassword())){
            throw new CustomException("Invalid credentials");
        }
        Device registeredDevice = deviceMapper.mapDeviceRequest(deviceRegisterRequest);
        deviceRepository.save(registeredDevice);
        return registeredDevice;
    }

    public Device addDeviceToHouse(AddDeviceRequest addDeviceRequest){
        Device foundDevice = null;
        List<Device> inventory = deviceRepository.findAll();
        for(Device device : inventory){
            if(device.getKickstonId().equals(addDeviceRequest.getKickstonId())){
                foundDevice = device;
            }
        }
        if(foundDevice == null){
            throw new CustomException("Invalid Kickston Id");
        }
        Optional<House> house = houseRepository.findById(UUID.fromString(addDeviceRequest.getHouseId()));
        if(house.isEmpty()){
           throw new CustomException("Invalid House id");
        }
        House ourHouse = house.get();
        List<Room> rooms = ourHouse.getRooms();
        Room deviceRoom = null;
        if(rooms == null){

        }
        for(Room room : rooms){
            if(room.getId().equals(UUID.fromString(addDeviceRequest.getRoomId()))){
                deviceRoom = room;
            }
        }
        if(deviceRoom == null){
            throw new CustomException("Invalid Room id");
        }
        List<Device> deviceList = deviceRoom.getDevices();
        deviceList.add(foundDevice);
        roomRepository.save(deviceRoom);
        return foundDevice;
    }


}
