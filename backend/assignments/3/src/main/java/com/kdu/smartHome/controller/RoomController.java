package com.kdu.smartHome.controller;


import com.kdu.smartHome.DTO.AddRoomRequest;
import com.kdu.smartHome.DTO.AddRoomResponse;
import com.kdu.smartHome.entity.Room;
import com.kdu.smartHome.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class RoomController {

    RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/room")
    public ResponseEntity<AddRoomResponse> addRoomByAdmin(@RequestParam UUID houseId, @RequestBody AddRoomRequest addRoomRequest){
        Room room = roomService.addRoomByAdmin(houseId,addRoomRequest,"prithvi");
        return ResponseEntity.ok(AddRoomResponse.builder().message("Added Room Successfully").room(room).status(HttpStatus.OK).build());
    }
}
