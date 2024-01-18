package com.example.pprospsvo.services;

import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.repositories.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {

    private WarehouseRepo warehouseRepo;

    @Autowired
    public WarehouseService(WarehouseRepo warehouseRepo) {
        this.warehouseRepo = warehouseRepo;
    }

    public void add(Warehouse newWarehouse) {
        warehouseRepo.save(newWarehouse);
    }
}
