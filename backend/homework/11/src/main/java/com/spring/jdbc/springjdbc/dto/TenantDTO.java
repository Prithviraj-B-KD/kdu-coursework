package com.spring.jdbc.springjdbc.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TenantDTO {
    @JsonDeserialize
    private UUID id;
    private String tenantName;
}
