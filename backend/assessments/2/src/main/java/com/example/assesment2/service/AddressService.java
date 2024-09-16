package com.example.assesment2.service;

import com.example.assesment2.dao.AddressRepository;
import com.example.assesment2.dto.AddressDTO;
import com.example.assesment2.entity.Address;
import com.example.assesment2.mapper.AddressMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {

    AddressRepository addressRepository;
    AddressMapper addressMapper;

    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public void addAddress(AddressDTO addressDTO){
        addressRepository.save(addressMapper.mapAddressDTO(addressDTO));
    }

    public Address getAddressById(UUID addressid){
        return addressRepository.getReferenceById(addressid);
    }

public void updateAddressByID(AddressDTO addressDTO,UUID addressid){
        addressRepository.setAddressInfoById(addressDTO.getNickName(), addressDTO.getStreet(), addressDTO.getCity(), addressDTO.getState(), addressDTO.getPostalCode(),addressid);
}
    public void deleteAddressById(UUID addressid){
        addressRepository.deleteById(addressid);
    }
}
