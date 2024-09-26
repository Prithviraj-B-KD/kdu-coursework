package com.kdu.jpa.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kdu.jpa.entity.ShiftType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class ShiftDTO {
    @JsonDeserialize
    private ShiftType shiftTypeId;
    private String name;
    private Date dateStart;
    private Date dateEnd;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private String timeZone;
    @JsonDeserialize
    private UUID tenantId;



}