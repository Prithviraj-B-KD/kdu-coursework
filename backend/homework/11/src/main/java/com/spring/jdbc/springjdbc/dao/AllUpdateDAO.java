package com.spring.jdbc.springjdbc.dao;

import com.spring.jdbc.springjdbc.dto.AllUpdateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class AllUpdateDAO {
    private final ShiftDAO shiftDAO;
    private final ShiftTypeDAO shiftTypeDAO;
    private final ShiftUserDAO shiftUserDAO;
    private final UserDAO userDAO;
    private final TenantDAO tenantDAO;

    @Autowired
    public AllUpdateDAO( ShiftDAO shiftDAO, ShiftTypeDAO shiftTypeDAO, ShiftUserDAO shiftUserDAO, UserDAO userDAO, TenantDAO tenantDAO) {
        this.shiftDAO = shiftDAO;
        this.shiftTypeDAO = shiftTypeDAO;
        this.shiftUserDAO = shiftUserDAO;
        this.userDAO = userDAO;
        this.tenantDAO = tenantDAO;
    }
    public int addAllUpdateDAO(AllUpdateDTO allUpdateDTO)
    {
        try
        {
            log.info("add shift user: "+shiftUserDAO.addShiftUser(allUpdateDTO.getShiftUserDTO()));
            log.info("add shift type: "+shiftTypeDAO.addShiftType(allUpdateDTO.getShiftTypeDTO()));
            log.info("add shift type: "+userDAO.addUser(allUpdateDTO.getUserDTO()));
            log.info("add shift: "+shiftDAO.addShift(allUpdateDTO.getShiftDTO()));
            log.info("add tenant type: "+tenantDAO.addTenant(allUpdateDTO.getTenantDTO()));
            return 1;
        }
        catch (Exception e)
        {
            log.error(e.toString());
            throw e;
        }
    }
}
