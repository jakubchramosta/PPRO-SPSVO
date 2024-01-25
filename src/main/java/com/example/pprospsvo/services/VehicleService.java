package com.example.pprospsvo.services;

import com.example.pprospsvo.model.Vehicle;
import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.repositories.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VehicleService {

    private VehicleRepo vehicleRepo;

    @Autowired
    public VehicleService(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    public void add(Vehicle newVehicle) {
        vehicleRepo.save(newVehicle);
    }

    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(vehicleRepo.findAll());
    }

    public Vehicle getById(int id) {
        return vehicleRepo.getReferenceById(id);
    }

    public void deleteById(int id) {
        //Can cause problem if deleted while referenced by other classes
        vehicleRepo.deleteById(id);
    }
}
