package com.spring.jdbc.springjdbc.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ShiftUserDTO {
    @JsonDeserialize
    private UUID shiftId;
    @JsonDeserialize
    private UUID userId;
    @JsonDeserialize
    private UUID tenantId;
}
