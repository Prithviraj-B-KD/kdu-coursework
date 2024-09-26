package com.kdu.smartHome.controller;


import com.kdu.smartHome.DTO.*;
import com.kdu.smartHome.entity.House;
import com.kdu.smartHome.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/house")
public class HouseController {

    HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping
    public ResponseEntity<HouseRegisterResponse> houseRegister(@RequestBody HouseRegisterRequest houseRegisterRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String adminUsername = authentication.getName();
        House house = houseService.houseRegister(houseRegisterRequest,adminUsername);
        HouseRegisterResponse houseAddedSuccessfully = HouseRegisterResponse.builder().message("House Added Successfully").house(house).status(HttpStatus.OK).build();
        return ResponseEntity.ok(houseAddedSuccessfully);

    }

    @GetMapping
    public ResponseEntity<List<House>> getListOfAllHouse(){
        return ResponseEntity.ok(houseService.getAllHouse());
    }

    @GetMapping("/{houseId}")
    public ResponseEntity<House> getHouseById(@PathVariable UUID houseId){
       return ResponseEntity.ok(houseService.getHouseById(houseId));
    }

    @PutMapping
    public ResponseEntity<UpdateAddressResponse> houseUpdate(@RequestBody UpdateAddressRequest updateAddressRequest, @RequestParam UUID houseId){
       House house =  houseService.houseUpdate(updateAddressRequest,houseId);
       return ResponseEntity.ok(UpdateAddressResponse
               .builder()
               .message("updated Successfully")
                       .information(house.toString())
                       .status(HttpStatus.OK)
               .build());
    }

    @PostMapping("/{houseId}/add-user")
    public ResponseEntity<String> addUserToHouse(@PathVariable UUID houseId, @RequestBody AddUserToHouseRequest addUserToHouseRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authorizingUsername = authentication.getName();
        String newUsername = addUserToHouseRequest.getUsername();
        houseService.addUserToHouse(houseId,authorizingUsername,newUsername);
        return ResponseEntity.ok("Added user to house Successfully");
    }
}
