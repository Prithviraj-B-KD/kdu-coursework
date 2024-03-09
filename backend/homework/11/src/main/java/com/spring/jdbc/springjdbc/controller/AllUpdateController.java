package com.spring.jdbc.springjdbc.controller;

import com.spring.jdbc.springjdbc.dto.AllUpdateDTO;
import com.spring.jdbc.springjdbc.service.AllUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AllUpdateController {
    AllUpdateService allUpdateService;
    @Autowired
    AllUpdateController(AllUpdateService allUpdateService)
    {
        this.allUpdateService = allUpdateService;
    }
    @PostMapping("update-all/add")
    public HttpEntity<String> addAllUsers(@RequestBody AllUpdateDTO allUpdateDTO)
    {
        try {
//            log.info(allUpdateDTO);
            if( allUpdateService.addAll(allUpdateDTO))
                return ResponseEntity.ok("Successfully added All.");

            else  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to add shift type");

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

    }
}
