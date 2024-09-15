package com.example.assesment2.dao;

import com.example.assesment2.entity.Address;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    @Modifying
    @Transactional
    @Query("update Address a set a.nickName = ?1, a.street = ?2 ,a.city = ?3, a.state = ?4, a.postalCode = ?5 where a.id = ?6")
    void setAddressInfoById(String nickName, String street,String city,String state,Integer postalCode, UUID addressId);
}
