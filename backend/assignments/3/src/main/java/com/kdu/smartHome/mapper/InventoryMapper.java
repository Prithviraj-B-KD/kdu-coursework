package com.kdu.smartHome.mapper;

import com.kdu.smartHome.DTO.InventoryRequest;
import com.kdu.smartHome.entity.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    public Inventory mapInventoryRequest(InventoryRequest inventoryRequest){
        return Inventory.builder()
                .kickstonId(inventoryRequest.getKickstonId())
                .deviceUsername(inventoryRequest.getDeviceUsername())
                .devicePassword(inventoryRequest.getDevicePassword())
                .manufactureFactoryPlace(inventoryRequest.getManufactureFactoryPlace())
                .manufactureDateTime(inventoryRequest.getManufactureDateTime())
                .build();
    }
}
