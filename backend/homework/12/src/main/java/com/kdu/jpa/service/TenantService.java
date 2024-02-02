package com.kdu.jpa.service;

import com.kdu.jpa.dao.ShiftRepository;
import com.kdu.jpa.dao.TenantRepository;
import com.kdu.jpa.entity.Shift;
import com.kdu.jpa.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;
    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository=tenantRepository;
    }
    public void saveTenant(Tenant tenant){
        tenantRepository.save(tenant);
    }

}

