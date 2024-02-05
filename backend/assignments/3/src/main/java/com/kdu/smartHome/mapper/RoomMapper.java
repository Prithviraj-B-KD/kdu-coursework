package com.kdu.smartHome.mapper;


import com.kdu.smartHome.DTO.AddRoomRequest;
import com.kdu.smartHome.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    public Room mapAddRoomRequest(AddRoomRequest addRoomRequest){
        return Room.builder()
        .roomName(addRoomRequest.getRoomName())
        .build();
    }
}
