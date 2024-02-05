package com.kdu.smartHome.service;

import com.kdu.smartHome.DTO.HouseRegisterRequest;
import com.kdu.smartHome.DTO.UpdateAddressRequest;
import com.kdu.smartHome.dao.HouseRepository;
import com.kdu.smartHome.dao.UserRepository;
import com.kdu.smartHome.entity.House;
import com.kdu.smartHome.entity.Users;
import com.kdu.smartHome.exception.custom.CustomException;
import com.kdu.smartHome.mapper.HouserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HouseService {
    HouseRepository houseRepository;
    UserRepository userRepository;
    HouserMapper houserMapper;

    @Autowired
    public HouseService(HouseRepository houseRepository,HouserMapper houserMapper,UserRepository userRepository) {
        this.houseRepository = houseRepository;
        this.houserMapper = houserMapper;
        this.userRepository = userRepository;
    }

    public House houseRegister(HouseRegisterRequest houseRegisterRequest, String adminUserName){
        House house = houserMapper.HouserMapper(houseRegisterRequest);
        Users users = userRepository.findUserByUsername(adminUserName);
        if (users == null){
            throw new CustomException("User Not found with username: "+ adminUserName+ " register First!");
        }
        house.setAdmin(users);
        house.setUsersList(Arrays.asList(users));
        houseRepository.save(house);
        return house;
    }

    public List<House> getAllHouse(){
        return houseRepository.findAll();
    }

    public House getHouseById(UUID houseId){
        Optional<House> house = houseRepository.findById(houseId);
        if(house.isPresent()){
            return house.get();
        } else {
            throw new CustomException("House Id is not found");
        }

    }
    public House houseUpdate(UpdateAddressRequest updateAddressRequest, UUID houseId){
        Optional<House> house = houseRepository.findById(houseId);
        if(house.isPresent()){
            House modifiedHouse = house.get();
            modifiedHouse.setAddress(updateAddressRequest.getAddress());
            houseRepository.save(modifiedHouse);
            return modifiedHouse;
        } else {
            throw new CustomException("House Id is not found");
        }
    }
    public void addUserToHouse(UUID houseId,String authorizingUsername,String newUsername){
        Optional<House> house = houseRepository.findById(houseId);
        if(house.isPresent()){
            House presentHouse = house.get();
            if (presentHouse.getAdmin().getUsername().equals(authorizingUsername)){
              Users users = userRepository.findUserByUsername(newUsername);
              if(users !=null) {
                  List<Users> usersList = presentHouse.getUsersList();
                  usersList.add(users);
                  presentHouse.setUsersList(usersList);
                  houseRepository.save(presentHouse);
              }
              else {
                  throw new CustomException("Not a valid user");
              }
            }
              else {
                  throw new CustomException("Not a admin");
                }
        } else {
            throw new CustomException("not a valid house");
        }

    }

}
