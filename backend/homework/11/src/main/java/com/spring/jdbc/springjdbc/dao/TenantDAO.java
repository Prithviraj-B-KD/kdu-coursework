package com.spring.jdbc.springjdbc.dao;

import com.spring.jdbc.springjdbc.dto.TenantDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
@Slf4j
public class TenantDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TenantDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addTenant(TenantDTO tenantDTO) {
        String sqlStatement = "INSERT INTO tenants (tenant_name) VALUES (?)";
        return jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlStatement);
            ps.setString(1, tenantDTO.getTenantName());
            return ps;
        });
    }
}
