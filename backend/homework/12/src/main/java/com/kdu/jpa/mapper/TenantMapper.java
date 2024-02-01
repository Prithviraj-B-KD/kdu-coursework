package com.kdu.jpa.mapper;

import com.kdu.jpa.dto.TenantDTO;
import com.kdu.jpa.entity.Tenant;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class TenantMapper {
    public Tenant mapTenantDTO(TenantDTO tenantDTO){
        Tenant tenant = new Tenant();
        tenant.setName(tenantDTO.getTenantName());
        tenant.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        tenant.setCreatedBy("prithvi");
        tenant.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return tenant;
    }
}