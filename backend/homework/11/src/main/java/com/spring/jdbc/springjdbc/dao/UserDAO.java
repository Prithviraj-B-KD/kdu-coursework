package com.spring.jdbc.springjdbc.dao;

import com.spring.jdbc.springjdbc.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Slf4j
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addUser(UserDTO userDTO) {
        try {
            String sqlStatement = "INSERT INTO users (username, logged_in, time_zone, tenant_id) VALUES (?, ?, ?, ?)";
            return jdbcTemplate.update(sqlStatement, userDTO.getUsername(), true, userDTO.getTimeZone(), userDTO.getTenantId());
        } catch (Exception e) {
            log.error("An exception occurred while adding user: {}", e.getMessage());
            throw e;
        }
    }
    public List<UserDTO> getUsersByTenantId(UUID tenantId)
    {
        return null;
    }
    public void updateUser(String username,UUID userId)
    {

    }
}
