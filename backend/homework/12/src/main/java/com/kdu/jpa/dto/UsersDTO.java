package com.kdu.jpa.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kdu.jpa.entity.Tenant;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
@Data
@RequiredArgsConstructor
public class UsersDTO {

    private String username;
    private int loggedIn;
    private String timeZone;
//    @JsonDeserialize
//    private Tenant tenant;

}