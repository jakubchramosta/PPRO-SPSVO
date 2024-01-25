package com.example.pprospsvo.services;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.repositories.VehicleRepo;
import com.example.pprospsvo.repositories.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WarehouseService {

    private WarehouseRepo warehouseRepo;
    private VehicleRepo vehicleRepo;

    @Autowired
    public WarehouseService(WarehouseRepo warehouseRepo, VehicleRepo vehicleRepo) {
        this.warehouseRepo = warehouseRepo;
        this.vehicleRepo = vehicleRepo;
    }

    public void add(Warehouse newWarehouse) {
        warehouseRepo.save(newWarehouse);
    }

    public List<Warehouse> getWarehouses() {
        return Collections.unmodifiableList(warehouseRepo.findAll());
    }

    public Warehouse getById(int id) {
        return warehouseRepo.getReferenceById(id);
    }

    public void deleteById(int id) {
        //Can cause problem if deleted while referenced by other classes
        warehouseRepo.deleteById(id);
    }
}
