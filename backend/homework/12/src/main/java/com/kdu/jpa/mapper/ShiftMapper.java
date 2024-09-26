package com.kdu.jpa.mapper;

import com.kdu.jpa.dto.ShiftDTO;
import com.kdu.jpa.entity.Shift;
import org.springframework.stereotype.Component;

@Component
public class ShiftMapper {

    public  Shift mapShiftDTO(ShiftDTO shiftDTO){
        Shift shift = new Shift();
        shift.setShiftType(shiftDTO.getShiftTypeId());
        shift.setName(shiftDTO.getName());
        shift.setDateStart(shiftDTO.getDateStart());
        shift.setDateEnd(shiftDTO.getDateEnd());
        shift.setTimeStart(shiftDTO.getTimeStart());
        shift.setTimeEnd(shiftDTO.getTimeEnd());
        return shift;
    }
}