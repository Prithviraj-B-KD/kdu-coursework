package com.kdu.jpa.mapper;

import com.kdu.jpa.dto.ShiftTypeDTO;
import com.kdu.jpa.entity.ShiftType;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class ShiftTypeMapper {
    public ShiftType mapShiftTypeDTO(ShiftTypeDTO shiftTypeDTO){
        ShiftType shiftType = new ShiftType();
        shiftType.setUqName(shiftType.getUqName());
        shiftType.setDescription(shiftTypeDTO.getDescription());
        shiftType.setActive(true);
        shiftType.setTimezone("india");
        shiftType.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        shiftType.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return shiftType;
    }
}