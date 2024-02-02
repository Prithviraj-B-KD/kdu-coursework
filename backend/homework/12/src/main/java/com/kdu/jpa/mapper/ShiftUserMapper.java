package com.kdu.jpa.mapper;

import com.kdu.jpa.dto.ShiftUserDTO;
import com.kdu.jpa.entity.ShiftUser;
import org.springframework.stereotype.Component;

@Component
public class ShiftUserMapper {
    public ShiftUser mapShiftUserDTO(ShiftUserDTO shiftUserDTO){
        ShiftUser shiftUser= new ShiftUser();
        shiftUser.setTenantId(shiftUserDTO.getTenantId());
        shiftUser.setShiftId(shiftUserDTO.getShiftId());
        shiftUser.setUserId(shiftUserDTO.getUserId());
        return shiftUser;
    }
}
