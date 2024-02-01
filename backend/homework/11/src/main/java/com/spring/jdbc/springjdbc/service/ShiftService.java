package com.spring.jdbc.springjdbc.service;

import com.spring.jdbc.springjdbc.dao.ShiftDAO;
import com.spring.jdbc.springjdbc.dto.ShiftDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ShiftService {
    ShiftDAO shiftDAO;

    @Autowired
    ShiftService(ShiftDAO shiftDAO) {
        this.shiftDAO = shiftDAO;
    }

    public boolean addShift(ShiftDTO shiftDTO) {
        try {
            return shiftDAO.addShift(shiftDTO) != 0;
        }catch (Exception exception){
            log.error(exception.getMessage());
            return false;
        }
    }

    public List<ShiftDTO> getShift(UUID tenantId) {
        return shiftDAO.getShift(tenantId);
}

}


