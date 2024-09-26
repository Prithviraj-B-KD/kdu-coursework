package com.kdu.smartHome.service;


import com.kdu.smartHome.DTO.InventoryRequest;
import com.kdu.smartHome.dao.InventoryRepository;
import com.kdu.smartHome.entity.Inventory;
import com.kdu.smartHome.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    InventoryRepository inventoryRepository;
    InventoryMapper inventoryMapper;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository,InventoryMapper inventoryMapper) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryMapper = inventoryMapper;
    }

    public Inventory addDeviceToInventory(InventoryRequest inventoryRequest){
        Inventory inventory =inventoryMapper.mapInventoryRequest(inventoryRequest);
        inventoryRepository.save(inventory);
        return inventory;

    }

    public List<Inventory> displayInventory(){
        return inventoryRepository.findAll();
    }
}
