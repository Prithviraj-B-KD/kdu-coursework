package com.spring.jdbc.springjdbc.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ShiftDTO {
    @JsonDeserialize
    private UUID shiftTypeId;
    private String name;
    private Date dateStart;
    private Date dateEnd;
    private String timeZone;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    @JsonDeserialize
    private UUID tenantId;
}
