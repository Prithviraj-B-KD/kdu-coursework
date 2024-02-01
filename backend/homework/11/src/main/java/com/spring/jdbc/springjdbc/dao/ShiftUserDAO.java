package com.spring.jdbc.springjdbc.dao;

import com.spring.jdbc.springjdbc.dto.ShiftUserDTO;
import com.spring.jdbc.springjdbc.dto.UserDTO;

import java.sql.PreparedStatement;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Slf4j
public class ShiftUserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShiftUserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addShiftUser(ShiftUserDTO shiftUserDTO) {
        try {
            String sqlStatement = "INSERT INTO shift_users (shift_id, user_id, tenant_id) VALUES ( ?, ?, ?)";
            return jdbcTemplate.update((connection) -> {
                PreparedStatement ps = connection.prepareStatement(sqlStatement);
                ps.setObject(1, shiftUserDTO.getShiftId());
                ps.setObject(2, shiftUserDTO.getUserId());
                ps.setObject(3, shiftUserDTO.getTenantId());
                return ps;
            });
        } catch (Exception e) {
            log.error("An exception occurred while adding shift user: " + e.getMessage());
            throw e;
        }
    }
    public List<ShiftUserDTO> getShiftUserByTenantId(UUID tenantId)
    {
        return Collections.emptyList();
    }

}
