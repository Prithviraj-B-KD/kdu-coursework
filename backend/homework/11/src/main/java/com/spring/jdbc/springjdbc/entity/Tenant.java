package com.spring.jdbc.springjdbc.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Data
@Component
@RequiredArgsConstructor
public class Tenant {
    private UUID id;
    private String tenantName;
}