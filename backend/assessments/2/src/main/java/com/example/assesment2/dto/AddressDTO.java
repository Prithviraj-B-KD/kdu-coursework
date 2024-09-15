package com.example.assesment2.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddressDTO {
    private String nickName;
    private String street;
    private String city;
    private String state;
    private int postalCode;
}
