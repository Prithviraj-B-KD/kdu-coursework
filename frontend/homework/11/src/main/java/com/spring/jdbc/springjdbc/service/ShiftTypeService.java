package com.spring.jdbc.springjdbc.service;

import com.spring.jdbc.springjdbc.dao.ShiftTypeDAO;
import com.spring.jdbc.springjdbc.dto.ShiftTypeDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ShiftTypeService {
    ShiftTypeDAO shiftTypeDAO;
    @Autowired
    ShiftTypeService(ShiftTypeDAO shiftTypeDAO)
    {
        this.shiftTypeDAO = shiftTypeDAO;
    }
    public boolean addShiftType(ShiftTypeDTO shiftTypeDTO) {
        try {
            return shiftTypeDAO.addShiftType(shiftTypeDTO) != 0;
        } catch (Exception exception){
            log.error(exception.getMessage());
            return false;
        }
    }

    public List<ShiftTypeDTO> getShift(UUID tenantId)
    {
        return shiftTypeDAO.getShift(tenantId);
    }
}
