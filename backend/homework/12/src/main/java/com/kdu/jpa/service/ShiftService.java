package com.kdu.jpa.service;

import com.kdu.jpa.dao.ShiftRepository;
import com.kdu.jpa.entity.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;

    @Autowired
    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public void saveShift(Shift shift) {
        shiftRepository.save(shift);
    }
}
