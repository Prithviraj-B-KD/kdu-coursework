package com.kdu.smartHome.DTO;

import com.kdu.smartHome.entity.Inventory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private String message;
    private Inventory inventory;
    private HttpStatus status;
}
