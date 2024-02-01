package com.spring.jdbc.springjdbc.service;

import com.spring.jdbc.springjdbc.dao.TenantDAO;
import com.spring.jdbc.springjdbc.dto.TenantDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TenantService {
    TenantDAO tenantDAO;
    @Autowired
    TenantService(TenantDAO tenantDAO)
    {
        this.tenantDAO=tenantDAO;
    }

    public boolean addTenant(TenantDTO tenantDTO) {
        try{
            return  tenantDAO.addTenant(tenantDTO)!=0;
        } catch (Exception exception){
        log.error(exception.getMessage());
        return false;
        }
    }
}
