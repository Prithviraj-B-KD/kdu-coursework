package com.spring.jdbc.springjdbc.service;

import com.spring.jdbc.springjdbc.dao.ShiftUserDAO;
import com.spring.jdbc.springjdbc.dto.ShiftUserDTO;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ShiftUserService {
    ShiftUserDAO shiftUserDAO;
    @Autowired
    ShiftUserService(ShiftUserDAO shiftUserDAO)
    {
        this.shiftUserDAO = shiftUserDAO;
    }
    public boolean addShiftUser(ShiftUserDTO shiftUserDTO) {
        try {
        return shiftUserDAO.addShiftUser(shiftUserDTO)!=0;
    }catch (Exception exception){
        log.error(exception.getMessage());
        return false;
    }
    }
    public List<ShiftUserDTO> getShiftUsersByTenantID(UUID tenantId) {
        return shiftUserDAO.getShiftUserByTenantId(tenantId);
    }
}
