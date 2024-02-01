package com.spring.jdbc.springjdbc.dao;

import com.spring.jdbc.springjdbc.dto.ShiftDTO;
import com.spring.jdbc.springjdbc.exception.custom.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

@Repository
@Slf4j
public class ShiftDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShiftDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addShift(ShiftDTO shiftDTO) {

        try {
            String sqlStatement = "INSERT INTO shifts (shift_type_id, name, date_start, date_end,time_start, time_end,tenant_id,time_zone) VALUES (?, ?, ?, ?, ?, ?,?,?)";

            return jdbcTemplate.update((connection) -> {
                PreparedStatement ps = connection.prepareStatement(sqlStatement);
                ps.setObject(1, shiftDTO.getShiftTypeId());
                ps.setString(2, shiftDTO.getName());
                ps.setDate(3, new java.sql.Date(shiftDTO.getDateStart().getTime()));
                ps.setDate(4, new java.sql.Date(shiftDTO.getDateEnd().getTime()));
                ps.setTimestamp(5, shiftDTO.getTimeStart());
                ps.setTimestamp(6, shiftDTO.getTimeEnd());
                ps.setObject(7, shiftDTO.getTenantId());
                ps.setString(8,shiftDTO.getTimeZone());

                return ps;
            });
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }
    public List<ShiftDTO> getShift(UUID tenantId)
    {
        return null;
    }
}
