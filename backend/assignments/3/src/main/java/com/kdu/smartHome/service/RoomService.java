package com.kdu.smartHome.service;

import com.kdu.smartHome.DTO.AddRoomRequest;
import com.kdu.smartHome.dao.HouseRepository;
import com.kdu.smartHome.dao.RoomRepository;
import com.kdu.smartHome.entity.House;
import com.kdu.smartHome.entity.Room;
import com.kdu.smartHome.exception.custom.CustomException;
import com.kdu.smartHome.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {
    RoomRepository roomRepository;
    HouseRepository houseRepository;

    RoomMapper roomMapper;

    @Autowired
    public RoomService(RoomRepository roomRepository, HouseRepository houseRepository,RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.houseRepository = houseRepository;
        this.roomMapper = roomMapper;
    }

    public Room addRoomByAdmin(UUID houseId, AddRoomRequest addRoomRequest, String userName){
        Optional<House> house = houseRepository.findById(houseId);
        Room newRoom = roomMapper.mapAddRoomRequest(addRoomRequest);
        if(house.isPresent()){
            House presentHouse = house.get();
            if (presentHouse.getAdmin().getUsername().equals(userName)){
                List<Room> rooms = presentHouse.getRooms();
                rooms.add(newRoom);
                presentHouse.setRooms(rooms);
                roomRepository.save(newRoom);
                houseRepository.save(presentHouse);
                return newRoom;
            } else {
                throw new CustomException("Only Admin can add room.");
            }
        } else {
            throw new CustomException("House Id doesnt exist");
        }
    }
}
