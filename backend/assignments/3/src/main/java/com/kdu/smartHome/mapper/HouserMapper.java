package com.kdu.smartHome.mapper;


import com.kdu.smartHome.DTO.HouseRegisterRequest;
import com.kdu.smartHome.entity.House;
import org.springframework.stereotype.Component;

@Component
public class HouserMapper {
    public House HouserMapper(HouseRegisterRequest houseRegisterRequest){
        return House.builder()
                .address(houseRegisterRequest.getAddress())
                .houseName(houseRegisterRequest.getHouseName())
                .build();
    }
}
