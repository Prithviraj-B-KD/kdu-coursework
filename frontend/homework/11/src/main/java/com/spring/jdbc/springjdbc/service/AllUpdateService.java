package com.spring.jdbc.springjdbc.service;

import com.spring.jdbc.springjdbc.dao.AllUpdateDAO;
import com.spring.jdbc.springjdbc.dto.AllUpdateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AllUpdateService {
    AllUpdateDAO allUpdateDAO;
    AllUpdateService(AllUpdateDAO allUpdateDAO)
    {
        this.allUpdateDAO = allUpdateDAO;
    }
    @Transactional
    public boolean addAll(AllUpdateDTO allUpdateDTO) {
        try{
        return allUpdateDAO.addAllUpdateDAO(allUpdateDTO)!=0;
         }catch (Exception exception){
            log.error(exception.getMessage());
            return false;
    }
    }
}
