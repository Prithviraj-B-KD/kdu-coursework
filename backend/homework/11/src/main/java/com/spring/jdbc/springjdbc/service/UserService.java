package com.spring.jdbc.springjdbc.service;

import com.spring.jdbc.springjdbc.dao.UserDAO;
import com.spring.jdbc.springjdbc.dto.UserDTO;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean addUser(UserDTO user) {
        try {
            return userDAO.addUser(user) != 0;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return false;
        }
    }
    public List<UserDTO> getUsersByTenant(UUID tenantID) {
        try {
        return userDAO.getUsersByTenantId(tenantID);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return Collections.emptyList();
        }
    }
    public void updateUser(String username, UUID userid)
    {
        try
        {
            userDAO.updateUser(username,userid);
        }
        catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }
}
