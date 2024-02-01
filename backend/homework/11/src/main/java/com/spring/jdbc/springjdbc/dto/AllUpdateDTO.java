package com.spring.jdbc.springjdbc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@Builder
public class AllUpdateDTO {
        private TenantDTO tenantDTO;
        private ShiftUserDTO shiftUserDTO;
        private ShiftDTO shiftDTO;
        private ShiftTypeDTO shiftTypeDTO;
        private UserDTO userDTO;
}
