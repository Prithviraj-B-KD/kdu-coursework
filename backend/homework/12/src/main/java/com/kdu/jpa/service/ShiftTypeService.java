package com.kdu.jpa.service;

import com.kdu.jpa.dao.ShiftTypeRepository;
import com.kdu.jpa.entity.ShiftType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftTypeService {
    private final ShiftTypeRepository shiftTypeRepository;

    @Autowired
    public ShiftTypeService(ShiftTypeRepository shiftTypeRepository) {
        this.shiftTypeRepository = shiftTypeRepository;
    }

    public void saveshiftType(ShiftType shiftType) {
        shiftTypeRepository.save(shiftType);
    }
}
