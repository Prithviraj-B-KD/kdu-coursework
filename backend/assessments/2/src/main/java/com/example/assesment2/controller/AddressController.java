package com.example.assesment2.controller;

import com.example.assesment2.dto.AddressDTO;
import com.example.assesment2.entity.Address;
import com.example.assesment2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class AddressController {
    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping("/address/add")
    public ResponseEntity<String> addAddress(@RequestBody AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return new ResponseEntity<>("Address added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/address/{addressid}")
    public ResponseEntity<Address> getAddressById(@PathVariable UUID addressid){
        return new ResponseEntity<>(addressService.getAddressById(addressid),HttpStatus.FOUND);
    }

    @PutMapping("/address/{addressid}")
    public ResponseEntity<String> updateAddressById(@PathVariable UUID addressid , @RequestBody AddressDTO addressDTO){
        addressService.updateAddressByID(addressDTO,addressid);
        return new ResponseEntity<>("Successfully Updated Address",HttpStatus.CREATED);
    }

    @DeleteMapping("/address/{addressid}")
    public ResponseEntity<String> deleteAddressById(@PathVariable UUID addressid){
        addressService.deleteAddressById(addressid);
        return new ResponseEntity<>("Deleted Address Successfully",HttpStatus.ACCEPTED);
    }
}
