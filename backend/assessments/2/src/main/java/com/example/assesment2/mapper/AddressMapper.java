package com.example.assesment2.mapper;

import com.example.assesment2.dto.AddressDTO;
import com.example.assesment2.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address mapAddressDTO(AddressDTO addressDTO){
        return Address.builder()
                .nickName(addressDTO.getNickName())
                .city(addressDTO.getCity())
                .state(addressDTO.getState())
                .street(addressDTO.getStreet())
                .postalCode(addressDTO.getPostalCode())
                .build();
    }

}
